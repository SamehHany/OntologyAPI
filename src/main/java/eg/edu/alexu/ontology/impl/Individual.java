/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IAttribute;
import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IIndividual;
import eg.edu.alexu.ontology.IRelation;
import eg.edu.alexu.ontology.common.ID;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class Individual extends Item implements IIndividual {
    
    private Set<IClass> types;
    private Set<IAttribute> attributes;
    private Set<IRelation> relations;

    public Individual(ID id) {
        super(id);
        types = new HashSet<>();
        attributes = new HashSet<>();
        relations = new HashSet<>();
    }

    @Override
    public Set<IClass> getType() {
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
