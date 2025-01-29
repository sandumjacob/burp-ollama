package com.jacobsandum;

import io.github.ollama4j.*;
import io.github.ollama4j.exceptions.OllamaBaseException;

import java.io.IOException;

public class OllamaSecurityAPI  {

    OllamaAPI ollamaAPI;
    public String ollamaHost;
    public int ollamaPort;

    public OllamaSecurityAPI(OllamaAPI ollamaAPI) {
        this.ollamaAPI = ollamaAPI;
    }

    public void checkOllamaStatuts() throws IOException, OllamaBaseException, InterruptedException {
        System.out.println(ollamaAPI.ping());
        System.out.println(ollamaAPI.ps());
    }

    public static void main(String[] args) throws IOException, OllamaBaseException, InterruptedException {
        OllamaSecurityAPI ollamaSecurityAPI = new OllamaSecurityAPI(new OllamaAPI());
        ollamaSecurityAPI.checkOllamaStatuts();
    }
}
