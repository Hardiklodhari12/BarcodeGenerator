package com.example.hardiklodhari.barcodegenrator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements OnClickListener

{
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }


            public void onClick(View v) {
                try {
                    if (v.getId() == R.id.button)
                    {

                        Intent i = new Intent(MainActivity.this,Barcode.class);
                        startActivity(i);

                    }
                    else {
                        Intent i = new Intent(MainActivity.this, QrCode.class);
                        startActivity(i);

                    }
                }
                catch (Exception e){

                }
            }
        }


