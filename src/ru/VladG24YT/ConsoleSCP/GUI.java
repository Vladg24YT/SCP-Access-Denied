/*
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
package ru.VladG24YT.ConsoleSCP;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
//import ru.VladG24YT.ConsoleSCP.GameEngine.GameInstance;

/**
 * TODO
 *
 * Rename to <code>GUI</code>, transform into a GUI interface when interacting
 * with digital technologies
 *
 * @author VladG24YT
 */
public class GUI implements ActionListener {

    //GUI variables
    JFrame window;
    JPanel mainPanel, controlPanel, treePanel, fileTree, outputPanel, loggerPanel;
    JButton enter;
    JTextField path, commandLine;
    JTextArea sections, files, outputArea, logger;
    boolean isFullscreen;

    //Extra variables
    /*private static GameInstance currGI;*/
    static Logger LOGGER /*= currGI.getLogger()*/;

    //Game variables
    String currentPath;
    String[] filesArray, directoriesArray, mailArray;

    /**
     * Constructor of the class
     *
     */
    public GUI(/*GameInstance GI*/Logger log) {
        try {
            //currGI = GI;
            LOGGER = log;
            //Initialization
            window = new JFrame("SCP Console v0.0.1 alpha | Java 8 Edition");
            LOGGER.info("JFrame \'window\' инициализирвоана");
            
            mainPanel = new JPanel();
            LOGGER.info("JPanel \'mainPanel\' инициализирована");
            controlPanel = new JPanel();
            LOGGER.info("JPanel \'controlPanel\' инициализирована");
            treePanel = new JPanel();
            LOGGER.info("JPanel \'treePanel\' инициализирована");
            fileTree = new JPanel();
            LOGGER.info("JPanel \'fileTree\' инициализирована");
            outputPanel = new JPanel();
            LOGGER.info("JPanel \'outputPanel\' инициализирована");
            loggerPanel = new JPanel();
            LOGGER.info("JPanel \'loggerPanel\' инициализирована");
            
            enter = new JButton("Ввод");
            LOGGER.info("JButton \'enter\' инициализирована");
            
            path = new JTextField();
            LOGGER.info("JTextField \'path\' инициализирована");
            commandLine = new JTextField();
            LOGGER.info("JTextField \'commandLine\' инициализирована");
            
            sections = new JTextArea();
            LOGGER.info("JTextArea \'sections\' инициализирована");
            files = new JTextArea();
            LOGGER.info("JTextArea \'files\' инициализирована");
            outputArea = new JTextArea();
            LOGGER.info("JTextArea \'outputArea\' инициализирована");
            logger = new JTextArea();
            LOGGER.info("JTextArea \'logger\' инициализирована");
            
            isFullscreen = true;
            LOGGER.info("boolean \'isFullscreen\' установлена в значение \'true\'");

            //window JFrame
            window.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 450, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 300, 900, 600);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBackground(Color.WHITE);

            //mainPanel JPanel
            /*if (isFullscreen) {
                mainPanel.setBounds(window.getWidth() / 2 - 450, window.getHeight() / 2 - 300, 900, 600);
            } else {*/
            mainPanel.setBounds(0, 0, window.getWidth(), window.getHeight());
            //}
            LOGGER.info("Параметры JPanel \'mainPanel\' изменены на " + mainPanel.getBounds().toString());
            //mainPanel.setLayout(null);
            mainPanel.setBackground(Color.BLACK);
            LOGGER.info("Завершена настройка JPanel \'mainPanel\'");

            //controlPanel JPanel
            controlPanel.setBounds(mainPanel.getX() + 20, mainPanel.getY() + mainPanel.getHeight() - 70, mainPanel.getWidth() - 40, 70);
            controlPanel.setLayout(null);
            controlPanel.setBackground(Color.WHITE);
            LOGGER.info("Завершена настройка JPanel \'controlPanel\'");

            //path TextField
            path.setBounds(5, 5, controlPanel.getWidth() - 10, 30);
            path.setBackground(Color.BLACK);
            path.setForeground(Color.WHITE);
            path.setFont(Font.decode("Consolas 14"));
            LOGGER.info("Завершена настройка JTextField \'path\'");

            //commandLine TextField
            commandLine.setBounds(5, path.getHeight() + 5, controlPanel.getWidth() - 125, 30);
            commandLine.setBackground(Color.BLACK);
            commandLine.setForeground(Color.WHITE);
            commandLine.setFont(Font.decode("Consolas 14"));
            LOGGER.info("Завершена настройка JTextField \'commandLine\'");

            //enter JButton
            enter.setActionCommand("enter");
            enter.addActionListener(this);
            enter.setBackground(Color.BLACK);
            enter.setForeground(Color.WHITE);
            enter.setFont(Font.decode("Consolas 14"));
            enter.setBounds(commandLine.getWidth() + 10, commandLine.getY(), 109, 30);
            LOGGER.info("Завершена настройка JButton \'enter\'");

            //treePanel JPanel
            treePanel.setBounds(1, 51, mainPanel.getWidth() / 5 - 2, mainPanel.getHeight() - controlPanel.getHeight() - 52);
            treePanel.setBackground(Color.WHITE);
            LOGGER.info("Завершена настройка JPanel \'treePanel\'");

            //sections JTextArea
            sections.setBounds(1, 1, treePanel.getWidth() - 2, treePanel.getHeight() - 2);
            sections.setBackground(Color.BLACK);
            sections.setForeground(Color.WHITE);
            sections.setFont(Font.decode("Consolas 14"));
            sections.setText("Objects\nPhotos\nWitnesses\nUHF");
            LOGGER.info("Завершена настройка JTextArea \'sections\'");

            //fileTree JPanel
            fileTree.setBounds(treePanel.getWidth() + 1, 51, treePanel.getWidth() - 2, treePanel.getHeight() - 2);
            fileTree.setBackground(Color.WHITE);
            LOGGER.info("Завершена настройка JPanel \'fileTree\'");

            //files JTextArea
            files.setBounds(1, 1, fileTree.getWidth() - 2, fileTree.getHeight() - 2);
            files.setBackground(Color.BLACK);
            files.setForeground(Color.WHITE);
            files.setFont(Font.decode("Consolas 14"));
            files.setText("FILE\nFILE\nFILE\nEXE");
            LOGGER.info("Завершена настройка JTextArea \'files\'");

            //loggerPanel JPanel
            loggerPanel.setBounds(mainPanel.getWidth() / 5 * 4 + 1, 51, mainPanel.getWidth() / 5 - 2, fileTree.getHeight() - 2);
            loggerPanel.setBackground(Color.WHITE);
            LOGGER.info("Завершена настройка JPanel \'loggerPanel\'");

            //logger JTextArea
            logger.setBounds(1, 1, loggerPanel.getWidth() - 2, loggerPanel.getHeight() - 2);
            logger.setBackground(Color.BLACK);
            logger.setForeground(Color.GREEN);
            logger.setText("User@qactive");
            logger.setFont(Font.decode("Consolas 14"));

            //outputPanel JPanel
            outputPanel.setBounds(1, 51, mainPanel.getWidth() - (treePanel.getWidth() + fileTree.getWidth() + loggerPanel.getWidth()) - 2, loggerPanel.getHeight() - 2);
            outputPanel.setBackground(Color.WHITE);
            LOGGER.info("Завершена настройка JPanel \'OutputPanel'");

            //outputArea JTextArea
            outputArea.setBounds(1, 1, outputPanel.getWidth() - 2, outputPanel.getHeight() - 2);
            outputArea.setBackground(Color.BLACK);
            outputArea.setForeground(Color.WHITE);
            outputArea.setFont(Font.decode("Consolas 14"));
            outputArea.setText("Welcome to SCP Console v0.0.1 Java Edition - a SCP Foundation-based text quest\n---------\nWhat's new:\n- 0.0.1:\n\tCopied the GUI from the Visual Basic version\n-0.0.2:\n\tAdded pop-up windowed tutorial");
            LOGGER.info("Завершена настройка JTextArea \'outputArea\'");

            //'Adders'
            controlPanel.add(path);
            controlPanel.add(commandLine);
            controlPanel.add(enter);
            treePanel.add(sections);
            fileTree.add(files);
            outputPanel.add(outputArea);
            loggerPanel.add(logger);
            mainPanel.add(controlPanel);
            mainPanel.add(treePanel);
            mainPanel.add(fileTree);
            mainPanel.add(outputPanel);
            mainPanel.add(loggerPanel);
            window.add(mainPanel);
            
            window.setVisible(true);
            
            Timer redrawer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.revalidate();
                    LOGGER.info("\'window\' JFrame updated");
                }
            });
            redrawer.start();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка в теле класса Game", e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        LOGGER.info("Вызван ActionEvent: " + e.getActionCommand());
        //Enter button
        if (command.equals("enter")) {
            String cmd = commandLine.getText();
            if (cmd.equals("info")) {
                
            } else if (cmd.equals("mail")) {
                
            } else if (cmd.contains("start ")) {
                String program = null;
            }
        }
    }
}