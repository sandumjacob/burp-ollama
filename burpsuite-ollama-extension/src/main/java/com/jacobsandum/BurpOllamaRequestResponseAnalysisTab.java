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

        // Editor Controls UI
        JPanel editorControls = new JPanel();

        HttpRequestEditor ollamaRequestEditor  = extension.burpApi.userInterface().createHttpRequestEditor();

        HttpResponseEditor ollamaResponseEditor = extension.burpApi.userInterface().createHttpResponseEditor();

        JTextPane ollamaOutputPane = new JTextPane();
        ollamaOutputPane.setText("Ollama output here!");

        JPanel ollamaControlPanel = new JPanel();

        JTextField ollamaQueryField = new JTextField(32);
        ollamaControlPanel.add(ollamaQueryField);

        JButton ollamaAnalyzeButton = new JButton("Analyze");
        ollamaAnalyzeButton.addActionListener(e -> {
            ollamaOutputPane.setText(this.extension.ollamaSecurityAPI.analyze(ollamaRequestEditor.getRequest(), ollamaResponseEditor.getResponse()));
        });
        ollamaControlPanel.add(ollamaAnalyzeButton);

        add(ollamaControlPanel);

        add(ollamaOutputPane);


        add(ollamaRequestEditor.uiComponent());
        add(ollamaResponseEditor.uiComponent());



    }
}

