package com.example.hardiklodhari.barcodegenrator;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * Created by Hardik Lodhari on 19-04-2016.
 */
public class Barcode extends AppCompatActivity implements OnClickListener
{
    Button button1;
    EditText ed1;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode);
        Intent i=getIntent();
        button1 = (Button) findViewById(R.id.button3);
        ed1 = (EditText) findViewById(R.id.editText2);
        img1 = (ImageView) findViewById(R.id.imageView3);

        button1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        String data = ed1.getText().toString();
        if (data.trim().length() == 0) {
            Toast.makeText(getBaseContext(), "Please Enter Text", Toast.LENGTH_SHORT).show();
        }

        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            int width = 512, height = 512, i, j;
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.CODE_128, 512, 512);
            width = bitMatrix.getWidth();
            height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (i = 0; i < width; i++) {
                for (j = 0; j < height; j++) {
                    bmp.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
            ((ImageView) findViewById(R.id.imageView2)).setImageBitmap(bmp);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
