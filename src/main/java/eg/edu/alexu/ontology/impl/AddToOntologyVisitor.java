/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.impl;

import eg.edu.alexu.ontology.IClass;
import eg.edu.alexu.ontology.IDatatype;
import eg.edu.alexu.ontology.common.ID;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyRange;
import org.semanticweb.owlapi.model.OWLPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLDataRangeAtom;
import org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLSameIndividualAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

/**
 *
 * @author sameh
 */
public class AddToOntologyVisitor implements OWLObjectVisitor {

    private final Ontology ontology;

    public AddToOntologyVisitor(Ontology ontology) {
        this.ontology = (Ontology) ontology;
    }

    @Override
    public void visit(OWLOntology owlo) {
        ontology.id = new ID(owlo.getOntologyID().getOntologyIRI().get()
                .toURI());
        for (OWLClass clss : owlo.getClassesInSignature()) {
            visit(clss);
        }

        for (OWLObjectProperty property
                : owlo.getObjectPropertiesInSignature()) {
            visit(property);
        }

        for (OWLDataProperty property
                : owlo.getDataPropertiesInSignature()) {
            visit(property);
        }

//        for (OWLObjectPropertyDomainAxiom axiom
//                : owlo.getAxioms(AxiomType.OBJECT_PROPERTY_DOMAIN)) {
//            OWLObjectPropertyExpression propExp = axiom.getProperty();
//            OWLClassExpression owlclassExp = axiom.getDomain();
//
//            for (OWLObjectProperty prop
//                    : propExp.getObjectPropertiesInSignature()) {
//                URI propUri = prop.getIRI().toURI();
//                ID propId = new ID(propUri);
//
//                ObjectProperty property = Memory.get(propId, ObjectProperty.class);
//
//                for (OWLClass owlclass : owlclassExp.getClassesInSignature()) {
//                    URI classUri = owlclass.getIRI().toURI();
//                    ID classId = new ID(classUri);
//                    OClass clss = Memory.get(classId, OClass.class);
//
//                    property.domains.add(clss);
//                    clss.objectProperties.add(property);
//                }
//            }
//        }
        
        getDomains(owlo.getAxioms(AxiomType.OBJECT_PROPERTY_DOMAIN),
                OWLObjectPropertyDomainAxiom.class,
                OWLObjectPropertyExpression.class,
                OWLObjectProperty.class);
        getDomains(owlo.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN),
                OWLDataPropertyDomainAxiom.class,
                OWLDataPropertyExpression.class,
                OWLDataProperty.class);
        
