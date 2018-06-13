package com.example.mohamed.loginui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by mohamed on 13/06/18.
 */

public class UserBDD {
    private SQLiteDatabase bdd;
    private LoginSQLite loginTable;
    public UserBDD(Context context){
        loginTable = new LoginSQLite(context,"login.db",null,1);
    }
    public void openWriter(){
        bdd = loginTable.getWritableDatabase();
    }
    public void openReadable(){
        bdd = loginTable.getReadableDatabase();
    }
    public void close(){
        bdd.close();
    }
    public SQLiteDatabase getBdd(){
        return bdd;
    }
    public long insertUser(User user){
        ContentValues content = new ContentValues();
        content.put("username",user.getUsername());
        content.put("password",user.getPassword());
        return bdd.insert("User",null,content);
    }
    public ArrayList<User> getAllUser(){
        Cursor c = bdd.query("User",new String[] {"id","username","password"},null,null,null,null,"id");
        if(c.getCount()==0){
            c.close();
            return null;
        }
        ArrayList<User> liste = new ArrayList<User>();
        while(c.moveToNext()){
            User user = new User();
            user.setId(c.getInt(0));
            user.setUsername(c.getString(1));
            user.setPassword(c.getString(2));
            liste.add(user);
        }
        c.close();
        return liste;
    }
    public User cursorToUser(Cursor c){
        if(c.getCount()==0){
            c.close();
            return null;
        }
        User user = new User();
        user.setId(c.getInt(0));
        user.setUsername(c.getString(1));
        user.setPassword(c.getString(2));
        c.close();
        return user;
    }


}
