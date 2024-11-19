// This class includes helper utilitites used throughout the program

package com.satisfactorycalculator.utils;

// Package imports
import java.io.InputStream;
import java.net.URL;

public class HelperUtils {
    // This method returns the open file of a 
    public static InputStream open(String fileName) throws IllegalArgumentException {
        // The class loader returns a URL, therefore a URL object is required here
        URL resource = HelperUtils.class.getClassLoader().getResource(fileName);
        
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        // If the file is found, return the stream
        return HelperUtils.class.getClassLoader().getResourceAsStream(fileName);
    }
}
