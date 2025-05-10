package com.createaccount;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
public void testValidFirstName() {
    assertTrue(CreateAccount.isValidFirstName("Ayris"));
    assertFalse(CreateAccount.isValidFirstName("")); // boş
    assertFalse(CreateAccount.isValidFirstName("A")); // çok kısa
}

@Test
public void testValidLastName() {
    assertTrue(CreateAccount.isValidLastName("Fesligil"));
    assertFalse(CreateAccount.isValidLastName(null));
}

@Test
public void testValidEmail() {
    assertTrue(CreateAccount.isValidEmail("ayris@example.com"));
    assertFalse(CreateAccount.isValidEmail("ayrisexample.com")); // '@' yok
    assertFalse(CreateAccount.isValidEmail("")); // boş
}

@Test
public void testValidPassword() {
    assertTrue(CreateAccount.isValidPassword("Pass1234"));
    assertFalse(CreateAccount.isValidPassword("short1"));
    assertFalse(CreateAccount.isValidPassword("nouppercase1"));
    assertFalse(CreateAccount.isValidPassword("NOLOWERCASE1"));
    assertFalse(CreateAccount.isValidPassword("NoNumber"));
}

@Test
public void testPasswordsMatch() {
    assertTrue(CreateAccount.doPasswordsMatch("Pass1234", "Pass1234"));
    assertFalse(CreateAccount.doPasswordsMatch("Pass1234", "pass1234"));
}

@Test
public void testValidDateOfBirth() {
    assertTrue(CreateAccount.isValidDateOfBirth("01/01/2000"));
    assertFalse(CreateAccount.isValidDateOfBirth("2000/01/01"));
}

@Test
public void testSubmitFormSuccess() {
    assertTrue(CreateAccount.submitForm(
            "Ayris",
            "Fesligil",
            "ayris@example.com",
            "Password123",
            "Password123",
            "01/01/2000"
    ));
}

@Test
public void testSubmitFormFailure() {
    assertFalse(CreateAccount.submitForm(
            "A",
            "",
            "invalidemail",
            "pass",
            "mismatch",
            "wrongformat"
    ));
}
}