        getRanges(owlo.getAxioms(AxiomType.OBJECT_PROPERTY_RANGE),
                OWLObjectPropertyRangeAxiom.class,
                OWLObjectPropertyExpression.class,
                OWLObjectProperty.class);
        getRanges(owlo.getAxioms(AxiomType.OBJECT_PROPERTY_RANGE),
                OWLObjectPropertyRangeAxiom.class,
                OWLDataPropertyExpression.class,
                OWLDataProperty.class);
    }
    
    private <T extends OWLPropertyDomainAxiom,
            U extends OWLPropertyExpression,
            V extends OWLProperty>
    void getDomains(Collection<T> axioms,
            Class<T> axiomClass,
            Class<U> expClass,
            Class<V> propClass) {
        if (propClass.equals(OWLObjectProperty.class)) {
            getDomains(axioms, axiomClass, expClass, propClass,
                    ObjectProperty.class);
        } else if (propClass.equals(OWLDataProperty.class)) {
            getDomains(axioms, axiomClass, expClass, propClass,
                    DataProperty.class);
        }
    }

    private <T extends OWLPropertyDomainAxiom,
                U extends OWLPropertyExpression,
                V extends OWLProperty,
                W extends Property>
        void getDomains(Collection<T> axioms,
                Class<T> axiomClass,
                Class<U> expClass,
                Class<V> propClass,
                Class<W> localPropClass) {
        for (T axiom : axioms) {
            U propExp = (U)axiom.getProperty();
            OWLClassExpression owlclassExp = axiom.getDomain();
            
            List<V> props = new ArrayList<>();
            boolean object = false;
            boolean data = false;
            if (propExp instanceof OWLObjectPropertyExpression) {
                object = true;
                Set<OWLObjectProperty> tmpList = ((OWLObjectPropertyExpression)
                        propExp).getObjectPropertiesInSignature();
                for (OWLObjectProperty p : tmpList) {
                    props.add((V)p);
                }
            } else if (propExp instanceof OWLDataPropertyExpression) {
                data = true;
                Set<OWLDataProperty> tmpList = ((OWLDataPropertyExpression)
                        propExp).getDataPropertiesInSignature();
                for (OWLDataProperty p : tmpList) {
                    props.add((V)p);
                }
            }
            for (V prop : props) {
                URI propUri = prop.getIRI().toURI();
                ID propId = new ID(propUri);

                W property = Memory.get(propId, localPropClass);

                for (OWLClass owlclass : owlclassExp.getClassesInSignature()) {
                    visit(owlclass);
                    URI classUri = owlclass.getIRI().toURI();
                    ID classId = new ID(classUri);
                    OClass clss = Memory.get(classId, OClass.class);

                    property.domains.add(clss);
                    if (object) {
                        clss.objectProperties.add((ObjectProperty)property);
                    } else if (data) {
                        clss.dataProperties.add((DataProperty)property);
                    }
                }
            }
        }
    }
    
    private <T extends OWLPropertyRangeAxiom,
            U extends OWLPropertyExpression,
            V extends OWLProperty>
    void getRanges(Collection<T> axioms,
            Class<T> axiomClass,
            Class<U> expClass,
            Class<V> propClass) {
        if (propClass.equals(OWLObjectProperty.class)) {
            getRanges(axioms, axiomClass, expClass, propClass,
                    ObjectProperty.class);
        } else if (propClass.equals(OWLDataProperty.class)) {
            getRanges(axioms, axiomClass, expClass, propClass,
                    DataProperty.class);
        }
    }
    
    private <T extends OWLPropertyRangeAxiom,
                U extends OWLPropertyExpression,
                V extends OWLProperty,
                W extends Property>
        void getRanges(Collection<T> axioms,
                Class<T> axiomClass,
                Class<U> expClass,
                Class<V> propClass,
                Class<W> localPropClass) {
        for (T axiom : axioms) {
            U propExp = (U)axiom.getProperty();
            OWLPropertyRange propRange = axiom.getRange();
            
            List<V> props = new ArrayList<>();
            boolean object = false;
            boolean data = false;
            if (propExp instanceof OWLObjectPropertyExpression) {
                object = true;
                Set<OWLObjectProperty> tmpList = ((OWLObjectPropertyExpression)
                        propExp).getObjectPropertiesInSignature();
                for (OWLObjectProperty p : tmpList) {
                    props.add((V)p);
                }
            } else if (propExp instanceof OWLDataPropertyExpression) {
                data = true;
                Set<OWLDataProperty> tmpList = ((OWLDataPropertyExpression)
                        propExp).getDataPropertiesInSignature();
                for (OWLDataProperty p : tmpList) {
                    props.add((V)p);
                }
            }
            for (V prop : props) {
                URI propUri = prop.getIRI().toURI();
                ID propId = new ID(propUri);

                W property = Memory.get(propId, localPropClass);

                if (object) {
                    for (OWLClass owlclass : propRange.getClassesInSignature()) {
                        visit(owlclass);
                        URI classUri = owlclass.getIRI().toURI();
                        ID classId = new ID(classUri);
                        OClass clss = Memory.get(classId, OClass.class);

                        ((Set<IClass>) property.ranges).add(clss);
                    }
                } else if (data) {
                    for (OWLDatatype owltype : propRange.getDatatypesInSignature()) {
                        visit(owltype);
                        URI typeUri = owltype.getIRI().toURI();
                        ID typeId = new ID(typeUri);
                        Datatype type = Memory.get(typeId, Datatype.class);

                        ((Set<IDatatype>) property.ranges).add(type);
                    }
                }
            }
        }
    }

    @Override
    public void visit(OWLClass owlc) {
        OClass clss = Memory.get(owlc.getIRI().toURI(), OClass.class);
        if (ontology.classes.contains(clss)) {
            return;
        }

        AddToClassVisitor v = new AddToClassVisitor(clss);
        owlc.accept(v);

        ontology.classes.add(clss);
    }

    @Override
    public void visit(OWLObjectProperty owlop) {
        ObjectProperty property = Memory.get(owlop.getIRI().toURI(),
                ObjectProperty.class);
        if (ontology.objectProperties.contains(property)) {
            return;
        }
        AddToObjectPropertyVisitor v = new AddToObjectPropertyVisitor(property);
        owlop.accept(v);

        ontology.objectProperties.add(property);
    }

    @Override
    public void visit(OWLDataProperty owldp) {
        DataProperty property = Memory.get(owldp.getIRI().toURI(),
                DataProperty.class);
        if (ontology.dataProperties.contains(property)) {
            return;
        }
        AddToDataPropertyVisitor v = new AddToDataPropertyVisitor(property);
        owldp.accept(v);

        ontology.dataProperties.add(property);
    }
    
    @Override
    public void visit(OWLDatatype owld) {
        Datatype type = Memory.get(owld.getIRI().toURI(), Datatype.class);
        if (ontology.classes.contains(type)) {
            return;
        }

        AddToDatatypeVisitor v = new AddToDatatypeVisitor(type);
        owld.accept(v);

        ontology.datatypes.add(type);
    }

    @Override
    public void visit(OWLObjectInverseOf owloio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDeclarationAxiom owlda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDatatypeDefinitionAxiom owldda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnnotationAssertionAxiom owlaaa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSubAnnotationPropertyOfAxiom owlsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnnotationPropertyDomainAxiom owlpd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnnotationPropertyRangeAxiom owlpr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSubClassOfAxiom owlsc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLNegativeObjectPropertyAssertionAxiom owlnp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAsymmetricObjectPropertyAxiom owlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLReflexiveObjectPropertyAxiom owlrp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDisjointClassesAxiom owldca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataPropertyDomainAxiom owldpd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectPropertyDomainAxiom owlpd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLEquivalentObjectPropertiesAxiom owlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom owlndp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDifferentIndividualsAxiom owldia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDisjointDataPropertiesAxiom owldp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDisjointObjectPropertiesAxiom owldp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectPropertyRangeAxiom owlpr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectPropertyAssertionAxiom owlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLFunctionalObjectPropertyAxiom owlfp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSubObjectPropertyOfAxiom owlsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDisjointUnionAxiom owldua) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSymmetricObjectPropertyAxiom owlsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataPropertyRangeAxiom owldpr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLFunctionalDataPropertyAxiom owlfdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLEquivalentDataPropertiesAxiom owldp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLClassAssertionAxiom owlcaa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom owleca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataPropertyAssertionAxiom owldp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLTransitiveObjectPropertyAxiom owltp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLIrreflexiveObjectPropertyAxiom owlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSubDataPropertyOfAxiom owlsdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLInverseFunctionalObjectPropertyAxiom owlfp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSameIndividualAxiom owlsia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLSubPropertyChainOfAxiom owlspc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLInverseObjectPropertiesAxiom owlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLHasKeyAxiom owlhka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLRule swrlr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectIntersectionOf owloio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectUnionOf owlouo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectComplementOf owloco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom owlsvf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectAllValuesFrom owlvf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectHasValue owlohv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectMinCardinality owlomc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectExactCardinality owloec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectMaxCardinality owlomc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectHasSelf owlohs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLObjectOneOf owlooo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataSomeValuesFrom o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataAllValuesFrom owldvf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataHasValue owldhv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataMinCardinality owldmc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataExactCardinality owldec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataMaxCardinality owldmc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLLiteral owll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLFacetRestriction owlfr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataOneOf owldoo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataComplementOf owldco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataIntersectionOf owldio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDataUnionOf owlduo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLDatatypeRestriction owldr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnnotationProperty owlap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLNamedIndividual owlni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnonymousIndividual owlai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(IRI iri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(OWLAnnotation owla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLClassAtom swrlca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLDataRangeAtom swrldr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLObjectPropertyAtom swrlp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLDataPropertyAtom swrldp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLBuiltInAtom swrlb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLVariable swrlv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLIndividualArgument swrlia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLLiteralArgument swrlla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLSameIndividualAtom swrls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SWRLDifferentIndividualsAtom swrld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
