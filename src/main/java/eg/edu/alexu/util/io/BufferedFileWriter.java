/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.util.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author sameh
 */
public class BufferedFileWriter extends BufferedWriter implements
        BufferedFileIO {
    
    private final String filename;

    public BufferedFileWriter(String filename) throws IOException {
        super(getWriter(filename));
        this.filename = filename;
    }
    
    private static Writer getWriter(String filename) throws IOException {
        return new FileWriter(filename);
    }

    @Override
    public String getFileName() {
        return filename;
    }
}
