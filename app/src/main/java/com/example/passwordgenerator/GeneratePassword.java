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
    public String generatePassword(boolean number, boolean character){

        // Password option controls
        String password;
        if((number==true) && (character==true)){
            password = "String&Integer";
            return password;
        }else if(number==true) {
            password = "Integer";
            return password;
        }else if(character==true){
            password = "String";
            return password;
        }else {
            password = "False";
            return password;
        }
    }


}
