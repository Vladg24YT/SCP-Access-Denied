package ru.VladG24YT.console_scp;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class Game implements ActionListener, KeyListener {

    //GUI variables
    JFrame window;
    JPanel mainPanel, controlPanel, treePanel, fileTree, outputPanel, loggerPanel/*, userPanel*/;
    JButton enter/*, confirmButton*/;
    JTextField path, commandLine/*, usernameInput, passwordInput*/;
    JTextArea sections, files, outputArea, logger;
    boolean isFullscreen;

    //Extra variables
    static Logger LOGGER;

    //Game variables
    String username, password, currentPath;
    String[] filesArray, directoriesArray, mailArray;
    int accessLevel, hrs, min, sec;

    void drawWindow() {
        if (isFullscreen) {
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);
        } else {
            window.setBounds(window.getWidth() / 2 - 450, window.getHeight() / 2 - 300, 900, 600);
        }
        LOGGER.info("Параметры окна изменены на " + window.getBounds().toString());
    }

    public Game() throws FileNotFoundException, IOException {
        try {
            //Initialization
            window = new JFrame();
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
            /*userPanel = new JPanel();
            LOGGER.info("JPanel userPanel инициализирована");*/

            enter = new JButton("Ввод");
            LOGGER.info("JButton \'enter\' инициализирована");
            /*confirmButton = new JButton("Подтвердить");*/

            path = new JTextField();
            LOGGER.info("JTextField \'path\' инициализирована");
            commandLine = new JTextField();
            LOGGER.info("JTextField \'commandLine\' инициализирована");
            /*usernameInput = new JTextField();
            passwordInput = new JTextField();*/

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
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBackground(Color.WHITE);
            window.add(mainPanel);
            window.addKeyListener(this);
            drawWindow();

            //mainPanel JPanel
            if (isFullscreen) {
                mainPanel.setBounds(window.getWidth() / 2 - 450, window.getHeight() / 2 - 300, 900, 600);
            } else {
                mainPanel.setBounds(0, 0, window.getWidth(), window.getHeight());
            }
            LOGGER.info("Параметры JPanel \'mainPanel\' изменены на " + mainPanel.getBounds().toString());
            mainPanel.setLayout(null);
            mainPanel.setBackground(Color.BLACK);
            mainPanel.add(controlPanel);
            mainPanel.add(treePanel);
            mainPanel.add(fileTree);
            mainPanel.add(outputPanel);
            mainPanel.add(loggerPanel);
            //mainPanel.add(userPanel);
            LOGGER.info("Завершена настройка JPanel \'mainPanel\'");

            //controlPanel JPanel
            controlPanel.setBounds(mainPanel.getX() + 20, mainPanel.getY() + mainPanel.getHeight() - 70, mainPanel.getWidth() - 40, 70);
            controlPanel.setLayout(null);
            controlPanel.setBackground(Color.WHITE);
            controlPanel.add(path);
            controlPanel.add(commandLine);
            controlPanel.add(enter);
            LOGGER.info("Завершена настройка JPanel \'controlPanel\'");

            //path TextField
            path.setBounds(5, 5, controlPanel.getWidth() - 10, 30);
            path.setBackground(Color.BLACK);
            path.setForeground(Color.WHITE);
            path.setFont(Font.decode("Consolas 14"));
            path.setText("./" + username + "/home/");
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
            treePanel.setBounds(mainPanel.getWidth() / 6, 50, mainPanel.getWidth() / 6, mainPanel.getHeight() - controlPanel.getHeight());
            treePanel.setBackground(Color.WHITE);
            treePanel.add(sections);
            LOGGER.info("Завершена настройка JPanel \'treePanel\'");

            //sections JTextArea
            sections.setBounds(5, 5, treePanel.getWidth() - 5, treePanel.getHeight() - 5);
            sections.setBackground(Color.BLACK);
            LOGGER.info("Завершена настройка JTextAea \'sections\'");

            //fileTree JPanel
            fileTree.setBounds(0, 0, 0, 0);
            fileTree.setBackground(Color.WHITE);
            fileTree.add(files);
            LOGGER.info("Завершена настройка JPanel \'fileTree\'");

            //outputPanel JPanel
            outputPanel.setBounds(0, 0, 0, 0);
            outputPanel.setBackground(Color.WHITE);
            outputPanel.add(outputArea);
            LOGGER.info("Завершена настройка JPanel \'outputPanel\'");

            //loggerPanel JPanel
            loggerPanel.setBounds(0, 0, 0, 0);
            loggerPanel.setBackground(Color.WHITE);
            loggerPanel.add(logger);
            LOGGER.info("Завершена настройка JPanel \'loggerPanel\'");

            /*//userPanel JPanel
            userPanel.setBounds(0, 0, 0, 0);
            userPanel.setBackground(Color.WHITE);
            userPanel.add(usernameInput);
            userPanel.add(passwordInput);
            userPanel.add(confirmButton);*/
            window.setVisible(true);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка в теле класса \'Game\'", e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        LOGGER.info("Вызван ActionEvent: \'" + e.getActionCommand() + "\'");
        //Enter button
        if (command.equals("enter")) {
            String cmd = commandLine.getText();
            if (cmd.equals("info")) {

            } else if (cmd.equals("mail")) {

            } else if (cmd.contains("start ")) {
                String program = null;
            }
        }
        //Confirm button [Further adding]
        /*else if (command.equals("confirm")) {
            String usr = usernameInput.getText();
            String pass = passwordInput.getText();
            if(usr.equals("") && pass.equals("")){
                //TODO
            } else {
                //TODO
                JOptionPane.showMessageDialog(window, "Неправильный логин и/или пароль", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
            }
        }*/
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F11) {
            LOGGER.info("Изменён полноэкранный режим окна");
            isFullscreen = !isFullscreen;
            drawWindow();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("This function is not used."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("This function is not used."); //To change body of generated methods, choose Tools | Templates.
    }

    static {
        try (FileInputStream ins = new FileInputStream("C:\\SCP Console\\logs\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Game.class.getName());
            System.out.println("Logger включён");
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
}
