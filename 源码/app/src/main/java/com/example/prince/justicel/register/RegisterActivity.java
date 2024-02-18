package com.example.prince.justicel.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prince.justicel.R;
import com.example.prince.justicel.main.MainActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends Activity{
    private EditText in_user,in_pass;
    private Button suc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bmob.initialize(this,"2407fe112f56a5942448e9772e3c52a7");

        in_user = (EditText) findViewById(R.id.in_username);
        in_pass = (EditText) findViewById(R.id.in_password);
        suc = (Button) findViewById(R.id.suc_register);

        suc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser re = new BmobUser();
                String user = in_user.getText().toString();
                String pass = in_pass.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    return;
                }
                re.setUsername(user);
                re.setPassword(pass);

                re.signUp(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                Intent back = new Intent(RegisterActivity.this, MainActivity.class);

                startActivity(back);
            }
        });
    }
}
