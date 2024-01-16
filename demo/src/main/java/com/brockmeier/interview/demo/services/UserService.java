package com.brockmeier.interview.demo.services;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import types.User;

@Component
public class UserService {
   final static int PW_MIN_LENGTH = 5; //Probably use 
   final static int PW_MAX_LENGTH = 12;

   public final static String PASSWORD_LENGTH_REQUIREMENT = "The password must be between " +  PW_MIN_LENGTH + " and " + PW_MAX_LENGTH + " characters";
   public final static String PASSWORD_CHARACTER_SET = "The password can only container lowercase letters and numbers";
   public final static String PASSWORD_CHARACTER_MINIMUMS = "The password must contain at least one lowercase letter and 1 number";
   public final static String PASSWORD_CHARACTER_SEQUENCE = "The password must not contain any sequence of characters immediately followed by the same sequence";


    public ArrayList<String> validatePassword(String password) {
      ArrayList<String> results = new ArrayList<String>();
      
      String validateLength = validatePasswordLength(password);
      if (validateLength != null) 
         results.add(validateLength);
      
      String validateCharacters = validateCharacters(password);
      if (validateCharacters != null) 
         results.add(validateCharacters);
      
      String validateCharacterMinimums = validateCharacterMinimums(password);
      if (validateCharacterMinimums != null) 
         results.add(validateCharacterMinimums);
      
      String validateMatching = validatePatternMatching(password);
      if (validateMatching != null) 
         results.add(validateMatching);
      
      return results;
   }
   
    protected String validatePatternMatching(String password) {
      Pattern pattern = Pattern.compile("(..+)\\1");
      Matcher matcher = pattern.matcher(password);
      boolean matchFound = matcher.find();
      if(matchFound) {
        return PASSWORD_CHARACTER_SEQUENCE;
      } else {
        return null;
      }
   }

    private String validateCharacters(String password) {
      Pattern pattern = Pattern.compile("[^a-z0-9]");
      Matcher matcher = pattern.matcher(password);
      boolean matchFound = matcher.find();
      if(matchFound) {
        return PASSWORD_CHARACTER_SET;
      } else {
        return null;
      }
   }
    
    private String validateCharacterMinimums(String password) {
       Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z]).+");
       Matcher matcher = pattern.matcher(password);
       boolean matchFound = matcher.find();
       if(!matchFound) {
         return PASSWORD_CHARACTER_MINIMUMS;
       } else {
         return null;
       }
    }
    
    

   /**
    * @param password
    * @return List of strings that contains errors, empty list if validation succeeds
    */
   private String validatePasswordLength(String password) {      
      if (( password.length()  > PW_MAX_LENGTH) || (password.length() < PW_MIN_LENGTH)) {
         return PASSWORD_LENGTH_REQUIREMENT;
      }
      return null;
   }
   

}
