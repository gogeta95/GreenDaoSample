package com.example.saurabh.greendaosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.saurabh.greendaosample.dao.User;
import com.example.saurabh.greendaosample.dao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.text);
        UserDao userDao = MainApplication.getDaoSession().getUserDao();
        List<User> users = userDao.queryBuilder().where(UserDao.Properties.Name.eq("Saurabh")).build().list();
        Log.d(TAG, "users: " + users);
        User saurabh = users.get(1);
        if (saurabh == null) {
            Log.d(TAG, "onCreate: Saurabh not in db!");
            User user = new User("Saurabh");
            userDao.insertInTx(user);
        } else {
            tv.setText(saurabh.getName() + " : " + saurabh.getId());
        }
    }
}
