/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IDatatype;
import eg.edu.alexu.ontology.IOntology;
import java.net.URI;

/**
 *
 * @author sameh
 */
public class DataProperty extends Property {

    public DataProperty(URI id, IOntology ontology, IDatatype range) {
        super(id, ontology, range);
    }
    
    @Override
    public IDatatype getRange() {
        return (IDatatype)super.getRange();
    }
}
