package com.prodology.prodology;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button submit=(Button)findViewById(R.id.vote_buton);
       final RadioButton js=(RadioButton)findViewById(R.id.js);
       final RadioButton ns=(RadioButton)findViewById(R.id.ns);
        final RadioButton cl=(RadioButton)findViewById(R.id.cl);
        final RadioButton tl=(RadioButton)findViewById(R.id.tl);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(js.isChecked()){
                    send_data("Jon Snow");
                }else if(ns.isChecked()){
                    send_data("Ned Stark");
                }else if(cl.isChecked()){
                    send_data("Cersei");
                }else {
                    send_data("Tyrion");
                }
            }
        });
    }

    public void send_data(String vote){

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("Vote");

        String userid=myRef.push().getKey();

        myRef.child(userid).setValue(vote);
    }


}
