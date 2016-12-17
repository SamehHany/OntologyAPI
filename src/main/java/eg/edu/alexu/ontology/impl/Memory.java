/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IOntologyElement;
import eg.edu.alexu.ontology.common.ID;
import eg.edu.alexu.util.KeyedSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sameh
 */
class Memory {
    private static KeyedSet<ID, IOntologyElement> data;
    static {
        data = new KeyedSet<>((IOntologyElement e) -> e.getId());
    }
    
    public static void put(IOntologyElement element) {
        if (!data.contains(element)) {
            data.add(element);
        }
    }
    
    public static IOntologyElement get(ID id) {
        return data.get(id);
    }
    
    public static <T extends IOntologyElement> T get(Object id,
            Class<T> clss) {
        return get(new ID(id), clss);
    }
    
    public static <T extends IOntologyElement> T get(ID id,
            Class<T> clss) {
        IOntologyElement ret = get(id);
        if (ret != null && ret.getClass().equals(clss)) {
            return (T)ret;
        }
        
        Constructor<T> constructor = null;
        try {
            constructor = clss.getConstructor(ID.class);
        } catch (NoSuchMethodException
                | SecurityException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        
        if (constructor == null) {
            return null;
        }
        
        ret = null;
        try {
            ret = constructor.newInstance(id);
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        
        if (ret != null) {
            put((T)ret);
        }
        
        return (T)ret;
    }
    
    public static IOntologyElement get(IOntologyElement element) {
        return data.get(element.getId());
    }
    
    public static boolean exists(IOntologyElement element) {
        return data.hasKey(element.getId());
    }
}
