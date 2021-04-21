package com.example.passwordgenerator;

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
        if(number && character && upperCharacter && lowerCharacter){
            generatedPassword = generatePassword("CharNum", length);
            return passwordString;

        }else if(number && character && upperCharacter) {
            generatedPassword = generatePassword("CharUpperNum", length);
            return passwordString;

        }else if(number && character && lowerCharacter) {
            generatedPassword = generatePassword("CharLowerNum", length);
            return passwordString;

        }else if(number) {
            generatedPassword = generatePassword("OnlyNum", length);
            return passwordString;

        }else if(character && upperCharacter && lowerCharacter){
            generatedPassword = generatePassword("OnlyChar", length);
            return passwordString;

        }else if(character && upperCharacter){
            generatedPassword = generatePassword("OnlyCharUpper", length);
            return passwordString;

        }else if(character && lowerCharacter){
            generatedPassword = generatePassword("OnlyCharLower", length);
            return passwordString;

        }else {
            passwordString = "False";
            return passwordString;
        }
    }

    private String generatePassword(String type, int length){
        switch (type) {
            // If password type is character and number
            case "CharNum":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(alphaNumeric.length());

                    // get character specified by index
                    // from the string
                    char randomChar = alphaNumeric.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is upper character and number
            case "CharUpperNum":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(alphaNumericUpper.length());

                    // get character specified by index
                    // from the string
                    char randomChar = alphaNumericUpper.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is lower character and number
            case "CharLowerNum":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(alphaNumericLower.length());

                    // get character specified by index
                    // from the string
                    char randomChar = alphaNumericLower.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is only number
            case "OnlyNum":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(onlyNumeric.length());

                    // get character specified by index
                    // from the string
                    char randomChar = onlyNumeric.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is only character
            case "OnlyChar":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(onlyCharacter.length());

                    // get character specified by index
                    // from the string
                    char randomChar = onlyCharacter.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is only upper character
            case "OnlyCharUpper":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(onlyCharacterUpper.length());

                    // get character specified by index
                    // from the string
                    char randomChar = onlyCharacterUpper.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
            // If password type is only lower character
            case "OnlyCharLower":
                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(onlyCharacterLower.length());

                    // get character specified by index
                    // from the string
                    char randomChar = onlyCharacterLower.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                }
                break;
        }

        passwordString = sb.toString();

        return passwordString;
    }


}
