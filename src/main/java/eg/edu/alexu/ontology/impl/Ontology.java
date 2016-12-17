/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IAttribute;
import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IDataProperty;
import eg.edu.alexu.ontology.IDatatype;
import eg.edu.alexu.ontology.IIndividual;
import eg.edu.alexu.ontology.ILiteral;
import eg.edu.alexu.ontology.IObjectProperty;
import eg.edu.alexu.ontology.IOntology;
import eg.edu.alexu.ontology.IProperty;
import eg.edu.alexu.ontology.IRelation;
import eg.edu.alexu.ontology.common.ID;
import java.io.File;
import java.net.URI;
import java.util.Collections;
import java.util.Set;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * @author sameh
 */
public class Ontology extends OntologyElement implements IOntology {
    
    protected URI namespace;
    protected Set<IClass> classes;
    protected Set<IObjectProperty> objectProperties;
    protected Set<IDataProperty> dataProperties;
    protected Set<IDatatype> datatypes;
    protected Set<IIndividual> individuals;
    protected Set<ILiteral> literals;
    
    public Ontology(ID id) {
        super(id);
        namespace = null;
        classes = Common.getSet(IClass.class);
        objectProperties = Common.getSet(IObjectProperty.class);
        dataProperties = Common.getSet(IDataProperty.class);
        datatypes = Common.getSet(IDatatype.class);
        individuals = Common.getSet(IIndividual.class);
        literals = Common.getSet(ILiteral.class);
    }
    
    public Ontology(ID id, String filename)
            throws OWLOntologyCreationException {
        this(id);
        OWLOntology ontology = getOntologyFromFile(filename);
        AddToOntologyVisitor visitor = new AddToOntologyVisitor(this);
        ontology.accept(visitor);
    }
    
    private OWLOntology getOntologyFromFile(String filename)
            throws OWLOntologyCreationException {
        File file = new File(filename);
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = null;
        ontology = manager.loadOntologyFromOntologyDocument(file);
        
        return ontology;
    }
    
//    private void buildFromFile(String filename) {
//        File file = new File(filename);
//        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//        OWLOntology ontology = null;
//        try {
//            ontology = manager.loadOntologyFromOntologyDocument(file);
//            
//            
//        } catch (OWLOntologyCreationException ex) {
//            Logger.getLogger(Ontology.class.getName()).log(Level.SEVERE, null,
//                    ex);
//        }
//        
//        AddToOntologyVisitor addVisitor = new AddToOntologyVisitor(this);
//        ontology.accept(addVisitor);
//        for (OWLClass clss : ontology.getClassesInSignature()) {
//            clss.accept(addVisitor);
//        }
//        
//        for (OWLObjectProperty property :
//                ontology.getObjectPropertiesInSignature()) {
//            property.accept(addVisitor);
//        }
//        
//        for (OWLDataProperty property :
//                ontology.getDataPropertiesInSignature()) {
//            property.accept(addVisitor);
//        }
//    }
    
    public Ontology(ID id, IOntology ontology) {
        this(id);
        // Continue...
    }

    @Override
    public URI getNamespace() {
        return namespace;
    }

    @Override
    public Set<IClass> getClasses() {
        return Collections.unmodifiableSet(classes);
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

    @Override
    public Set<IDatatype> getDatatypes() {
        return Collections.unmodifiableSet(datatypes);
    }
    
}
