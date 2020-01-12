/*
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
package ru.VladG24YT.ConsoleSCP;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author VladG24YT
 */
public class ConsoleSCP {

    static Logger LOGGER;

    public static void main(String[] args) throws IOException {
        new GUIMaker().setVisible(true);
    }
    
    static {
        try (FileInputStream ins = new FileInputStream("C:\\SCP Console\\logs\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(GUIMaker.class.getName());
            System.out.println("Logger initiated");
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
}
