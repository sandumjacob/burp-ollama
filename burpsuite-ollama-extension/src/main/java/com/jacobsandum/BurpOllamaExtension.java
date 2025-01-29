package com.jacobsandum;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;

import java.io.IOException;
// import burp.api.montoya.*;


//Burp will auto-detect and load any class that extends BurpExtension.
public class BurpOllamaExtension implements BurpExtension {

    public MontoyaApi burpApi;
    public OllamaSecurityAPI ollamaSecurityAPI;


    @Override
    public void initialize(MontoyaApi api)
    {
        this.burpApi = api;
        // set extension name
        api.extension().setName("Burp Ollama Extension");

        Logging logging = api.logging();

        // write a message to our output stream
        logging.logToOutput("Loaded Ollama Extension");

        // Connect to other components
        BurpOllamaSettingsTab burpOllamaSettingsTab = new BurpOllamaSettingsTab(this);
        api.userInterface().registerSuiteTab("Burp Ollama Settings", burpOllamaSettingsTab);

        // Setup Ollama API
        this.ollamaSecurityAPI = new OllamaSecurityAPI(new OllamaAPI());

        try {
            logging.logToOutput(String.valueOf(String.valueOf(ollamaSecurityAPI.ollamaAPI.ps())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (OllamaBaseException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        System.out.println("Running Extension");
    }
}
