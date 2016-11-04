/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IConcept;
import eg.edu.alexu.ontology.IDataProperty;
import eg.edu.alexu.ontology.IObjectProperty;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import eg.edu.alexu.util.KeyedSet;
import java.net.URI;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class Concept extends Entity implements IConcept {
    
    private Set<IObjectProperty> objectProperties;
    private Set<IDataProperty> dataProperties;

    public Concept(URI id, IOntology ontology) {
        super(id, ontology);
    }

    @Override
    public Set<IProperty> getProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IObjectProperty> getObjectProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IDataProperty> getDataProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IConcept> getAdjacent() {
        Set<IConcept> adjacents = Common.getSet(IConcept.class);
        for (IObjectProperty property : objectProperties) {
            adjacents.add(property.getRange());
        }
        
        return adjacents;
    }
    
}
