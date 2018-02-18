/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NebbieEditor.utilities;

import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JTextPane;

/**
 *
 * @author luca.scarcia
 */
public abstract class MUDRenderer {
    
    public abstract String render(JTextPane output, InputStream input);
    public abstract String decode(JTextPane input, OutputStream output);
    
}
