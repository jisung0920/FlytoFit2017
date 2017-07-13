package com.example.hojan.flytofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ResiterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resiter);

        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        EditText passwordText2 = (EditText) findViewById(R.id.passwordText2);
        EditText nameText = (EditText) findViewById(R.id.nameText);

        Button ragisterButton = (Button) findViewById(R.id.registerButton);
    }


}
