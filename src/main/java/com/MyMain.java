package com;

import com.controller.Controller;
import com.controller.ControllerInt;
import com.model.util.Util;

public class MyMain {
    public static void main(String[] args) {


        ControllerInt c = new Controller();
        Util.printMessage("Please write path where you want your program working");
        Util.path = c.inputCommand();
        Util.printMessage("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
        c.start();

    }
}
