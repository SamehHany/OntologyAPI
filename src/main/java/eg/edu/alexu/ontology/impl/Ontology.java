/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IAttribute;
import eg.edu.alexu.ontology.IConcept;
import eg.edu.alexu.ontology.IDataProperty;
import eg.edu.alexu.ontology.IIndividual;
import eg.edu.alexu.ontology.ILiteral;
import eg.edu.alexu.ontology.IObjectProperty;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import eg.edu.alexu.ontology.IRelation;
import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author sameh
 */
public class Ontology extends OntologyElement implements IOntology {
    
    private String namespace;
    private Set<IConcept> concepts;
    private Set<IObjectProperty> objectProperties;
    private Set<IDataProperty> dataProperties;
    private Set<IIndividual> individuals;
    private Set<ILiteral> literals;
    
    private Ontology(URI id) {
        super(id);
    }
    
    public Ontology(URI id, String filename) {
        this(id);
        // Continue...
    }
    
    public Ontology(URI id, IOntology ontology) {
        this(id);
        // Continue...
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public Set<IConcept> getConcepts() {
        return Collections.unmodifiableSet(concepts);
    }

    @Override
    public Set<IProperty> getProperties() {
        Set<IProperty> properties = Common.getSet(IProperty.class);
        properties.addAll(objectProperties);
        properties.addAll(dataProperties);
        return properties;
    }

    @Override
    public Set<IObjectProperty> getObjectProperties() {
        return Collections.unmodifiableSet(objectProperties);
    }

    @Override
    public Set<IDataProperty> getDataProperties() {
        return Collections.unmodifiableSet(dataProperties);
    }

    @Override
    public Set<IIndividual> getIndividuals() {
        return Collections.unmodifiableSet(individuals);
    }

    @Override
    public Set<ILiteral> getLiterals() {
        return Collections.unmodifiableSet(literals);
    }

    @Override
    public Set<IRelation> getRelations() {
        Set<IRelation> relations = Common.getSet(IRelation.class);
        for (IIndividual ind : individuals) {
            relations.addAll(ind.getRelations());
        }
        return relations;
    }

    @Override
    public Set<IAttribute> getAttributes() {
        Set<IAttribute> attributes = Common.getSet(IAttribute.class);
        for (IIndividual ind : individuals) {
            attributes.addAll(ind.getAttributes());
        }
        return attributes;
    }

    @Override
    public IOntology getOntology() {
        return this;
    }
    
}
