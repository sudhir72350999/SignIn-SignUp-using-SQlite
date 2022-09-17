package com.sudhirtheindian4.mysigninsignupsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username=findViewById(R.id.username1);
        password= findViewById(R.id.password1);
        login= findViewById(R.id.logIn);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LogInActivity.this,"please enter the field ", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LogInActivity.this, " sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),DashBoardActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LogInActivity.this, "this in invalid ", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

    }
}