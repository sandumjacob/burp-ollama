package com.jacobsandum;

import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.http.message.responses.HttpResponse;
import io.github.ollama4j.*;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.chat.OllamaChatRequest;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OllamaSecurityAPI  {

    private static final Logger log = LoggerFactory.getLogger(OllamaSecurityAPI.class);
    OllamaAPI ollamaAPI;
    public String ollamaHost;
    public int ollamaPort;
    public String model = "deepseek-r1:1.5b";

    public OllamaSecurityAPI(OllamaAPI ollamaAPI) {
        this.ollamaAPI = ollamaAPI;
        this.ollamaAPI.setRequestTimeoutSeconds(100);
    }

    public void checkOllamaStatuts() throws IOException, OllamaBaseException, InterruptedException {
        System.out.println(ollamaAPI.ping());
        System.out.println(ollamaAPI.ps());
    }

    private String buildAnalyzePrompt(HttpRequest request, HttpResponse response) {
        System.out.println("test");

        return String.format(
            "You are a LLM assistant tasked with helping improve the security of a web application that is being analyzed in Burpsuite. Please identify the security issues in the following HTTP Request and HTTP Response pair: \n%s \n\n%s \n"
                , request.toString(), response.toString());
    }

    public String analyze(HttpRequest request, HttpResponse response) {

        String prompt = buildAnalyzePrompt(request, response);
        OllamaResult ollamaResult;
        try {
            ollamaResult = ollamaAPI.generate(this.model, prompt, false, new OptionsBuilder().build());
        } catch (Exception e) {
            log.error("e: ", e);
            return e.toString();
        }
        return ollamaResult.getResponse();
    }


    public static void main(String[] args) throws IOException, OllamaBaseException, InterruptedException {
        OllamaSecurityAPI ollamaSecurityAPI = new OllamaSecurityAPI(new OllamaAPI());
        ollamaSecurityAPI.checkOllamaStatuts();
    }
}
