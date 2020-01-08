/*
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
package ru.VladG24YT.ConsoleSCP.GameEngine;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.JFrame;
import ru.VladG24YT.ConsoleSCP.GUI;

/**
 *
 * @author VladG24YT
 */
public class GameInstance implements KeyListener {

    private JFrame gameWindow;

    private Rectangle windowResolution;

    static Logger LOGGER;

    public GameInstance() {
        gameWindow = new JFrame();
        gameWindow.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 300, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 200, 600, 400);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
        LOGGER.info("Window created");
    }

    public Logger getLogger() {
        return LOGGER;
    }

    public JFrame getWindow() {
        return gameWindow;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_F11) {
            if (gameWindow.getBounds() == new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) {
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(gameWindow);
            } else {
                gameWindow.setBounds(windowResolution);
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

    static {
        try (FileInputStream ins = new FileInputStream("C:\\SCP Console\\logs\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(GUI.class.getName());
            System.out.println("Logger initiated");
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
}
