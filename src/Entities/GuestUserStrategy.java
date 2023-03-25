package Entities;

import GUI.MainGUI;

public class GuestUserStrategy implements Strategy {
    public GuestUserStrategy() {
    }

    @Override
    public void payment() {
        MainGUI.button = "guest";
    }
}
