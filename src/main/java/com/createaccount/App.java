
package com.createaccount;

public class App {
    public boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6;
    }

    public static void main(String[] args) {
        System.out.println("Create Account App started...");
    }
}
