package com.example.hiran.smartboard;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EC extends AppCompatActivity {


    RecyclerView recyclerView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec);
        EC.syncData as=new EC.syncData();
        as.execute();
    }
    private class syncData extends AsyncTask
    {

        ArrayList<String> arr=new ArrayList<String>();
        ArrayList<Blob> blobArray=new ArrayList<Blob>();
        ArrayList<InputStream> ipArray=new ArrayList<InputStream>();

        @Override
        protected Object doInBackground(Object[] objects) {

            String url="jdbc:mysql://10.0.2.2:3306/smartbulletin?autoReconnect=true";
            String uname="root";
            String pass="1234";



            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection(url,uname,pass);
                Log.i("connect","Connection successful");
                PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from smartbulletin WHERE branch =  ?");
                preparedStatement.setString(1,"EC");
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next())
                {
                    arr.add("title:"+rs.getObject(2)+"\n \n"+"Date"+rs.getObject(3)+"\n \n"+rs.getObject(4));
                    blobArray.add(rs.getBlob(5));
                    ipArray.add(rs.getBlob(5).getBinaryStream());
                }







            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {

            recyclerView=findViewById(R.id.rv);
            String[] s=arr.toArray(new String[arr.size()]);

            Log.i("size", String.valueOf(arr.size()));
            recyclerView.setLayoutManager(new LinearLayoutManager(EC.this));
            final adapter adapt=new adapter(EC.this,s,ipArray);
            recyclerView.setAdapter(adapt);
        }
    }
}
