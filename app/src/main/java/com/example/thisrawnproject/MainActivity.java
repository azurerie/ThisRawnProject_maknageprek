package com.example.thisrawnproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.math.BigDecimal;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText uangjajansebulan_edittext, kebutuhansehari_edittext;
    TextView persentasiboros_textview, persentasihemat_textview, uangjajansebulan_textview, kebutuhansebulan_textview, quotes_textview;
    Button go_Btn, reset_Btn;
    RelativeLayout result_layout;
    String uangjajan, kebutuhansehari;
    Double uangjajansebulan, kebutuhansebulan;
    int hasil, kebutuhanSebulan;
    int index = 100,r;
    int persentage;
    Random random;
    String uj,ks,ph,pb;
    Boolean state;
    String[] support, praise;
    String d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        uangjajansebulan_edittext = findViewById(R.id.uangjajansebulan_exittext);
        kebutuhansehari_edittext = findViewById(R.id.kebutuhanssehari_edittext);

        uangjajansebulan_textview = findViewById(R.id.uangjajansebulan_textview);
        kebutuhansebulan_textview = findViewById(R.id.kebutuhansebulan_textview);
        persentasihemat_textview = findViewById(R.id.persentasehemat_textview);
        persentasiboros_textview = findViewById(R.id.persentaseboros_textview);
        quotes_textview = findViewById(R.id.quotes_textview);

        go_Btn = findViewById(R.id.go_Button);
        reset_Btn = findViewById(R.id.reset_button);
        result_layout = findViewById(R.id.result_relativelayout);

        result_layout.setVisibility(View.INVISIBLE);

        Toast.makeText(getApplicationContext(), "masukkan angka ke kolom kosong", Toast.LENGTH_SHORT).show();

        go_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uangjajan = uangjajansebulan_edittext.getText().toString();
                kebutuhansehari = kebutuhansehari_edittext.getText().toString();


                if (uangjajan.isEmpty() && kebutuhansehari.isEmpty()){
                    Toast.makeText(getApplicationContext(), "masukkan angka ke kolom kosong", Toast.LENGTH_SHORT).show();
                } else if (uangjajan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "masukkan angka ke kolom kosong", Toast.LENGTH_SHORT).show();
                }else if (kebutuhansehari.isEmpty()){
                    Toast.makeText(getApplicationContext(), "masukkan angka ke kolom kosong", Toast.LENGTH_SHORT).show();
                }
                else{
                    Go_Btn();
                }
            }
        });


        reset_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uangjajansebulan_edittext.setText(" ");
                kebutuhansehari_edittext.setText(" ");

                uangjajansebulan_textview.setText("Rp. 0");
                kebutuhansebulan_textview.setText("Rp. 0");
                persentasihemat_textview.setText("0 %");
                persentasiboros_textview.setText("0 %");
                quotes_textview.setText("......");
                go_Btn.setText("Tekan sini");
                setGo_Btn();
                state = true;
                result_layout.setVisibility(View.VISIBLE);
            }
        });

    }

    public void setGo_Btn(){
        go_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Go_Btn();
            }
        });

    }

    public void Go_Btn(){
            praise = new String[4];
            praise[0] = "Pertahankan kebiasaan menyisihkan uang jajanmu! untuk masa depanmu!";
            praise[1] = "Selamat! ternyata kebiasaanmu dalam mengatur uang itu masuuk kategori hemat!";
            praise[2] = "Jangan terlalu senang ya! beberapa hari mungkin memiliki pengeluaran lebih";
            praise[3] = "Hemat pangkal kaya";

            support = new String[4];
            support[0] = "Kebisaanmu itu mungkin belum masuk kategori hemat, namun jangan bersedih mulai hemat itu memanglah tidak mudah";
            support[1] = "Menabunglah untuk masa depanmu.";
            support[2] = "Ratakan dompet Anda. Jika Anda mendapat Rp100 ribu, simpan setidaknya Rp20–30 ribu.";
            support[3] =  "Kaya bukanlah tentang seberapa banyak uang yang kita peroleh, melainkan tentang seberapa baik kita mengelola uang tersebut." ;


            //to string
            uangjajan = uangjajansebulan_edittext.getText().toString();
            kebutuhansehari = kebutuhansehari_edittext.getText().toString();

            //to double
            uangjajansebulan = Double.parseDouble(uangjajan);
            kebutuhansebulan = Double.parseDouble(kebutuhansehari);

            if (uangjajansebulan < kebutuhansebulan){
                persentage = 0;
            }else{
                float sebulan = (float) (kebutuhansebulan*30);
                persentage = (int)(uangjajansebulan-sebulan);

                persentage = (int) (persentage*100/uangjajansebulan);

            }
            kebutuhanSebulan = (int) (kebutuhansebulan*30);


            if (persentage > hasil){
                random = new Random();
                r = random.nextInt(praise.length);
                d = praise[r];
            }else if (persentage < hasil){
                random = new Random();
                r = random.nextInt(support.length);
                d = support[r];
            }

            uangjajansebulan_textview.setText("Rp. "+uangjajan);
            kebutuhansebulan_textview.setText("Rp. "+kebutuhanSebulan);
            persentasihemat_textview.setText(persentage+" %");
            hasil = index-persentage;
            persentasiboros_textview.setText(hasil+" %");

            quotes_textview.setText(d);

            state = true;
            result_layout.setVisibility(View.VISIBLE);
            go_Btn.setText("Hasil");


    }

}