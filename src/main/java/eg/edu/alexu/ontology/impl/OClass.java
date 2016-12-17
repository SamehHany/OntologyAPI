/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IDataProperty;
import eg.edu.alexu.ontology.IObjectProperty;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import eg.edu.alexu.ontology.common.ID;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class OClass extends Entity implements IClass {
    
    protected Set<IObjectProperty> objectProperties;
    protected Set<IDataProperty> dataProperties;
    
    public OClass(ID id) {
        super(id);
        objectProperties = new HashSet<>();
        dataProperties = new HashSet<>();
    }

    public OClass(IOntology ontology) {
        super(ontology);
    }
    
    public OClass(ID id, IOntology ontology) {
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
    public Set<IClass> getAdjacent() {
        Set<IClass> adjacents = Common.getSet(IClass.class);
        for (IObjectProperty property : objectProperties) {
            adjacents.addAll(property.getRange());
        }
        
        return adjacents;
    }
    
}
