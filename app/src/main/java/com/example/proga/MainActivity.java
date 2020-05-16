package com.example.proga;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   private Button button;
   private Button button2;
    Switch btSwitch;
    private Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    android.hardware.Camera.Parameters params;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 =(Button)findViewById(R.id.button2);
        btSwitch = (Switch)findViewById(R.id.bt_switch);
        btSwitch.setChecked (false);
        btSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    setFlashLightOn();
                } else {
                    setFlashLightOff();
                }
            }
        });
        boolean isCameraFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!isCameraFlash) {
            showCameraAlert();
        } else {

        }
    }

    private void showCameraAlert() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.error)
                .setIcon(android.R.drawable.ic_dialog_alert).show();
        return;

    }

    private void setFlashLightOn() {
    }

        private void setFlashLightOff () { new AlertDialog.Builder(this).setMessage(R.string.work)
                        .setIcon(android.R.drawable.ic_dialog_alert).show();return;
                }


                public boolean onCreateOptionsMenu (Menu menu){
                    getMenuInflater().inflate(R.menu.light_menu, menu);
                    return true;
                }

            }