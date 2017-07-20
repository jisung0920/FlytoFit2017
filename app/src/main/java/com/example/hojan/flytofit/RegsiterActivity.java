package com.example.hojan.flytofit;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegsiterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText passwordText2 = (EditText) findViewById(R.id.passwordText2);
        final EditText nameText = (EditText) findViewById(R.id.nameText);

        Button registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                String userPassword = idText.getText().toString();
                String userName = idText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegsiterActivity.this);
                                builder.setMessage("회원 등록 완료.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(RegsiterActivity.this, LoginActivity.class);
                                RegsiterActivity.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegsiterActivity.this);
                                builder.setMessage("회원 등록 실패!")
                                        .setPositiveButton("다시 시도",null)
                                        .create()
                                        .show();
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                };
                RegsiterRequest registerRequest = new RegsiterRequest(userID, userPassword, userName, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegsiterActivity.this);
                queue.add(registerRequest);
            }
        });
    }


}
