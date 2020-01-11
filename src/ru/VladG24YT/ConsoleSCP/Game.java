/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.VladG24YT.ConsoleSCP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements ActionListener {

    static Logger LOGGER;

    public Game(Logger log) {
        LOGGER = log;
        new GUI(LOGGER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        LOGGER.info("Вызван ActionEvent: " + e.getActionCommand());
        //Enter button
        if (command.equals("enter")) {
            try {
                String cmd = "";
                if (cmd.equals("info")) {
                    
                } else if (cmd.equals("mail")) {
                    
                } else if (cmd.contains("start ")) {
                    String program = null;
                }
            } catch (SecurityException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
