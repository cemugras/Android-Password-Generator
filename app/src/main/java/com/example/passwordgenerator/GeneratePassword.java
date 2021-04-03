package com.example.passwordgenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class GeneratePassword{

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }*/

    // create a string of uppercase and lowercase characters and numbers
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";

    // combine all strings
    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
    String onlyCharacter = upperAlphabet + lowerAlphabet;
    String onlyNumeric = numbers;
    String passwordString, generatedPassword;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // Password generate function
    public String generatePasswordController(boolean number, boolean character, int length){

        // Password objects creation
        String password[] = new String[length];

        // Password option controls
        if((number==true) && (character==true)){
            generatedPassword = generatePassword(1, length);
            return passwordString;
            
        }else if(number==true) {
            generatedPassword = generatePassword(2, length);
            return passwordString;
            
        }else if(character==true){
            generatedPassword = generatePassword(3, length);
            return passwordString;
            
        }else {
            passwordString = "False";
            return passwordString;
        }
    }

    private String generatePassword(int type, int length){
        // If password type is character and number
        if(type == 1) {
            for (int i = 0; i < length; i++) {
                // generate random index number
                int index = random.nextInt(alphaNumeric.length());

                // get character specified by index
                // from the string
                char randomChar = alphaNumeric.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }
        }
        // If password type is only number
        else if(type == 2){
            for (int i = 0; i < length; i++) {
                // generate random index number
                int index = random.nextInt(onlyNumeric.length());

                // get character specified by index
                // from the string
                char randomChar = onlyNumeric.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }
        }
        // If password type is only character
        else if(type == 3){
            for (int i = 0; i < length; i++) {
                // generate random index number
                int index = random.nextInt(onlyCharacter.length());

                // get character specified by index
                // from the string
                char randomChar = onlyCharacter.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }
        }

        passwordString = sb.toString();

        return passwordString;
    }


}
