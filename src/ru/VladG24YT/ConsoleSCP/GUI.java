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
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * TODO
 *
 * Rename to <code>GUI</code>, transform into a GUI interface when interacting
 * with digital technologies
 *
 * @author VladG24YT
 */
public class GUI implements KeyListener {

    //GUI variables
    static JFrame window;
    //static JPanel controlPanel, treePanel, fileTree, outputPanel, loggerPanel, userPanel;
    static JButton enter, msg, help;
    static JLabel user, access;
    static JTextField path, commandLine, userView, accessView;
    static JTextArea sections, files, outputArea, logger;
    boolean isFullscreen;

    //Extra variables
    static Logger LOGGER;
    Game game;

    //Game variables
    String currentPath, username, password;
    String[] filesArray, directoriesArray, mailArray;

    /**
     * Constructor of the class
     *
     */
    public GUI(Logger log) {
        try {
            LOGGER = log;
            //Initialization
            isFullscreen = false;
            window = new JFrame("SCP Console v0.0.1 alpha | Java 8 Edition");
            LOGGER.info("JFrame \'window\' инициализирвоана");
            
            /*controlPanel = new JPanel();
            LOGGER.info("JPanel \'controlPanel\' инициализирована");
            treePanel = new JPanel();
            LOGGER.info("JPanel \'treePanel\' инициализирована");
            fileTree = new JPanel();
            LOGGER.info("JPanel \'fileTree\' инициализирована");
            outputPanel = new JPanel();
            LOGGER.info("JPanel \'outputPanel\' инициализирована");
            loggerPanel = new JPanel();
            LOGGER.info("JPanel \'loggerPanel\' инициализирована");
            userPanel = new JPanel();
            LOGGER.info("JPanel \'userPanel\' инициализирована");*/
            
            enter = new JButton("Ввод");
            LOGGER.info("JButton \'enter\' инициализирована");
            msg = new JButton("📧");
            LOGGER.info("JButton \'msg\' инициализирована");
            help = new JButton("!");
            LOGGER.info("JButton \'help\' инициализирована");
            
            user = new JLabel("Имя пользователя: ");
            LOGGER.info("JLabel \'user\' инициализирована");
            access = new JLabel("Уровень доступа: ");
            LOGGER.info("JLabel \'access\' инициализирована");
            
            path = new JTextField();
            LOGGER.info("JTextField \'path\' инициализирована");
            commandLine = new JTextField();
            LOGGER.info("JTextField \'commandLine\' инициализирована");
            userView = new JTextField();
            LOGGER.info("JTextField \'userView\' инициализирована");
            accessView = new JTextField();
            LOGGER.info("JTextField \'accessView\' инициализирована");
            
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
            window.setBackground(Color.BLACK);

            //path TextField
            path.setBackground(Color.BLACK);
            path.setForeground(Color.WHITE);
            path.setFont(Font.decode("Consolas 14"));
            LOGGER.info("Завершена настройка JTextField \'path\'");

            //commandLine TextField
            commandLine.setBackground(Color.BLACK);
            commandLine.setForeground(Color.WHITE);
            commandLine.setFont(Font.decode("Consolas 14"));
            LOGGER.info("Завершена настройка JTextField \'commandLine\'");

            //enter JButton
            enter.setActionCommand("enter");
            enter.addActionListener(game);
            enter.setBackground(Color.BLACK);
            enter.setForeground(Color.WHITE);
            enter.setFont(Font.decode("Consolas 14"));
            LOGGER.info("Завершена настройка JButton \'enter\'");

            //sections JTextArea
            sections.setBounds(1, 1, treePanel.getWidth() - 2, treePanel.getHeight() - 2);
            sections.setBackground(Color.BLACK);
            sections.setForeground(Color.WHITE);
            sections.setFont(Font.decode("Consolas 14"));
            sections.setText("Objects\nPhotos\nWitnesses\nUHF");
            LOGGER.info("Завершена настройка JTextArea \'sections\'");

            //files JTextArea
            files.setBounds(1, 1, fileTree.getWidth() - 2, fileTree.getHeight() - 2);
            files.setBackground(Color.BLACK);
            files.setForeground(Color.WHITE);
            files.setFont(Font.decode("Consolas 14"));
            files.setText("FILE\nFILE\nFILE\nEXE");
            LOGGER.info("Завершена настройка JTextArea \'files\'");

            //logger JTextArea
            logger.setBounds(1, 1, loggerPanel.getWidth() - 2, loggerPanel.getHeight() - 2);
            logger.setBackground(Color.BLACK);
            logger.setForeground(Color.GREEN);
            logger.setText("User@qactive");
            logger.setFont(Font.decode("Consolas 14"));

            //outputArea JTextArea
            outputArea.setBounds(1, 1, outputPanel.getWidth() - 2, outputPanel.getHeight() - 2);
            outputArea.setBackground(Color.BLACK);
            outputArea.setForeground(Color.WHITE);
            outputArea.setFont(Font.decode("Consolas 14"));
            outputArea.setText("Welcome to SCP Console v0.0.1 Java Edition - a SCP Foundation-based text quest\n---------\nWhat's new:\n- 0.0.1:\n\tCopied the GUI from the Visual Basic version\n-0.0.2:\n\tAdded pop-up windowed tutorial");
            LOGGER.info("Завершена настройка JTextArea \'outputArea\'");

            //'Adders'
            /*treePanel.add(sections);
            LOGGER.info("sections added");
            fileTree.add(files);
            LOGGER.info("files added");
            outputPanel.add(outputArea);
            LOGGER.info("outputArea added");
            loggerPanel.add(logger);
            LOGGER.info("logger added");*/

            initMainPanel();
            LOGGER.info("window initiated");
            
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            LOGGER.info("DefaultCloseOperation = JFrame.EXIT_ON_CLOSE");
            
            java.awt.EventQueue.invokeLater(new Runnable() {                
                public void run() {
                    LOGGER.info("Is Running");
                    JFrame.setDefaultLookAndFeelDecorated(false);
                    LOGGER.info("DefaultLookAndFeelDecorated = false");
                    window.setVisible(true);
                    LOGGER.info("Window viewed");
                }                
            });            
            
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

    /**
     * Layout for User info
     */
    /*void initUserPanel() {
        GroupLayout userLayout = new GroupLayout(userPanel);
        userPanel.setLayout(userLayout);
        userLayout.setAutoCreateGaps(true);
        userLayout.setAutoCreateContainerGaps(true);

        userLayout.setHorizontalGroup(userLayout.createSequentialGroup()
                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(user)
                        .addComponent(access)
                )
                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userView)
                        .addComponent(accessView)
                )
                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(msg)
                        .addComponent(help)
                )
        );

        userLayout.setVerticalGroup(userLayout.createSequentialGroup()
                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(user)
                        .addComponent(userView)
                        .addComponent(msg)
                )
                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(userLayout.createSequentialGroup()
                                .addGroup(userLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(access)
                                        .addComponent(accessView)
                                        .addComponent(help)
                                )
                        )
                )
        );
    }*/
    /**
     * Layout for game controls
     */
    /*void initControlPanel() {
        GroupLayout controlLayout = new GroupLayout(controlPanel);
        controlPanel.setLayout(controlLayout);
        controlLayout.setAutoCreateContainerGaps(true);
        controlLayout.setAutoCreateGaps(true);

        controlLayout.setHorizontalGroup(controlLayout.createSequentialGroup()
                .addGroup(controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(path)
                        .addComponent(commandLine)
                )
                .addGroup(controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(enter)
                )
        );

        controlLayout.setVerticalGroup(controlLayout.createSequentialGroup()
                .addGroup(controlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(path)
                )
                .addGroup(controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(controlLayout.createSequentialGroup()
                                .addGroup(controlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(commandLine)
                                        .addComponent(enter)
                                )
                        )
                )
        );
    }*/
    /**
     * Main layout for the GUI
     * 
     * TODO
     *
     * Заменить JPanel'и на JComponent'ы
     */
    void initMainPanel() {
        LOGGER.info("initiating window");
        GroupLayout panLayout = new GroupLayout(window);
        window.setLayout(panLayout);
        panLayout.setAutoCreateGaps(true);
        panLayout.setAutoCreateContainerGaps(true);
        
        panLayout.setHorizontalGroup(panLayout.createSequentialGroup()
                .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(treePanel)
                        //.addComponent(controlPanel)
                        .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fileTree)
                        )
                        .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                //.addComponent(userPanel)
                                .addComponent(outputPanel)
                        )
                        .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(loggerPanel)
                        )
                )
        );
        LOGGER.info("HorizontalGroup set");
        
        panLayout.setVerticalGroup(panLayout.createSequentialGroup()
                .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        //.addComponent(userPanel)
                        .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panLayout.createSequentialGroup()
                                        /*.addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(controlPanel)
                                        )*/
                                        .addGroup(panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(treePanel)
                                                .addComponent(fileTree)
                                                .addComponent(outputPanel)
                                                .addComponent(loggerPanel)
                                        )
                                )
                        )
                )
        );
        LOGGER.info("VerticalGroup set");
        //window.pack();
        LOGGER.info("window NOT packed");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F11) {
            if (isFullscreen) {
                window.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 450, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 300, 900, 600);
            } else {
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
