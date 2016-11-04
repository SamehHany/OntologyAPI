/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IAttribute;
import eg.edu.alexu.ontology.IConcept;
import eg.edu.alexu.ontology.IIndividual;
import eg.edu.alexu.ontology.IRelation;
import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class Individual extends Item implements IIndividual {
    
    private Set<IConcept> types;
    private Set<IAttribute> attributes;
    private Set<IRelation> relations;

    public Individual(URI id) {
        super(id);
    }

    @Override
    public Set<IConcept> getType() {
        return Collections.unmodifiableSet(types);
    }

    @Override
    public Set<IRelation> getRelations() {
        return Collections.unmodifiableSet(relations);
    }

    @Override
    public Set<IAttribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    @Override
    public Set<IIndividual> getAdjacent() {
        Set<IIndividual> adjacents = Common.getSet(IIndividual.class);
        for (IRelation relation : relations) {
            adjacents.add(relation.getObject());
        }
        
        return adjacents;
    }
    
}
