/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IOntologyElement;
import java.net.URI;

/**
 *
 * @author sameh
 */
public abstract class OntologyElement implements IOntologyElement {
    
    private URI id;
    
    public OntologyElement(URI id) {
        this.id = id;
    }

    @Override
    public URI getId() {
        return id;
    }
    
}
