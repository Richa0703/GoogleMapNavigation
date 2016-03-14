package com.example.richapandey.googlenavigation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtSource;
    EditText edtDestination;
    TextView txtTo;
    TextView txtFrom;
    Button btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByID();

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = edtSource.getText().toString();
                System.out.print("Before" + source);
                source = source.replace(" ", "+");
                source = source.replace(",", "+");
                System.out.println("Aftert" + source);
                String destination = edtDestination.getText().toString();
                System.out.print("Before" + destination);
                destination = destination.replace(" ", "+");
                destination = destination.replace(",", "+");
                System.out.println("After" + destination);
                //using google map through intent

                Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/dir/"+source+"/"+destination));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);

            }
        });


    }

    void findViewByID() {
        txtTo = (TextView) findViewById(R.id.to);
        txtFrom = (TextView) findViewById(R.id.from);
        edtSource = (EditText) findViewById(R.id.source);
        edtDestination = (EditText) findViewById(R.id.destination);
        btnMap = (Button) findViewById(R.id.navigate);


    }


}
