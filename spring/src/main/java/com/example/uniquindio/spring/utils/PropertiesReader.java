package com.example.uniquindio.spring.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for reading properties from a .properties file.
 */
public class PropertiesReader {

    private Properties properties = new Properties(); // Holds the properties loaded from the file

    // Constructor that receives the path of the .properties file
    public PropertiesReader(String filePath) {
        // Load the properties from the specified location
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + filePath);
                return;
            }
            properties.load(input); // Load properties from the input stream
        } catch (IOException ex) {
            ex.printStackTrace(); // Print the stack trace in case of an error
        }
    }

    /**
     * Method to get a specific property by key.
     *
     * @param key the key of the property to retrieve
     * @return the value of the specified property, or null if not found
     */
    public String getProperty(String key) {
        return properties.getProperty(key); // Return the property value for the given key
    }

    /**
     * Method to get all properties.
     *
     * @return the Properties object containing all key-value pairs
     */
    public Properties getAllProperties() {
        return properties; // Return all properties
    }
}
