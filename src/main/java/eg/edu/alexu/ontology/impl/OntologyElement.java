/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IOntologyElement;
import eg.edu.alexu.ontology.common.ID;

/**
 *
 * @author sameh
 */
public abstract class OntologyElement implements IOntologyElement {
    
    protected ID id;
    
    public OntologyElement(ID id) {
        this.id = id;
    }

    @Override
    public ID getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OntologyElement) {
            return id.equals(((OntologyElement)obj).id);
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "<" + id + ">";
    }
}
