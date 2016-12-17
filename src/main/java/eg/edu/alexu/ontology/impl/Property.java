/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IEntity;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import eg.edu.alexu.ontology.common.ID;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
public abstract class Property extends OntologyElement implements IProperty {
    protected IOntology ontology;
    protected Set<IClass> domains;
    protected Set<? extends IEntity> ranges;
    
    public Property(ID id) {
        super(id);
        domains = new HashSet<>();
        this.ranges = new HashSet<IEntity>();
    }
    
    public Property(ID id, IOntology ontology) {
        super(id);
        this.ontology = ontology;
        domains = Common.getSet(IClass.class);
    }

    public Property(ID id, IOntology ontology, IEntity range) {
        this(id, ontology);
        ((Set<IEntity>)this.ranges).add(range);
    }
    
    public void addDomain(IClass clss) {
        domains.add(clss);
    }

    @Override
    public Set<IClass> getDomain() {
        return Collections.unmodifiableSet(domains);
    }

    @Override
    public Set<? extends IEntity> getRange() {
        return ranges;
    }

    @Override
    public IOntology getOntology() {
        return ontology;
    }
    
}
