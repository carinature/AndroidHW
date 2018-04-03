package com.example.iotracker.e_kay;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadSpinner();
    }

    public void loadSpinner(){
        Spinner country_spinner = (Spinner) findViewById(R.id.country_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_array, android.R.layout.simple_spinner_item);
        //     Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //     Apply the adapter to the spinner
        country_spinner.setAdapter(adapter);
    }

    public static boolean validateLetters(String txt) {

        String regx = "[a-zA-Z][a-zA-Z ]*$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();

    }

    public void signUpFoo(View view){
        //
        EditText nameEdit = (EditText)findViewById(R.id.name);
        EditText ageEdit  = (EditText)findViewById(R.id.age);
        if( !TextUtils.isEmpty(nameEdit.getText()) && !TextUtils.isEmpty(ageEdit.getText()) ){
            String name = nameEdit.getText().toString();
            int age = Integer.parseInt(ageEdit.getText().toString());
            if ( 16<age && 100>age && validateLetters(name)){
                Toast.makeText(getApplicationContext(), "User created!",  Toast.LENGTH_SHORT).show();
            }
        }
    }


}


//public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//
//
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//    }
//
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//    }
//}