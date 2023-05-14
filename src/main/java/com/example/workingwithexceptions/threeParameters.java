package com.example.workingwithexceptions;

public class threeParameters {
    private String login;
    private String password;
    private String confirmPassword;

    public void threeParameters(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public static void checker(String login, String password, String confirmPassword) {

        int loginLength = login.length();
        int passwordLength = password.length();
        int confirmPasswordLength = confirmPassword.length();

        if (loginLength > 20 || (passwordLength > 20 && confirmPasswordLength > 20)) {
            try {
                throw new Exception("login or password length error");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        try {
            boolean isValid = validation(password);
            boolean isValid1 = validation(confirmPassword);
            if (!isValid && !isValid1) {
                throw new Exception("используйте другие символы в логине");
            }
        }  catch (Exception e) {
            System.out.println(e);
        }


        try {
            boolean isValid = validation(login);
            if (!isValid) {
                throw new Exception("используйте другие символы в логине");
            }
        }  catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean validation(String someString) {
        for (char ch: someString.toCharArray()) {
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <=122) || ch == 95)) {
                return false;
            }
        }
        return true;
    }

}
