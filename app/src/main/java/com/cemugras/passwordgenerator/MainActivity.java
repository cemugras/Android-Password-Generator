package com.cemugras.passwordgenerator;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.*;
import com.example.passwordgenerator.R;

public class MainActivity extends Activity{
    protected boolean numS, charS, upperS, lowerS;
    protected String pass,passLength;
    protected int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // UI object definitions
        Button buttonGenerate = findViewById(R.id.buttonGenerate);
        Button buttonCopy = findViewById(R.id.buttonCopy);
        Button buttonClear = findViewById(R.id.buttonClear);

        TextView passGenerated = findViewById(R.id.passGenerated);

        Switch numSwitch = findViewById(R.id.switchNumber);
        Switch charSwitch = findViewById(R.id.switchChar);

        Switch upperSwitch = findViewById(R.id.switchUpperChar);
        Switch lowerSwitch = findViewById(R.id.switchLowerChar);
        upperSwitch.setClickable(false);
        lowerSwitch.setClickable(false);

        // Switch objects assignment
        numSwitch.setTextOn("ON");
        numSwitch.setTextOff("OFF");
        charSwitch.setTextOn("ON");
        charSwitch.setTextOff("OFF");
        upperSwitch.setTextOn("ON");
        upperSwitch.setTextOff("OFF");
        lowerSwitch.setTextOn("ON");
        lowerSwitch.setTextOff("OFF");

        Spinner spinner = findViewById(R.id.charLength);

        ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        // Create an ArrayAdapter using the string array and a default spinner layout
        // Parsing string.xml and getting elements of specific array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.charLength, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Character Switch Event
        charSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                upperSwitch.setChecked(true);
                lowerSwitch.setChecked(true);
                upperSwitch.setClickable(true);
                lowerSwitch.setClickable(true);
            }
            else {
                if(upperSwitch.isChecked() && lowerSwitch.isChecked()){
                    upperSwitch.setChecked(false);
                    lowerSwitch.setChecked(false);
                }
                else if(upperSwitch.isChecked())
                    upperSwitch.setChecked(false);
                else if (lowerSwitch.isChecked())
                    lowerSwitch.setChecked(false);
                upperSwitch.setClickable(false);
                lowerSwitch.setClickable(false);
            }
        });

        // Upper Character Switch Event
        upperSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(!isChecked && charSwitch.isChecked()){
                if(!lowerSwitch.isChecked())
                    lowerSwitch.setChecked(true);
            }
        });

        // Lower Character Switch Event
        lowerSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(!isChecked && charSwitch.isChecked()){
                if(!upperSwitch.isChecked())
                    upperSwitch.setChecked(true);
            }
        });

        // Clear button event
        buttonClear.setOnClickListener(v -> passGenerated.setText(""));

        // Generate button event
        buttonGenerate.setOnClickListener(v -> {
            // Getting password feature selections
            numS = numSwitch.isChecked();
            charS = charSwitch.isChecked();
            upperS = upperSwitch.isChecked();
            lowerS = lowerSwitch.isChecked();
            passLength = (String) spinner.getSelectedItem();
            length = Integer.parseInt(passLength);

            // Creation of password generate function
            GeneratePassword generateClass = new GeneratePassword();
            pass = generateClass.generatePasswordController(numS, charS, upperS, lowerS, length);

            if(pass.equals("False")){

                passGenerated.setText("");
                Toast.makeText(getApplicationContext(), "Please select an option.",  Toast.LENGTH_SHORT).show();

            }else{

                passGenerated.setText(pass);
                //Toast.makeText(getApplicationContext(), "Password:" + pass +" Length:" + passLength,  Toast.LENGTH_SHORT).show();
                
            }
        });

        buttonCopy.setOnClickListener(v -> {
            ClipData clipData = ClipData.newPlainText("text", passGenerated.getText());
            manager.setPrimaryClip(clipData);
        });


     }

}
