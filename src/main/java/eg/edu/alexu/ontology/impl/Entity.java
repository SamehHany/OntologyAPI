/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IEntity;
import eg.edu.alexu.ontology.IOntology;
import java.net.URI;

/**
 *
 * @author sameh
 */
public abstract class Entity extends OntologyElement implements IEntity {
    
    private final IOntology ontology;
    
    public Entity(URI id, IOntology ontology) {
        super(id);
        this.ontology = ontology;
    }

    @Override
    public IOntology getOntology() {
        return ontology;
    }
    
}
