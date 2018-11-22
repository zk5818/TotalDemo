package com.test.totaldemp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.totaldemp.R;
import com.test.totaldemp.application.MyApplication;
import com.test.totaldemp.gen.AreaDao;
import com.test.totaldemp.gen.UserDao;
import com.test.totaldemp.greendaoentity.User;

import java.util.List;

public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user_id, user_name;
    TextView tvdata;
    Button add, delete, update, search, searchById;
    UserDao mUserDao;
    AreaDao mAreaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        user_id = (EditText) findViewById(R.id.user_id);
        user_name = (EditText) findViewById(R.id.user_name);
        tvdata = (TextView) findViewById(R.id.tvdata);

        delete = (Button) findViewById(R.id.delete);
        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        search = (Button) findViewById(R.id.search);
        searchById = (Button) findViewById(R.id.searchById);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        search.setOnClickListener(this);
        searchById.setOnClickListener(this);
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        mAreaDao = MyApplication.getInstances().getDaoSession().getAreaDao();
    }

    User mUser;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                mUser = new User(Long.parseLong(user_id.getText().toString()), user_name.getText().toString());
                mUserDao.insert(mUser);//添加一个
                break;
            case R.id.delete:
                mUserDao.deleteByKey(Long.parseLong(user_id.getText().toString()));
                break;
            case R.id.update:
                mUser = new User(Long.parseLong(user_id.getText().toString()), user_name.getText().toString());
                mUserDao.update(mUser);
                break;
            case R.id.search:
                List<User> users = mUserDao.loadAll();
                String userName = "";
                for (int i = 0; i < users.size(); i++) {
                    userName += users.get(i).getId() + "--" + users.get(i).getName() + ",";
                    userName = userName + "\n";
                }
                tvdata.setText("查询全部数据==>\n" + userName);
                return;
            case R.id.searchById:
                User user = mUserDao.load(Long.parseLong(user_id.getText().toString()));
                tvdata.setText("查询user数据==>\n" + user.toString());
                return;
        }
        List<User> users = mUserDao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getId() + "--" + users.get(i).getName() + ",";
            userName = userName + "\n";
        }
        tvdata.setText("查询全部数据==>\n" + userName);

    }
}
