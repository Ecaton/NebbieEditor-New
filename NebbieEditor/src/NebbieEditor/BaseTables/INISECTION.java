/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NebbieEditor.BaseTables;

/**
 *
 * @author luca.scarcia
 */
public enum INISECTION {
    UNDEFINED(""),
    UNKNOWN(""),
    ADMIN("Administrative"),
    MOB("Mobiles"),
    OBJ("Objects"),
    TEXT("Text");
    
    public final String ID;
    
    public static INISECTION decode(String id) {
        for(INISECTION section:INISECTION.values()) {
            if(section.ID.equalsIgnoreCase(id))
                return section;
        }
        return UNKNOWN;
    }
    
    INISECTION(String id) {
        ID = id;
    }
    
}
