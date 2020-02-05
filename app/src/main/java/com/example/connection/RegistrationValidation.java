package com.example.connection;

public final class RegistrationValidation {
    public boolean isValidUsername(String username) {
        if((username.length()>6)&& (username.length()<15))
            return true;
        else
            return false;
    }
    public boolean isValidPassword(String password,String username) {
        char[] chars = password.toCharArray();
        if((password.length()>6) && !password.equals(username)){
            for (char i: chars
            ) {
                if(i>='0' && i<='9')
                    return true;
            }
        }

        return false;
    }
    public boolean isRepeatePasswordValid(String password,String repPassword){

        if(repPassword.equals(password))
            return true;
        else return false;
    }

}
