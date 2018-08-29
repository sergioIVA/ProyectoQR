package com.example.ingenierosergio.proyectoprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG ="MainActivity" ;
    private ZBarScannerView mScannerView;
    private Button btnCaptureCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCaptureCode=(Button)findViewById(R.id.btnCaptureCode);
        btnCaptureCode.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnCaptureCode:
                Intent intent=new Intent(this,SimpleScannerActivity.class);
                startActivity(intent);
                break;
        }

    }
}
