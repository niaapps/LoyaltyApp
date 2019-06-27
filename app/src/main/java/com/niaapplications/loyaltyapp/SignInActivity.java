package com.niaapplications.loyaltyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mongodb.lang.NonNull;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.core.auth.StitchUser;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential;

import org.bson.Document;

public class SignInActivity extends AppCompatActivity {

    EditText email, pw;
    Button progress;
    RemoteMongoCollection<Document> remoteMongoCollection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        email = findViewById(R.id.Email);
        pw = findViewById(R.id.Pw);
        progress = findViewById(R.id.nextbtn3);

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

        // read from db and validate, toast sign in and load phone activity
        // set up mongodb login
        //ask grant about forgot password// service url.





    }
}
