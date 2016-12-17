/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.util.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author sameh
 */
public class BufferedFileReader extends BufferedReader implements
        BufferedFileIO {
    
    private final String filename;

    public BufferedFileReader(String filename) throws FileNotFoundException {
        super(getReader(filename));
        this.filename = filename;
    }
    
    private static Reader getReader(String filename)
            throws FileNotFoundException {
        return new FileReader(filename);
    }

    @Override
    public String getFileName() {
        return filename;
    }
}
