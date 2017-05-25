package com.tolahtoleh.tolahtolehbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by KING on 18/05/2017.
 */

public class SignupMember extends AppCompatActivity {
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_member);

        /**getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setTitle("Daftar");
*/
        login = (TextView)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(), LoginMember.class);
                startActivity(j);
            }
        });
    }
}