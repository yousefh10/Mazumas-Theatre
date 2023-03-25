package Entities;

import GUI.MainGUI;

public class RegisteredUserStrategy implements Strategy {
    public RegisteredUserStrategy() {
    }

    @Override
    public void payment() {
        MainGUI.button = "logged";
    }
}
