package com.example.mohamed.loginui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UserBDD bdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdd= new UserBDD(MainActivity.this);
        bdd.openWriter();
        User user1 = new User("moha","moha");
        bdd.insertUser(user1);
        bdd.close();

    }
    public void signup(View v){
        Intent intent = new Intent(MainActivity.this,Signup.class);
        startActivity(intent);
    }
    public void imageBtn(View v){
        EditText e1 = (EditText)findViewById(R.id.editText);
        EditText e2 = (EditText)findViewById(R.id.editText2);
        bdd.openReadable();
        boolean var = false;
        int j=0;
        try{
        for (int i = 0;i<bdd.getAllUser().size();i++){
            if(e1.getText().toString().equals(bdd.getAllUser().get(i).getUsername()) && bdd.getAllUser().get(i).getPassword().equals(e2.getText().toString())){
                var= true;
                j=i;
                break;
            }}}
            catch (Exception e){
                Toast.makeText(MainActivity.this,"tpz or Password Incorrect",Toast.LENGTH_SHORT).show();

            }
        if(var){
            Intent intent = new Intent(MainActivity.this,Profil.class);
            intent.putExtra("user",bdd.getAllUser().get(j).getUsername());
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"Username or Password Incorrect",Toast.LENGTH_SHORT).show();
        }
        bdd.close();
    }
}
