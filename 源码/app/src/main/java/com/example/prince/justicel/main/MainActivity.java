package com.example.prince.justicel.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prince.justicel.R;
import com.example.prince.justicel.register.RegisterActivity;
import com.example.prince.justicel.signin.SignInMainActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends Activity {
    private Button sign_in,regist;
    private EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        //getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main);

        Bmob.initialize(this,"2407fe112f56a5942448e9772e3c52a7");


        sign_in = (Button)findViewById(R.id.signin);//登陆
        regist = (Button)findViewById(R.id.register);//注册
        user = (EditText)findViewById(R.id.username);//账号
        pass = (EditText)findViewById(R.id.password);//密码


        /**
         * 登陆
         */
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser sg = new BmobUser();
                String user_in = user.getText().toString();
                String pass_in = pass.getText().toString();
                sg.setUsername(user_in);
                sg.setPassword(pass_in);


                sg.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser sg, BmobException e) {
                        if (e == null) {
                            Intent sign_in = new Intent(MainActivity.this, SignInMainActivity.class);
                            startActivity(sign_in);

                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                        } else {
                            Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        /**
         * 注册
         */
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

    }
}
