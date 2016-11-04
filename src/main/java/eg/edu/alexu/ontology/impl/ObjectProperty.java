/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IConcept;
import eg.edu.alexu.ontology.IEntity;
import eg.edu.alexu.ontology.IOntology;
import java.net.URI;

/**
 *
 * @author sameh
 */
public class ObjectProperty extends Property {

    public ObjectProperty(URI id, IOntology ontology, IConcept range) {
        super(id, ontology, range);
    }
    
    @Override
    public IConcept getRange() {
        return (IConcept)super.getRange();
    }
}
