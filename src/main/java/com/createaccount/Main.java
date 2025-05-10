package com.createaccount;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String firstName, lastName, email, password, confirmPassword, dob;

// First Name
while (true) {
    System.out.print("Adınızı girin: ");
    firstName = scanner.nextLine();
    if (CreateAccount.isValidFirstName(firstName)) break;
    System.out.println("Geçersiz ad. En az 2 karakter olmalı.");
}

// Last Name
while (true) {
    System.out.print("Soyadınızı girin: ");
    lastName = scanner.nextLine();
    if (CreateAccount.isValidLastName(lastName)) break;
    System.out.println("Geçersiz soyad. En az 2 karakter olmalı.");
}

// Email
while (true) {
    System.out.print("E-posta adresinizi girin: ");
    email = scanner.nextLine();
    if (CreateAccount.isValidEmail(email)) break;
    System.out.println("Geçersiz e-posta formatı.");
}

// Password
while (true) {
    System.out.print("Şifrenizi girin (en az 8 karakter, büyük, küçük harf ve rakam içermeli): ");
    password = scanner.nextLine();
    if (CreateAccount.isValidPassword(password)) break;
    System.out.println("Geçersiz şifre.");
}

// Confirm Password
while (true) {
    System.out.print("Şifrenizi tekrar girin: ");
    confirmPassword = scanner.nextLine();
    if (CreateAccount.doPasswordsMatch(password, confirmPassword)) break;
    System.out.println("Şifreler eşleşmiyor.");
}

// Date of Birth
while (true) {
    System.out.print("Doğum tarihinizi girin (gg/aa/yyyy): ");
    dob = scanner.nextLine();
    if (CreateAccount.isValidDateOfBirth(dob)) break;
    System.out.println("Geçersiz tarih formatı.");
}

// Final validation
if (CreateAccount.submitForm(firstName, lastName, email, password, confirmPassword, dob)) {
    System.out.println("\nHesap başarıyla oluşturuldu!");
} else {
    System.out.println("\nHesap oluşturulamadı. Lütfen bilgilerinizi kontrol edin.");
}

scanner.close();
}
}