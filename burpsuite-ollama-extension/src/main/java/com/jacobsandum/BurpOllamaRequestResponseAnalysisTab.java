package com.jacobsandum;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.ui.editor.HttpRequestEditor;
import burp.api.montoya.ui.editor.HttpResponseEditor;

import javax.swing.*;
import java.awt.*;

public class BurpOllamaRequestResponseAnalysisTab extends JComponent
{

    private final BurpOllamaExtension extension;

    public BurpOllamaRequestResponseAnalysisTab(BurpOllamaExtension extension) {
        this.extension = extension;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        JButton ollamaAnalyzeButton = new JButton("Analyze");
        ollamaAnalyzeButton.addActionListener(e -> {

        });
        add(ollamaAnalyzeButton);

        JTextPane ollamaOutputPane = new JTextPane();
        ollamaOutputPane.setText("Ollama output here!");
        add(ollamaOutputPane);


        // Editor Controls UI
        JPanel editorControls = new JPanel();

        HttpRequestEditor ollamaRequestEditor  = extension.burpApi.userInterface().createHttpRequestEditor();

        HttpResponseEditor ollamaResponseEditor = extension.burpApi.userInterface().createHttpResponseEditor();

        add(ollamaRequestEditor.uiComponent());
        add(ollamaResponseEditor.uiComponent());



    }
}

