package com.cemugras.passwordgenerator;

import java.util.Random;

public class GeneratePassword{

    // create a string of uppercase and lowercase characters and numbers
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";

    // combine all strings
    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
    String alphaNumericUpper = upperAlphabet + numbers;
    String alphaNumericLower = lowerAlphabet + numbers;
    String onlyCharacter = upperAlphabet + lowerAlphabet;
    String onlyCharacterUpper = upperAlphabet;
    String onlyCharacterLower = lowerAlphabet;
    String onlyNumeric = numbers;
    String passwordString, generatedPassword;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // Password generate function
    public String generatePasswordController(boolean number, boolean character, boolean upperCharacter, boolean lowerCharacter, int length){

        // Password option controls

        // If password type is character and number
        if(number && character && upperCharacter && lowerCharacter){
            /*generatedPassword = generatePassword("CharNum", length);*/
            generatedPassword = generatePassword(alphaNumeric, length);
            return passwordString;

        // If password type is upper character and number
        }else if(number && character && upperCharacter) {
            /*generatedPassword = generatePassword("CharUpperNum", length);*/
            generatedPassword = generatePassword(alphaNumericUpper, length);
            return passwordString;

        // If password type is lower character and number
        }else if(number && character && lowerCharacter) {
            /*generatedPassword = generatePassword("CharLowerNum", length);*/
            generatedPassword = generatePassword(alphaNumericLower, length);
            return passwordString;

        // If password type is only number
        }else if(number) {
            /*generatedPassword = generatePassword("OnlyNum", length);*/
            generatedPassword = generatePassword(onlyNumeric, length);
            return passwordString;

        // If password type is only character
        }else if(character && upperCharacter && lowerCharacter){
            /*generatedPassword = generatePassword("OnlyChar", length);*/
            generatedPassword = generatePassword(onlyCharacter, length);
            return passwordString;

        // If password type is upper character
        }else if(character && upperCharacter){
            /*generatedPassword = generatePassword("OnlyCharUpper", length);*/
            generatedPassword = generatePassword(onlyCharacterUpper, length);
            return passwordString;

        // If password type is upper character
        }else if(character && lowerCharacter){
            /*generatedPassword = generatePassword("OnlyCharLower", length);*/
            generatedPassword = generatePassword(onlyCharacterLower, length);
            return passwordString;

        // If password type is null(clicked switch not found)
        }else {
            passwordString = "False";
            return passwordString;
        }
    }

    private String generatePassword(String passVariables, int length){
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(passVariables.length());

            // get character specified by index
            // from the string
            char randomChar = passVariables.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        passwordString = sb.toString();

        return passwordString;
    }

}
