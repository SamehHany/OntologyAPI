/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IConcept;
import eg.edu.alexu.ontology.IEntity;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author sameh
 */
public abstract class Property extends OntologyElement implements IProperty {
    private IOntology ontology;
    private Set<IConcept> domains;
    private IEntity range;

    protected Property(URI id, IOntology ontology, IEntity range) {
        super(id);
        this.ontology = ontology;
        domains = Common.getSet(IConcept.class);
        this.range = range;
    }
    
    public void addDomain(IConcept concept) {
        domains.add(concept);
    }

    @Override
    public Set<IConcept> getDomain() {
        return Collections.unmodifiableSet(domains);
    }

    @Override
    public IEntity getRange() {
        return range;
    }

    @Override
    public IOntology getOntology() {
        return ontology;
    }
    
}
