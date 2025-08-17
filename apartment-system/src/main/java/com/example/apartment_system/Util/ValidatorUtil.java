package com.example.apartmentsystem.Util;

public class ValidatorUtil {

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^[0-9]{9,11}$");
    }

    public static boolean isValidNationalId(String id) {
        return id != null && id.matches("^[0-9]{9,12}$");
    }

    public static boolean isValidYearOfBirth(int year) {
        return year > 1900 && year <= java.time.Year.now().getValue();
    }
}
