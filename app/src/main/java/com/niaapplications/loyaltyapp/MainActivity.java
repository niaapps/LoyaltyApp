package com.niaapplications.loyaltyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mongodb.lang.NonNull;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.core.auth.StitchUser;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential;
import com.mongodb.stitch.core.services.mongodb.remote.RemoteInsertOneResult;

import org.bson.Document;



public class MainActivity extends AppCompatActivity {


    RemoteMongoCollection<Document> remoteMongoCollection;
    EditText name, email, phone, street, city, state, zip, pw;
    String name_str, email_str, phone_str, street_str, city_str, state_str, zip_str, pw_str, result;
    Button signIn, next;
    Business biz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final StitchAppClient client = Stitch.initializeAppClient("loyaltyapp-vfamf");

        // Log-in using an Anonymous authentication provider from Stitch
        client.getAuth().loginWithCredential(new AnonymousCredential())
                .addOnCompleteListener(new OnCompleteListener<StitchUser>() {
                    @Override
                    public void onComplete(@NonNull Task<StitchUser> task) {
                        // Get a remote client
                        final RemoteMongoClient remoteMongoClient =
                                client.getServiceClient(RemoteMongoClient.factory, "mongodb-atlas");

                        // Set up the atlas collection
                        remoteMongoCollection = remoteMongoClient
                                .getDatabase("Loyalty_App_Data").getCollection("Businesses");
                    }
                });



        name = findViewById(R.id.bizNameEdit);
        email = findViewById(R.id.bizEmailEdit);
        phone = findViewById(R.id.bizNumEdit);
        street = findViewById(R.id.bizStEdit);
        city = findViewById(R.id.bizCEdit);
        state = findViewById(R.id.bizSEdit);
        zip = findViewById(R.id.bizZEdit);
        pw = findViewById(R.id.bizPwEdit);
        next = findViewById(R.id.next_btn);
        signIn = findViewById(R.id.sign_in);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(myIntent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name_str = name.getText().toString();
                email_str = email.getText().toString();
                pw_str = pw.getText().toString();
                street_str = street.getText().toString();
                city_str = city.getText().toString();
                state_str = state.getText().toString();
                zip_str = zip.getText().toString();
                phone_str = phone.getText().toString();

                if(phone_str.contains("-")){
                    StringBuilder sb = new StringBuilder(phone_str);
                    sb.deleteCharAt(3);
                    sb.deleteCharAt(6);
                    result= sb.toString();
                    phone_str = result;
                }



                if(name_str.isEmpty() || email_str.isEmpty()|| pw_str.isEmpty() || street_str.isEmpty() || city_str.isEmpty() || state_str.isEmpty()
                        || zip_str.isEmpty() || phone_str.isEmpty() ){
                    Toast.makeText(MainActivity.this, "One or more field is empty.", Toast.LENGTH_LONG).show();
                }else {

                    biz = new Business(name_str, email_str, pw_str, street_str, city_str, state_str, zip_str, phone_str);


                    Document businessData = new Document()

                            .append("name", biz.getName())
                            .append("email", biz.getEmail())
                            .append("password", biz.getPw())
                            .append("phone", biz.getNumber())
                            .append("street", biz.getStreet())
                            .append("city", biz.getCity())
                            .append("state", biz.getState())
                            .append("zip", biz.getZip());

                    final Task<RemoteInsertOneResult> insertTask = remoteMongoCollection.insertOne(businessData);
                    insertTask.addOnCompleteListener(new OnCompleteListener<RemoteInsertOneResult>() {
                        @Override
                        public void onComplete(@NonNull Task<RemoteInsertOneResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("insert", String.format("successfully inserted item with id %s",
                                        task.getResult().getInsertedId()));
                                Toast.makeText(MainActivity.this, "Sign Up Success", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                                startActivity(intent);

                            } else {
                                Log.e("insert", "failed to insert document with: ", task.getException());
                                Toast.makeText(MainActivity.this, "Sign Up Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

    }

}