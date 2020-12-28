package com.example.passwordgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.passwordgenerator.GeneratePassword;

public class MainActivity extends Activity{
    protected boolean numS,charS;
    protected String pass,passLength;
    protected int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // UI object definitions
        Button buttonGenerate = (Button) findViewById(R.id.buttonGenerate);
        Switch numSwitch = (Switch) findViewById(R.id.switchNumber);
        Switch charSwitch = (Switch) findViewById(R.id.switchChar);
        Spinner spinner = (Spinner) findViewById(R.id.charLength);

        // Create an ArrayAdapter using the string array and a default spinner layout
        // Parsing string.xml and getting elements of specific array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.charLength, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Generate button event
        buttonGenerate.setOnClickListener(v -> {
            // Getting password feature selections
            numS = numSwitch.isChecked();
            charS = charSwitch.isChecked();
            passLength = (String) spinner.getSelectedItem();
            length = Integer.parseInt(passLength);

            // Creation of password generate function
            GeneratePassword generateClass = new GeneratePassword();
            pass = generateClass.generatePasswordController(numS, charS, length);

            if(pass=="False"){
                Toast.makeText(getApplicationContext(), "Please select.",  Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Password:" + pass +" Length:" + passLength,  Toast.LENGTH_SHORT).show();
            }
        });

     }

}
