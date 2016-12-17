/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IDataProperty;
import eg.edu.alexu.ontology.IDatatype;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.common.ID;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class DataProperty extends Property implements IDataProperty {
    
    public DataProperty(ID id) {
        super(id);
    }

    public DataProperty(ID id, IOntology ontology, IDatatype range) {
        super(id, ontology);
        this.ranges = new HashSet<IDatatype>();
        ((Set<IDatatype>)this.ranges).add(range);
    }
    
    @Override
    public Set<IDatatype> getRange() {
        return (Set<IDatatype>)super.getRange();
    }
}
