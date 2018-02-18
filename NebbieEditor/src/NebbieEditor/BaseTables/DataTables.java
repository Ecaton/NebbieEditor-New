/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NebbieEditor.BaseTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca.scarcia
 */
public class DataTables {
    
    private static final Logger LOG = Logger.getLogger(DataTables.class.getName());
    
    public double XPAdjust = 1.0;
    public double MaxXPAdjust = 1.0;
    public double GoldXPAdjust = 1.0;
    public int Columns = 60;
    
    public boolean fillTables(String baseFolder) {
        Path path = Paths.get(baseFolder, "MUD.ini");
        try {
            readIniFile(path.toFile());
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean readIniFile(File iniFile) throws ParseException {
        INISECTION section = INISECTION.UNDEFINED;
        RENDERTYPE renderType = RENDERTYPE.NOANSI;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(iniFile));
            String line;
            while((line = br.readLine().trim())!=null) {
                if(line.startsWith("[") && line.endsWith("]")) {
                    String sectionName = line.substring(1, line.length()-1);
                    section = INISECTION.decode(sectionName.toLowerCase());
                    if(section == INISECTION.UNKNOWN) 
                        LOG.log(Level.WARNING,"Found unknown section {0}",section);
                } else {
                    int lastPos = 0;
                    int pos;
                    pos = line.indexOf("=");
                    String name;
                    String value;
                    if(pos>=0) {
                        name = line.substring(0,pos).trim();
                        value = line.substring(pos+1,line.length()).trim();
                    } else {
                        name = line.trim();
                        value = "";
                    }
                    if("".equals(name)) {
                    } else 
                        switch(section) {
                        case ADMIN:
                            switch(name.toLowerCase()) {
                                case "special":
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                                    break;
                                case "advanced":
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                                    break;
                                default:
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                            }
                            break;
                        case MOB:
                            switch(name.toLowerCase()) {
                                case "adjust":
                                    XPAdjust = Double.parseDouble(value);
                                    break;
                                case "goldadjust":
                                    GoldXPAdjust = Double.parseDouble(value);
                                    break;
                                case "maxlevadjust":
                                    MaxXPAdjust = Double.parseDouble(value);
                                    break;
                                default:
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                            }
                            break;
                        case OBJ:
                            switch(name.toLowerCase()) {
                                case "minlevel":
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                                    break;
                                case "leveladjust":
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                                    break;
                                case "autosetrarevalue":
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                                    break;
                                default:
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                            }
                            break;
                        case TEXT:
                            switch(name.toLowerCase()) {
                                case "columns":
                                    Columns = Integer.parseInt(value);
                                    break;
                                case "render":
                                    
                                    break;
                                default:
                                    LOG.log(Level.WARNING,"Ignored variable {0}",name);
                            }
                            break;
                        case UNDEFINED:
                            throw new ParseException("Invalid MUD.ini file; found variable without previous section header!",-1);
                        case UNKNOWN:
                            LOG.log(Level.WARNING,"Ignored variable {0} in unknown section.",name);
                            break;
                        default:
                            throw new AssertionError(section.name());
                        }
                }
            }
            br.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataTables.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DataTables.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
