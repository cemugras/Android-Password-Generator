package com.cemugras.passwordgenerator;

import java.util.Random;

public class GeneratePassword{

    // create a string of uppercase and lowercase characters and numbers
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String specialCharacters = "!+-?*";
    String numbers = "0123456789";

    // combine all strings
    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
    String alphaNumericSpec = upperAlphabet + lowerAlphabet + numbers + specialCharacters;
    String alphaNumericUpper = upperAlphabet + numbers;
    String alphaNumericUpperSpec = upperAlphabet + numbers + specialCharacters;
    String alphaNumericLower = lowerAlphabet + numbers;
    String alphaNumericLowerSpec = lowerAlphabet + numbers + specialCharacters;
    String onlyNumeric = numbers;
    String onlyNumericSpec = numbers + specialCharacters;
    String onlyCharacter = upperAlphabet + lowerAlphabet;
    String onlyCharacterSpec = upperAlphabet + lowerAlphabet + specialCharacters;
    String onlyCharacterUpper = upperAlphabet;
    String onlyCharacterUpperSpec = upperAlphabet + specialCharacters;
    String onlyCharacterLower = lowerAlphabet;
    String onlyCharacterLowerSpec = lowerAlphabet + specialCharacters;
    String passwordString, generatedPassword;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // Password generate function
    public String generatePasswordController(boolean number, boolean character, boolean upperCharacter, boolean lowerCharacter, boolean specialCharacter, int length){

        // Password option controls

        // If password type is character, special character and number
        if(number && character && upperCharacter && lowerCharacter && specialCharacter){
            generatedPassword = generatePassword(alphaNumericSpec, length);
            return passwordString;

        // If password type is upper character and number
        }if(number && character && upperCharacter && lowerCharacter){
            generatedPassword = generatePassword(alphaNumeric, length);
            return passwordString;

        // If password type is upper character, special character and number
        }else if(number && character && upperCharacter && specialCharacter) {
            generatedPassword = generatePassword(alphaNumericUpperSpec, length);
            return passwordString;

        // If password type is upper character and number
        }else if(number && character && upperCharacter) {
            generatedPassword = generatePassword(alphaNumericUpper, length);
            return passwordString;

        // If password type is lower character, special character and number
        }else if(number && character && lowerCharacter && specialCharacter) {
            generatedPassword = generatePassword(alphaNumericLowerSpec, length);
            return passwordString;

        // If password type is lower character and number
        }else if(number && character && lowerCharacter) {
        generatedPassword = generatePassword(alphaNumericLower, length);
        return passwordString;

        // If password type is only number and special character
        }else if(number && specialCharacter) {
            generatedPassword = generatePassword(onlyNumericSpec, length);
            return passwordString;

        // If password type is only number
        }else if(number) {
            generatedPassword = generatePassword(onlyNumeric, length);
            return passwordString;

        // If password type is only character and special character
        }else if(character && upperCharacter && lowerCharacter && specialCharacter){
            generatedPassword = generatePassword(onlyCharacterSpec, length);
            return passwordString;

        // If password type is only character
        }else if(character && upperCharacter && lowerCharacter){
            generatedPassword = generatePassword(onlyCharacter, length);
            return passwordString;

        // If password type is upper character and special character
        }else if(character && upperCharacter && specialCharacter){
            generatedPassword = generatePassword(onlyCharacterUpperSpec, length);
            return passwordString;

        // If password type is upper character
        }else if(character && upperCharacter){
            generatedPassword = generatePassword(onlyCharacterUpper, length);
            return passwordString;

        // If password type is lower character and special character
        }else if(character && lowerCharacter && specialCharacter){
            generatedPassword = generatePassword(onlyCharacterLowerSpec, length);
            return passwordString;

        // If password type is lower character
        }else if(character && lowerCharacter){
            generatedPassword = generatePassword(onlyCharacterLower, length);
            return passwordString;

        // If password type is only special character
        }else if(specialCharacter){
            generatedPassword = generatePassword(specialCharacters, length);
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
