/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IItem;
import eg.edu.alexu.ontology.IOntology;
import java.net.URI;

/**
 *
 * @author sameh
 */
public abstract class Item extends OntologyElement implements IItem {
    
    private IOntology ontology;

    public Item(URI id) {
        super(id);
    }
    
    public Item(URI id, IOntology ontology) {
        super(id);
        this.ontology = ontology;
    }

    @Override
    public IOntology getOntology() {
        return ontology;
    }
    
}
