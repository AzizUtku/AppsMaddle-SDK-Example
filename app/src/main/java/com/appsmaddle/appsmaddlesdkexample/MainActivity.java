package com.appsmaddle.appsmaddlesdkexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

import com.appsmaddle.appsmaddlesdkexample.models.Config;
import com.appsmaddle.sdk.AppsMaddle;
import com.appsmaddle.sdk.interfaces.OnLoadListener;

public class MainActivity extends AppCompatActivity {

    private Config mConfig = null;
    private final String API_KEY = "YOUR_API_KEY";
    private final String APP_KEY = "YOUR_APP_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing
        AppsMaddle.init(this, API_KEY, APP_KEY);

        //Get config from server
        AppsMaddle.loadConfig(Config.class, new OnLoadListener<Config>() {
            @Override
            public void onLoaded(Config config) {
                mConfig = config;

                //Check flag is toggled
                if(mConfig.multilingual.show_message) {
                    //Show alert dialog with loaded config.
                    showAlertDialog(mConfig.multilingual.message_title, mConfig.multilingual.message_desc);
                }

            }
        });
    }

    private void showAlertDialog(String title, String message){
        AlertDialog.Builder dialogAbout = new AlertDialog.Builder(MainActivity.this);
        dialogAbout.setTitle(title);
        dialogAbout.setMessage(message);
        dialogAbout.setPositiveButton("Okay", null );
        dialogAbout.show();
    }
}
