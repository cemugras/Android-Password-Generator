package com.example.passwordgenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class GeneratePassword{

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }*/

    // Password generate function
    public String generatePasswordController(boolean number, boolean character, int length){

        // Password objects creation
        String password[] = new String[length];
        String passwordString;

        // Password option controls
        if((number==true) && (character==true)){
            passwordString = "String&Integer";
            return passwordString;
        }else if(number==true) {
            passwordString = "Integer";
            return passwordString;
        }else if(character==true){
            passwordString = "String";
            return passwordString;
        }else {
            passwordString = "False";
            return passwordString;
        }
    }


}
