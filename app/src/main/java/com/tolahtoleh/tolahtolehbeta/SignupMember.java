package com.tolahtoleh.tolahtolehbeta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KING on 18/05/2017.
 */

public class SignupMember extends AppCompatActivity implements View.OnClickListener {
    private TextView login;

    private EditText namamember,passwordmember,emailmember;
    private Button buttonRegister;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_member);

        /**getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setTitle("Daftar");
*/
        login = (TextView)findViewById(R.id.login);
        login.setOnClickListener(this);
      /*  login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(), LoginMember.class);
                startActivity(j);
            }
        });*/

      /*  if (SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,ProfileActivity.class));
            return;
        }*/
        //SIGN UP / REGISTER
        namamember = (EditText) findViewById(R.id.namamember);
        passwordmember = (EditText) findViewById(R.id.passwordmember);
        emailmember = (EditText) findViewById(R.id.emailmember);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);

    }

    private void registerUser() {

        final String email = emailmember.getText().toString().trim();
        final String password = passwordmember.getText().toString().trim();
        final String nama = namamember.getText().toString().trim();

        progressDialog.setMessage("Register User... ");
        progressDialog.show();

        StringRequest stringrequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"),Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplication(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("emailmember",email);
                params.put("passwordmember",password);
                params.put("namamember",nama);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
        startActivity(new Intent(this, LoginMember.class));
    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister)
            registerUser();
        if(v == login)
            startActivity(new Intent(this, LoginMember.class));
    }
}