package com.createaccount;

import java.util.regex.Pattern;

public class CreateAccount {

public static boolean isValidFirstName(String firstName) {
    return firstName != null && !firstName.trim().isEmpty() && firstName.length() >= 2;
}

public static boolean isValidLastName(String lastName) {
    return lastName != null && !lastName.trim().isEmpty() && lastName.length() >= 2;
}

public static boolean isValidEmail(String email) {
    if (email == null || email.trim().isEmpty()) return false;
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return Pattern.matches(emailRegex, email);
}

public static boolean isValidPassword(String password) {
    if (password == null || password.length() < 8) return false;
    boolean hasUpper = false, hasLower = false, hasDigit = false;
    for (char ch : password.toCharArray()) {
        if (Character.isUpperCase(ch)) hasUpper = true;
        if (Character.isLowerCase(ch)) hasLower = true;
        if (Character.isDigit(ch)) hasDigit = true;
    }
    return hasUpper && hasLower && hasDigit;
}

public static boolean doPasswordsMatch(String password, String confirmPassword) {
    return password != null && password.equals(confirmPassword);
}

public static boolean isValidDateOfBirth(String dob) {
    if (dob == null) return false;
    // Basit tarih formatı kontrolü: gg/aa/yyyy
    String dobRegex = "^\\d{2}/\\d{2}/\\d{4}$";
    return Pattern.matches(dobRegex, dob);
}

public static boolean submitForm(String firstName, String lastName, String email, String password, String confirmPassword, String dob) {
    return isValidFirstName(firstName)
            && isValidLastName(lastName)
            && isValidEmail(email)
            && isValidPassword(password)
            && doPasswordsMatch(password, confirmPassword)
            && isValidDateOfBirth(dob);
}
}