/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NebbieEditor.BaseTables;

import NebbieEditor.utilities.MUDRenderer;
import NebbieEditor.utilities.renderers.NOANSIRenderer;
import NebbieEditor.utilities.renderers.NebbieRenderer;

/**
 *
 * @author luca.scarcia
 */
public enum RENDERTYPE {
    NOANSI("", new NOANSIRenderer()),
    NEBBIE("nebbie", new NebbieRenderer());
    
    public static RENDERTYPE decode(String id) {
        String workID = id.toLowerCase();
        for(RENDERTYPE type:RENDERTYPE.values()) {
            if(type.ID.equalsIgnoreCase(workID)) 
                return type;
        }
        return NOANSI;
    }
    
    public final String ID;
    public final MUDRenderer Renderer;
    
    RENDERTYPE(String id, MUDRenderer renderer) {
        ID = id;
        Renderer = renderer;
    }
    
}
