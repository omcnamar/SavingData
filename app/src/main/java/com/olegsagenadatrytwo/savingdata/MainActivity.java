package com.olegsagenadatrytwo.savingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private TextView tv;

    private EditText etName;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.etTest);
        tv = (TextView) findViewById(R.id.tvTest);

        etName = (EditText) findViewById(R.id.etName);
        etGender = (EditText) findViewById(R.id.etGender);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", et.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            String retrieve = savedInstanceState.getString("key");
            tv.setText(retrieve);
        }

    }

    public void goToAnotherActivity(View view) {

        switch (view.getId()){
            case R.id.btSubmitPerson:
                Person p = new Person(etName.getText().toString(), etGender.getText().toString());
                Intent intent = new Intent(this, SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("person", p);
                startActivity(intent);
                break;
            case R.id.btTest:
                tv.setText(et.getText().toString());
                break;
            case R.id.btnShareData:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
    }
}
