/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IKnowledge;
import eg.edu.alexu.ontology.IOntology;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class Knowledge implements IKnowledge {
    
    private Set<IOntology> ontologies;
    
    public Knowledge() {
        ontologies = Common.getSet(IOntology.class);
    }
    
    public Knowledge(Collection<? extends IOntology> ontologies) {
        this();
        this.ontologies.addAll(ontologies);
    }

    @Override
    public Set<IOntology> getOntologies() {
        return Collections.unmodifiableSet(ontologies);
    }

    @Override
    public void addOntology(IOntology ontology) {
        ontologies.add(ontology);
    }
    
}
