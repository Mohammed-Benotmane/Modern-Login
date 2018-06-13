package com.example.mohamed.loginui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by mohamed on 13/06/18.
 */

public class Profil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        Intent intent = getIntent();
        TextView t1 = (TextView)findViewById(R.id.welcome);
        t1.setText("Welcome " + intent.getStringExtra("user"));
    }
}
