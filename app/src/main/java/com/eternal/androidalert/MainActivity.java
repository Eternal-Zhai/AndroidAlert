package com.eternal.androidalert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eternal.alert.base.AlertWrapper;
import com.eternal.alert.base.BaseAlert;
import com.eternal.alert.conventional.Alert;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alert.create(MainActivity.this, Alert.PROGRESS_TYPE).leftBtn(null, new Alert.OnClick<Alert>() {
                    @Override
                    public void onClick(Alert alert, int which) {
                        alert.dismiss();
                    }
                }).show();


            }
        });


    }
}
