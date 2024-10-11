package com.example.uniquindio.spring.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties = new Properties();

    // Constructor que recibe la ruta del archivo .properties
    public PropertiesReader(String filePath) {
        // Cargar las propiedades desde la ubicación específica
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Método para obtener una propiedad específica
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Método para obtener todas las propiedades
    public Properties getAllProperties() {
        return properties;
    }
}
