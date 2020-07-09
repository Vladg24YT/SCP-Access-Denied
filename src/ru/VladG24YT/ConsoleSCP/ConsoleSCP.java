/*
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
package ru.VladG24YT.ConsoleSCP;

import ru.VladG24YT.ConsoleSCP.GUIFullscreen.MainWindow;
import ru.VladG24YT.ConsoleSCP.GUIStandard.ConsoleWindow;

/**
 *
 * @author VladG24YT
 */
public class ConsoleSCP {

    //static Logger LOGGER;
    public static void main(String[] args) {
        //new ConsoleWindow().setVisible(true);
        new MainWindow().setVisible(true);
    }

    /*static {
        try (FileInputStream ins = new FileInputStream("C:\\SCP Console\\logs\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(ConsoleWindow.class.getName());
            System.out.println("Logger initiated");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleSCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsoleSCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
