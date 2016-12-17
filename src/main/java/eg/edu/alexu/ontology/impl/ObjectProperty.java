/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IObjectProperty;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.common.ID;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class ObjectProperty extends Property implements IObjectProperty {
    
    public ObjectProperty(ID id) {
        super(id);
    }

    public ObjectProperty(ID id, IOntology ontology, IClass range) {
        super(id, ontology);
        this.ranges = new HashSet<IClass>();
        ((Set<IClass>)this.ranges).add(range);
    }
    
    @Override
    public Set<IClass> getRange() {
        return (Set<IClass>)super.getRange();
    }

    @Override
    public IObjectProperty getInverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
