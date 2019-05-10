package comjadulco.jasper_exercise_2.dto;


import java.sql.Timestamp;
import java.util.Date;

public class InmateDto {

    enum Sex {
        FEMALE, MALE
    }

    private String first_name;

    private String last_name;

    private Sex sex;

    private String nationality;

    private Date birth_date;

    private Timestamp detention_date;

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setBirth_date(Timestamp birth_date) {
        this.birth_date = birth_date;
    }

    public Timestamp getDetention_date() {
        return detention_date;
    }

    public void setDetention_date(Timestamp detention_date) {
        this.detention_date = detention_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
