/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.exception;

/**
 *
 * @author sameh
 */
public class UnsupportedTypeException extends Exception {
    
    public <T> UnsupportedTypeException(T obj) {
        super("Unsupported Type: " + obj.getClass().getName());
    }
}
