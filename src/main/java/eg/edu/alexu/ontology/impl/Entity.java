/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IEntity;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.common.ID;

/**
 *
 * @author sameh
 */
public abstract class Entity extends OntologyElement implements IEntity {
    
    protected final IOntology ontology;
    
    public Entity(ID id) {
        super(id);
        ontology = null;
    }
    
    public Entity(IOntology ontology) {
        super(null);
        this.ontology = ontology;
    }
    
    public Entity(ID id, IOntology ontology) {
        super(id);
        this.ontology = ontology;
    }

    @Override
    public IOntology getOntology() {
        return ontology;
    }
    
}
