package com.example.seatingarrangementapp.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.seatingarrangementapp.MainActivity;
import com.example.seatingarrangementapp.model.User;

import java.util.ArrayList;

public class ReservationService extends Service {

    private ArrayList<User> table;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.broadcastStringAction);
        table = intent.getParcelableArrayListExtra("table");
        broadcastIntent.putParcelableArrayListExtra("table", table);

        sendBroadcast(broadcastIntent);

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
