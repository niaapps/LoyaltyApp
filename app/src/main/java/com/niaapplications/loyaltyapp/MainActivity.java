package com.niaapplications.loyaltyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;

import org.bson.Document;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone, street, city, state, zip, pw;
    String name_str, email_str, phone_str, street_str, city_str, state_str, zip_str, pw_str;
    Button next;
    Business biz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StitchAppClient client =
                Stitch.initializeDefaultAppClient("loyaltyapp-vfamf");

        final RemoteMongoClient mongoClient =
                client.getServiceClient(RemoteMongoClient.factory, "mongodb-atlas");

        final RemoteMongoCollection<Document> coll =
                mongoClient.getDatabase("<Loyalty_App_Data>").getCollection("<Data_1.0>");


        name = findViewById(R.id.bizNameEdit);
        email = findViewById(R.id.bizEmailEdit);
        phone = findViewById(R.id.bizNumEdit);
        street = findViewById(R.id.bizStEdit);
        city = findViewById(R.id.bizCEdit);
        state = findViewById(R.id.bizSEdit);
        zip = findViewById(R.id.bizZEdit);
        pw = findViewById(R.id.bizPwEdit);
        next = findViewById(R.id.next_btn);





        next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                name_str = name.getText().toString();
                email_str = email.getText().toString();
                pw_str = pw.getText().toString();
                street_str = street.getText().toString();
                city_str = city.getText().toString();
                state_str = state.getText().toString();
                zip_str = zip.getText().toString();
                phone_str = phone.getText().toString();
                biz = new Business(name_str,email_str,pw_str,street_str,city_str,state_str,zip_str,phone_str);

                //write to DB here.








                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
              startActivity(intent);

            }
        });




    }

}