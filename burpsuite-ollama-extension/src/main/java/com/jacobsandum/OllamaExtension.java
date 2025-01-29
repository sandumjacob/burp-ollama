package com.jacobsandum;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
// import burp.api.montoya.*;
import burp.api.montoya.ui.menu.BasicMenuItem;
import burp.api.montoya.ui.menu.Menu;
import burp.api.montoya.ui.menu.MenuItem;

//Burp will auto-detect and load any class that extends BurpExtension.
public class OllamaExtension implements BurpExtension {

    public MontoyaApi api;

    @Override
    public void initialize(MontoyaApi api)
    {
        this.api = api;
        // set extension name
        api.extension().setName("Burp Garak Extension");

        Logging logging = api.logging();

        // write a message to our output stream
        logging.logToOutput("Loaded Ollama Extension");

        // write a message to our error stream
//        logging.logToError("Hello error.");

        // write a message to the Burp alerts tab
//        logging.raiseInfoEvent("Hello info event.");
//        logging.raiseDebugEvent("Hello debug event.");
//        logging.raiseErrorEvent("Hello error event.");
//        logging.raiseCriticalEvent("Hello critical event.");

        // throw an exception that will appear in our error stream
//        throw new RuntimeException("Hello exception.");


    }

    public static void main(String[] args) {
        System.out.println("Running Extension");
    }
}
