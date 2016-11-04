/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology;

import java.util.Set;

/**
 *
 * @author sameh
 */
public interface IOntology extends IOntologyElement {
    String getNamespace();
    Set<IConcept> getConcepts();
    Set<IProperty> getProperties();
    Set<IObjectProperty> getObjectProperties();
    Set<IDataProperty> getDataProperties();
    Set<IIndividual> getIndividuals();
    Set<ILiteral> getLiterals();
    Set<IRelation> getRelations();
    Set<IAttribute> getAttributes();
}
