package com;

import com.controller.Controller;
import com.controller.ControllerInt;
import com.model.util.PropertiesMessage;
import com.model.util.Util;

public class MyMain {
    public static void main(String[] args) {

        PropertiesMessage message= new PropertiesMessage();
        ControllerInt c = new Controller();
//        Util.printMessage("Please write path where you want your program working");
//        Util.path = c.inputCommand();
        Util.printMessage(message.getMessage("start"));
        c.start();

    }
}
