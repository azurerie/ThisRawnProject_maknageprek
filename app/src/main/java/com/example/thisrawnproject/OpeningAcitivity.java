package com.example.thisrawnproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OpeningAcitivity extends AppCompatActivity {
    TextView about_button;
    Button start_button;
    LinearLayout about_layout;
    Boolean state = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_acitivity);

        about_button = findViewById(R.id.tentangkami_textview);
        about_layout = findViewById(R.id.learnabout_linearlayout);
        start_button = findViewById(R.id.mulai_button);

        about_layout.setVisibility(View.INVISIBLE);

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state){
                    state = false;
                    about_button.setText("Ingin tahu Tentang kami");
                    visible();
                    return;
                }
                about_layout.setVisibility(View.VISIBLE);
                state = true;
                about_button.setText("Terima Kasih");
            }
        });

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OpeningAcitivity.this, "selamat mencoba", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void visible(){
        about_layout.setVisibility(View.INVISIBLE);
    }
}