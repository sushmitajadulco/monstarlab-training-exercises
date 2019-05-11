package com.example.seatingarrangementapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.seatingarrangementapp.database.DatabaseHelper;
import com.example.seatingarrangementapp.service.ReservationService;
import com.example.seatingarrangementapp.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Context context;

    public static final int CREATE_USER_REQUEST = 1106;

    private ArrayList<User> table1_users = new ArrayList<>();
    private ArrayList<User> table2_users = new ArrayList<>();
    private ArrayList<User> table3_users = new ArrayList<>();
    private ArrayList<User> table4_users = new ArrayList<>();

    public static final String broadcastStringAction = "com.broadcast.reservation";
    private IntentFilter intentFilter;
    public static final String TAG = MainActivity.class.getSimpleName();
    private UserRecyclerAdapter userRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        Button table[] = new Button[4];

        table[0] = findViewById(R.id.table_one);
        table[1] = findViewById(R.id.table_two);
        table[2] = findViewById(R.id.table_three);
        table[3] = findViewById(R.id.table_four);

        intentFilter = new IntentFilter();
        intentFilter.addAction(broadcastStringAction);

        for(int i=0;i<4;i++) {
            final int index = i;
            table[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(index == 0) {
                        passDataToTable(table1_users);
                    } else if(index == 1) {
                        passDataToTable(table2_users);
                    } else if(index == 2) {
                        passDataToTable(table3_users);
                    } else if (index == 3) {
                        passDataToTable(table4_users);
                    }
                }
            });
       }

        databaseHelper = new DatabaseHelper(context);
        userRecyclerAdapter = new UserRecyclerAdapter();
        userRecyclerAdapter.notifyDataSetChanged();
    }

    private void passDataToTable(ArrayList<User> table) {
        Intent createUserIntent = new Intent(context, ReservationService.class);
        createUserIntent.putParcelableArrayListExtra("table", table);
        startService(createUserIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(reservationReceiver, intentFilter);

        table1_users = databaseHelper.getUsers(0);
        table2_users = databaseHelper.getUsers(5);
        table3_users = databaseHelper.getUsers(10);
        table4_users = databaseHelper.getUsers(15);

    }

    private BroadcastReceiver reservationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ArrayList<User> table;

            if(intent.getAction().equals(broadcastStringAction)) {

                Intent createUserIntent = new Intent(context, TableListActivity.class);
                table = intent.getParcelableArrayListExtra("table");
                createUserIntent.putParcelableArrayListExtra("table", table);
                startActivityForResult(createUserIntent, CREATE_USER_REQUEST);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent createUserIntent = new Intent(context, RegisterUserActivity.class);
                startActivityForResult(createUserIntent, MainActivity.CREATE_USER_REQUEST);
                break;
            case R.id.menu_clear_list:
                table1_users.clear();
                table2_users.clear();
                table3_users.clear();
                table4_users.clear();
                userRecyclerAdapter.clearUsers();
                userRecyclerAdapter.notifyDataSetChanged();
                databaseHelper.deleteAllUsers();
                break;
           default:
               super.onOptionsItemSelected(item);
               break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
           case MainActivity.CREATE_USER_REQUEST:
                if (resultCode == RESULT_OK) {
                    User user = null;
                    if (data != null) {
                        user = data.getParcelableExtra("user");
                    }
                    if (user != null && !user.getFullName().equals("")) {
                        if(table1_users.size()!= 5 ) {
                            table1_users.add(user);
                            addUserToTable(user, table1_users);
                        } else if (table2_users.size() != 5 ) {
                            table2_users.add(user);
                            addUserToTable(user, table2_users);
                        } else if (table3_users.size() != 5 ) {
                            table3_users.add(user);
                            addUserToTable(user, table3_users);
                        } else if (table4_users.size() != 5 ) {
                            table4_users.add(user);
                            addUserToTable(user, table4_users);
                        } else {
                            showNotification();
                        }
                    }
                    if( user.getFullName().equals("") ) {
                        Toast.makeText(context, "You did not input user information.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private void addUserToTable(User user, ArrayList<User> table) {
        userRecyclerAdapter.setUserList(table);
        userRecyclerAdapter.notifyDataSetChanged();
        databaseHelper.insertUser(user);
        showAlertDialog();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("User has been added.")
                .setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showNotification() {
        NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int icon = R.mipmap.ic_launcher;
        String contentTitle = "Cannot Add User";
        String contentText = "Tables are already full.";

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, notificationIntent, 0);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(false);
        builder.setContentTitle(contentTitle);
        builder.setContentText(contentText);
        builder.setSmallIcon(icon);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setNumber(100);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "notify_001";
            NotificationChannel channel = new NotificationChannel( channelId, "Channel 001", NotificationManager.IMPORTANCE_DEFAULT);
            notiManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        Notification notification = builder.build();
        notiManager.notify(11, notification);
    }
}
