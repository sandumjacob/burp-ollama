package com.jacobsandum;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.ui.editor.HttpRequestEditor;
import burp.api.montoya.ui.editor.HttpResponseEditor;

import javax.swing.*;
import java.awt.*;


public class BurpOllamaSettingsTab extends JComponent
{

    private final BurpOllamaExtension extension;


    public BurpOllamaSettingsTab(BurpOllamaExtension extension) {
        this.extension = extension;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        // Options UI
        JPanel optionsContent = new JPanel();
        optionsContent.setName("The One Ring Custom Tab Panel");
        optionsContent.setBackground(Color.BLUE);

        JTextField hostTextField = new JTextField(32);

    }
}

