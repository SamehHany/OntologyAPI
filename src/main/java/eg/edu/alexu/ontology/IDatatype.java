/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology;

/**
 *
 * @author sameh
 * @param <T>
 */
public interface IDatatype<T> extends IEntity {
    Class<T> getType();
}
