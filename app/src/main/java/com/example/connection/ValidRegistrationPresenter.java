package com.example.connection;

import java.util.HashMap;
import java.util.Map;

public class ValidRegistrationPresenter {
    private OnValidDataListener onValidDataListener;
    private CheckConnection checkConnection;
    private Map<String,String> users = new HashMap<>();
    public ValidRegistrationPresenter(OnValidDataListener onValidDataListener) {
        this.onValidDataListener = onValidDataListener;
        checkConnection = new CheckConnection();
    }
    public void isValidData(String username, String password,String repPass) {
        RegistrationValidation loginValidation = new RegistrationValidation();
        if (!checkConnection.isConnected())
            return;
        if (loginValidation.isValidUsername(username) &&
                loginValidation.isValidPassword(password,username) && loginValidation.isRepeatePasswordValid(password,repPass))
        {
            users.put(username, password);
            onValidDataListener.isValidData();
        }
        else
            onValidDataListener.onDataError();


}
    public void isValidLogin(String username,String password){
        if((users.containsKey(username))&&(users.get(username).equals(password)))
            onValidDataListener.isValidData();
 }
}

