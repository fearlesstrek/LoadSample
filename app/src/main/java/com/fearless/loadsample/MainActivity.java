package com.fearless.loadsample;

import android.app.Dialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.fearless.loadsample.dao.DaoMaster;
import com.fearless.loadsample.dao.DaoSession;
import com.fearless.loadsample.dao.UserEntityDao;
import com.fearless.loadsample.entity.UserEntity;
import com.fearless.loadsample.util.LoadingUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog dialog = LoadingUtil.showLoadDialog(this, "加载中...");
        dialog.show();
        userName = (TextView) findViewById(R.id.userName);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "notes-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        final UserEntityDao userDao = daoSession.getUserEntityDao();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                UserEntity userEntity = new UserEntity(null,"wxt");
                userDao.insert(userEntity);

                List<UserEntity> userEntityList =  userDao.queryBuilder().build().list();
                userName.setText(userEntityList.get(1).getId() + "---" + userEntityList.get(0).getUserName());
                Toast.makeText(getApplicationContext(), "加载完成", Toast.LENGTH_LONG).show();
            }
        }, 3000);

    }
}
