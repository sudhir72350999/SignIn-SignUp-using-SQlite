package com.sudhirtheindian4.mysigninsignupsp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.about_us){
            // to do search icon
            Toast.makeText(this, " know about me", Toast.LENGTH_SHORT).show();
            return  true;
        }

        else if(id==R.id.contact_us){
            // to do cart icon
            Toast.makeText(this, " contact me", Toast.LENGTH_SHORT).show();

            return  true;


        }else  if(id==R.id.shop_type){
            // to do notification icon
            Toast.makeText(this, " know my shop type", Toast.LENGTH_SHORT).show();


            return  true;


        }
        else  if(id==R.id.shop_address){
            // to do notification icon
            Toast.makeText(this, " know about shop address", Toast.LENGTH_SHORT).show();


            return  true;


        }
        return super.onOptionsItemSelected(item);



    }


    }
