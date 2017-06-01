package com.tolahtoleh.tolahtolehbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView viewname,viewemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
      /*  if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginMember.class));
        }*/
        viewname = (TextView)findViewById(R.id.viewname);
        viewemail = (TextView)findViewById(R.id.viewemail);

        viewname.setText(SharedPrefManager.getInstance(this).getUsername());
        viewemail.setText(SharedPrefManager.getInstance(this).getUserEmail());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                SharedPrefManager.getInstance(this).Logout();
                finish();
                startActivity(new Intent(this, Home.class));
                break;
            case R.id.action_aboutus:
                startActivity(new Intent(this, AboutUs.class));
                break;
        }
        return true;
    }
}
