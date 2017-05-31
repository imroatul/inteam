package com.tolahtoleh.tolahtolehbeta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KING on 18/05/2017.
 */

public class LoginMember extends AppCompatActivity implements View.OnClickListener {
    private TextView daftar;
    private EditText emailmember,passwordmember;
    private Button btnlogin;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_member);

        daftar = (TextView)findViewById(R.id.textdaftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupMember.class);
                startActivity(i);
            }
        });

      /* if (SharedPrefManager.getInstance(this).isLoggedIn()){
            //finish();
            //startActivity(new Intent(this,ProfileActivity.class));
            return;
        }*/
        //LOGIN
        emailmember = (EditText) findViewById(R.id.emailmember);
        passwordmember = (EditText) findViewById(R.id.passwordmember);
        btnlogin = (Button) findViewById(R.id.buttonLogin);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        btnlogin.setOnClickListener(this);
    }
    private void userLogin(){
        final String email = emailmember.getText().toString().trim();
        final String password = passwordmember.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(obj.getBoolean("error") == false){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("emailmember"),
                                                obj.getString("passwordmember")
                                        );

                                Toast.makeText(
                                        getApplicationContext(),
                                        "User Login Successful",
                                        Toast.LENGTH_LONG
                                ).show();
                                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                //finish();
                            }else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("emailmember",email);
                params.put("passwordmember",password);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == btnlogin){
            userLogin();
        }
    }
}
