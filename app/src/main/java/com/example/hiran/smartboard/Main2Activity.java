package com.example.hiran.smartboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void click(View view) throws ClassNotFoundException {
        String s=getResources().getResourceEntryName(view.getId());
        Log.d("string",s);
        String act=null;

        switch (s)
        {
            case "idCard":act="com.example.hiran.smartboard.IT";
                    break;

            case "coCard":act="com.example.hiran.smartboard.CO";
                break;

            case "civilCard":act="com.example.hiran.smartboard.civil";
                break;

            case "ecCard":act="com.example.hiran.smartboard.EC";
                break;

            case "mcaCard":act="com.example.hiran.smartboard.MCA";
                break;

            case "elecCard":act="com.example.hiran.smartboard.electrical";
                break;

            case "icCard":act="com.example.hiran.smartboard.ic";
                break;

            case "textileCard":act="com.example.hiran.smartboard.tt";
                break;

            case "chemCard":act="com.example.hiran.smartboard.chemical";
                break;

            case "forAllCard":act="com.example.hiran.smartboard.ForAll";
                break;
        }
        Log.d("Class",act);
        Intent i = new Intent(Main2Activity.this, Class.forName(act));
        startActivity(i);



    }




}
