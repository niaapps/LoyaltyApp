package com.niaapplications.loyaltyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    ImageView bkg;
    Button up,next_2;


protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.biz_pg2);

    bkg = findViewById(R.id.imageView);
    up = findViewById(R.id.up_btn);
    next_2 = findViewById(R.id.nextbtn2);


}

}
