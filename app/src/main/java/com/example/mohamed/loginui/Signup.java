package com.example.mohamed.loginui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mohammed on 13/06/18.
 */

public class Signup extends Activity {
    EditText e1;
    EditText e2;
    EditText e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    public void signer(View v){
        e1 = (EditText)findViewById(R.id.user);
        e2 = (EditText)findViewById(R.id.pass);
        e3 = (EditText)findViewById(R.id.conf);
        if (e2.getText().toString().equals(e3.getText().toString())){
            User user = new User(e1.getText().toString(),e2.getText().toString());
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("user",e1.getText().toString());
            intent.putExtra("pass",e2.getText().toString());
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Mot de Passe différent",Toast.LENGTH_SHORT).show();
        }
    }
}
