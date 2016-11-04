/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IOntologyElement;
import eg.edu.alexu.util.KeyedSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
class Common {
    public static final String NAME_SEPARATOR = ".";
    
    protected static <T extends IOntologyElement> Set<T> getSet(Class<T> clss) {
        return new KeyedSet<>((t) -> t.getId());
    }
}
