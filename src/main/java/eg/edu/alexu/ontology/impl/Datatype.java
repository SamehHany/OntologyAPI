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
public class Datatype<T>  extends Entity implements IDatatype<T> {
    
    private Class<T> type;
    
    private static final String DATATYPE_NAME_SEPARATOR = "#";
    
    public Datatype(Class<T> type, IOntology ontology) {
        super(URI.create(type.getName()), ontology);
        this.type = type;
    }

    @Override
    public Class<T> getType() {
        return type;
    }
}
