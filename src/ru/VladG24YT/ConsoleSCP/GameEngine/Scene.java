/*
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
package ru.VladG24YT.ConsoleSCP.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author VladG24YT
 */
public class Scene {

    protected JPanel scene;

    int[][] objectMap;

    public Scene(GameInstance game) {
        scene.setBounds(game.getWindow().getBounds());
        Timer redrawer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scene.repaint();
            }
        });
    }

    public void readFromFile(File sceneFile) {
        try {
            FileReader read = new FileReader(sceneFile);
            CharBuffer file = null;
            try {
                read.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < file.length(); i++) {

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
