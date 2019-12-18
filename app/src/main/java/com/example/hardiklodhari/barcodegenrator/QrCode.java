package com.example.hardiklodhari.barcodegenrator;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Created by Hardik Lodhari on 19-04-2016.
 */
public class QrCode extends AppCompatActivity implements OnClickListener
{
    Button button2;
    EditText ed2,ed3,ed4,ed5;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr);

        Intent i=getIntent();
        button2 = (Button) findViewById(R.id.button4);
        ed2 = (EditText) findViewById(R.id.editText3);
        ed3 = (EditText) findViewById(R.id.editText4);
        ed4 = (EditText) findViewById(R.id.editText5);
        ed5 = (EditText) findViewById(R.id.editText6);
        img2 = (ImageView) findViewById(R.id.imageView3);

        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String data = ed2.getText().toString()+ed3.getText().toString()+ed4.getText().toString()+ed5.getText().toString();
        if (data.trim().length() == 0) {
            Toast.makeText(getBaseContext(), "Please Enter Text", Toast.LENGTH_SHORT).show();
        }

        QRCodeWriter writer = new QRCodeWriter();
        try {
            int width = 512, height = 512, i, j;
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512);
            width = bitMatrix.getWidth();
            height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (i = 0; i < width; i++) {
                for (j = 0; j < height; j++) {
                    bmp.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
            ((ImageView) findViewById(R.id.imageView3)).setImageBitmap(bmp);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
