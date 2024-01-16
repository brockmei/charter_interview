package com.brockmeier.interview.demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

   static UserService userService;
   @BeforeAll
   static public void setUp() {
      userService = new UserService();
   } 
   
   @AfterAll
   static public void tearDown() {
      userService = null;
   }
   
   @Test
   public void lengthTest() {
       assertTrue(userService.validatePassword("hell").get(0).equals(UserService.PASSWORD_LENGTH_REQUIREMENT));
       assertTrue(userService.validatePassword("hellosgoodbye").get(0).equals(UserService.PASSWORD_LENGTH_REQUIREMENT));
       assertTrue(userService.validatePassword("hellosbood12").size() == 0);       
   }
   
   @Test 
   public void validateCharactersTest() {
      assertTrue(userService.validatePassword("$Tasdfsadf").get(0).equals(UserService.PASSWORD_CHARACTER_SET));
      assertTrue(userService.validatePassword("1234abcd").size() == 0);
      assertTrue(userService.validatePassword("Abcdedfg").get(0).equals(UserService.PASSWORD_CHARACTER_SET));
   }
   
   @Test
   public void validatePatternMatchingTest() {
      assertTrue(userService.validatePassword("aabaaca1").size() == 0);
      assertTrue(userService.validatePassword("abcabcab1").get(0).equals(UserService.PASSWORD_CHARACTER_SEQUENCE));
      assertTrue(userService.validatePassword("chrisaisa1").get(0).equals(UserService.PASSWORD_CHARACTER_SEQUENCE));
      assertTrue(userService.validatePassword("chrisis1234").get(0).equals(UserService.PASSWORD_CHARACTER_SEQUENCE));
      assertTrue(userService.validatePassword("a1a2a3a1a2a3").get(0).equals(UserService.PASSWORD_CHARACTER_SEQUENCE));
   }
   
   @Test 
   public void validateCharactersMinimumsTest() {
      assertTrue(userService.validatePassword("abcdef").get(0).equals(UserService.PASSWORD_CHARACTER_MINIMUMS));
      assertTrue(userService.validatePassword("1234abcd").size() == 0);
      System.out.println(userService.validatePassword("abcde"));
   }

}
