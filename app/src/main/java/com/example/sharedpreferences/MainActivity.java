package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences" , Context.MODE_PRIVATE);


        //  Adding the data to storage
//        sharedPreferences.edit().putString("username" , "rob").apply();

        //  Fetching the data from storage
        String userName = sharedPreferences.getString("username" , "");

        Log.d(TAG, "onCreate: " + userName);


        ArrayList<String> friends = new ArrayList<>();

        friends.add("Monica");
        friends.add("Chandler");


        //  Adding the arraylist to storage
        /*
        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
        } catch (Exception e){
            Log.e(TAG, "onCreate: errror "+ e.getMessage() );
        }
         */

        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends =(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e){
            Log.e(TAG, "onCreate: error "+ e.getMessage() );
        }

        Log.d(TAG, "onCreate: newfriends " + newFriends.toString());
    }
}
