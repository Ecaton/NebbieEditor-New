/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NebbieEditor.utilities.renderers;

import NebbieEditor.utilities.MUDRenderer;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import javax.swing.JTextPane;
import javax.swing.text.PlainDocument;

/**
 *
 * @author luca.scarcia
 */
public class NOANSIRenderer extends MUDRenderer {

    @Override
    public String render(JTextPane output, InputStream input) {
        Scanner s = new Scanner(input).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        output.setDocument(new PlainDocument());
        output.setText(result);
        return result;
    }

    @Override
    public String decode(JTextPane input, OutputStream output) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
