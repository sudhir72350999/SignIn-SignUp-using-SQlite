package com.sudhirtheindian4.mysigninsignupsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,confirmpassword;
    Button SignIn, SignUp;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        confirmpassword= findViewById(R.id.confirmpassword);
        SignIn = findViewById(R.id.signIn);
        SignUp = findViewById(R.id.signUp);
        DB  = new DBHelper(this);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirmPass = confirmpassword.getText().toString();



                if(user.equals("")||pass.equals("")||confirmPass.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter the all field", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (pass.equals(confirmPass)){
                        Boolean checkUser = DB.checkUserName(user);
                        if(checkUser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert ==true){
                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,DashBoardActivity.class);
                                startActivity(intent);
                                finish();

                            }
                            else{
                                Toast.makeText(MainActivity.this, "Registeration  failed", Toast.LENGTH_SHORT).show();

                            }


                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists please sign in ", Toast.LENGTH_SHORT).show();

                        }

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Password not matching ", Toast.LENGTH_SHORT).show();

                    }


                }




            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();




//                    Toast.makeText(MainActivity.this, "user already exists please sign in", Toast.LENGTH_SHORT).show()
            }
        });

    }
}