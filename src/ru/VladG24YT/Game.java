package ru.VladG24YT;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * TODO
 *
 * 1.) Copy the interface 
 * 2.) Create some simple story 
 * 3.) Better up the interface 
 * 4.) Make a popup-windowed tutorial
 */
public class Game implements ActionListener {

    //GUI variables
    JFrame window;
    JPanel mainPanel, controlPanel, treePanel, fileTree, outputPanel, loggerPanel, userPanel;
    JButton enter, confirmButton;
    JTextField path, commandLine, usernameInput, passwordInput;
    JTextArea sections, files, outputArea, logger;

    //Game variables
    String username, password, currentPath;
    String[] filesArray, directoriesArray, mailArray;
    int accessLevel, hrs, min, sec;

    public Game() {
        //Initialization
        window = new JFrame();
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);

        mainPanel = new JPanel();
        controlPanel = new JPanel();
        treePanel = new JPanel();
        fileTree = new JPanel();
        outputPanel = new JPanel();
        loggerPanel = new JPanel();
        userPanel = new JPanel();

        enter = new JButton("Ввод");
        confirmButton = new JButton("Подтвердить");

        path = new JTextField();
        commandLine = new JTextField();
        usernameInput = new JTextField();
        passwordInput = new JTextField();

        sections = new JTextArea();
        files = new JTextArea();
        outputArea = new JTextArea();
        logger = new JTextArea();

        //mainPanel JPanel
        mainPanel.setBounds(window.getWidth() / 2 - 450, window.getHeight() / 2 - 300, 900, 600);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);
        mainPanel.add(controlPanel);
        mainPanel.add(treePanel);
        mainPanel.add(fileTree);
        mainPanel.add(outputPanel);
        mainPanel.add(loggerPanel);
        mainPanel.add(userPanel);

        //controlPanel JPanel
        controlPanel.setBounds(mainPanel.getX() + 20, mainPanel.getY() + mainPanel.getHeight() - 70, mainPanel.getWidth() - 40, 70);
        controlPanel.setLayout(null);
        controlPanel.setBackground(Color.WHITE);
        controlPanel.add(path);
        controlPanel.add(commandLine);
        controlPanel.add(enter);

        //path TextField
        path.setBounds(5, 5, controlPanel.getWidth() - 10, 30);
        path.setBackground(Color.BLACK);
        path.setForeground(Color.WHITE);
        path.setFont(Font.decode("Consolas 14"));
        path.setText("./" + username + "/home/");

        //commandLine TextField
        commandLine.setBounds(5, path.getHeight() + 5, controlPanel.getWidth() - 125, 30);
        commandLine.setBackground(Color.BLACK);
        commandLine.setForeground(Color.WHITE);
        commandLine.setFont(Font.decode("Consolas 14"));

        //enter JButton
        enter.setActionCommand("enter");
        enter.addActionListener(this);
        enter.setBackground(Color.BLACK);
        enter.setForeground(Color.WHITE);
        enter.setFont(Font.decode("Consolas 14"));
        enter.setBounds(commandLine.getWidth() + 10, commandLine.getY(), 109, 30);

        //treePanel JPanel
        treePanel.setBounds(mainPanel.getWidth() / 6, 50, mainPanel.getWidth() / 6, mainPanel.getHeight() - controlPanel.getHeight());
        treePanel.setBackground(Color.WHITE);
        treePanel.add(sections);

        //sections JTextArea
        sections.setBounds(5, 5, treePanel.getWidth() - 5, treePanel.getHeight() - 5);
        sections.setBackground(Color.BLACK);

        //fileTree JPanel
        fileTree.setBounds(0, 0, 0, 0);
        fileTree.setBackground(Color.WHITE);
        fileTree.add(files);

        //outputPanel JPanel
        outputPanel.setBounds(0, 0, 0, 0);
        outputPanel.setBackground(Color.WHITE);
        outputPanel.add(outputArea);

        //loggerPanel JPanel
        loggerPanel.setBounds(0, 0, 0, 0);
        loggerPanel.setBackground(Color.WHITE);
        loggerPanel.add(logger);

        //userPanel JPanel
        userPanel.setBounds(0, 0, 0, 0);
        userPanel.setBackground(Color.WHITE);
        userPanel.add(usernameInput);
        userPanel.add(passwordInput);
        userPanel.add(confirmButton);

        //window JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.WHITE);
        window.add(mainPanel);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //Enter button
        if (command.equals("enter")) {
            String cmd = commandLine.getText();
            if (cmd.equals("info")) {

            } else if (cmd.equals("mail")) {

            } else if (cmd.contains("start ")) {
                String program;
            }
        }
    }
}