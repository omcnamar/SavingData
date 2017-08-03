package com.olegsagenadatrytwo.savingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView name;
    private TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Person p = (Person) intent.getParcelableExtra("person");
        name = (TextView) findViewById(R.id.tvName);
        gender = (TextView) findViewById(R.id.tvGender);

        name.setText(p.getName());
        gender.setText(p.getGender());
        Toast.makeText(this, p.getName() +" "+ p.getGender(), Toast.LENGTH_SHORT).show();

    }
}
