package com.jacobsandum;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import burp.api.montoya.burpsuite.BurpSuite;
import burp.api.montoya.collaborator.Collaborator;
import burp.api.montoya.comparer.Comparer;
import burp.api.montoya.decoder.Decoder;
import burp.api.montoya.extension.Extension;
import burp.api.montoya.http.Http;
import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.intruder.Intruder;
import burp.api.montoya.logging.Logging;
import burp.api.montoya.organizer.Organizer;
import burp.api.montoya.persistence.Persistence;
import burp.api.montoya.project.Project;
import burp.api.montoya.proxy.Proxy;
import burp.api.montoya.repeater.Repeater;
import burp.api.montoya.scanner.Scanner;
import burp.api.montoya.scope.Scope;
import burp.api.montoya.sitemap.SiteMap;
import burp.api.montoya.ui.Selection;
import burp.api.montoya.ui.UserInterface;
import burp.api.montoya.ui.editor.Editor;
import burp.api.montoya.ui.editor.HttpRequestEditor;
import burp.api.montoya.ui.editor.HttpResponseEditor;
import burp.api.montoya.utilities.Utilities;
import burp.api.montoya.websocket.WebSockets;

import burp.api.montoya.utilities.json.*;

public class OllamaBurpsuiteTab extends JComponent
{

    private final MontoyaApi api;


    public OllamaBurpsuiteTab(MontoyaApi api) {
        this.api = api;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        // Options UI
        JPanel optionsContent = new JPanel();
        optionsContent.setName("The One Ring Custom Tab Panel");
        optionsContent.setBackground(Color.WHITE);

    }
}

