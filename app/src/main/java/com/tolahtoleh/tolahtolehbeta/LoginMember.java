package com.tolahtoleh.tolahtolehbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by KING on 18/05/2017.
 */

public class LoginMember extends AppCompatActivity {
    private TextView signup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_member);

        signup = (TextView)findViewById(R.id.signout);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupMember.class);
                startActivity(i);
            }
        });
    }

        /*Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent l = new Intent(getApplicationContext(),SignupMember.class);
                startActivity(l);
            }
        });*/
}
