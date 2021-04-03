package com.passwordgenerator;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.*;
import com.example.passwordgenerator.R;

public class MainActivity extends Activity{
    protected boolean numS,charS;
    protected String pass,passLength;
    protected int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // UI object definitions
        Button buttonGenerate = findViewById(R.id.buttonGenerate);
        Button buttonCopy = findViewById(R.id.buttonCopy);

        TextView passGenerated = findViewById(R.id.passGenerated);

        Switch numSwitch = findViewById(R.id.switchNumber);
        Switch charSwitch = findViewById(R.id.switchChar);

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
