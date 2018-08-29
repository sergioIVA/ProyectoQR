package com.example.ingenierosergio.proyectoprueba;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class SimpleScannerActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler{

    private static final String TAG = "SimpleScannerActivity";
    private ZBarScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scanner);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result result) {

        final String code=result.getContents();
        final String format=result.getBarcodeFormat().getName();
        final String fullMessage="Contents= "+code+", Format="+format;

     try{
         Uri notification= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
         Ringtone r=RingtoneManager.getRingtone(getApplicationContext(),notification);
         r.play();
     }catch (Exception e){
         Log.e(TAG,e.getLocalizedMessage());
     }
        mScannerView.resumeCameraPreview(this);


                           if(code.equals("BANANO")) {


                               Toast.makeText(this, fullMessage, Toast.LENGTH_SHORT).show();
                           }
    }
}
