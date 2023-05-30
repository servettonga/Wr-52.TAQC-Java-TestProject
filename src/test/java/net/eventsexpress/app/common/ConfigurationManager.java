package net.eventsexpress.app.common;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigurationManager {
    protected static Configuration config;

    public static Configuration getConfig() {
        if (config == null) {
            try {
                URL resource = ConfigurationManager.class.getClassLoader().getResource("app.properties");
                config = new Configurations().properties(resource);
            } catch (ConfigurationException cex) {
                System.out.println("Test configuration file not found");
                System.exit(1);
            }
        }

        return config;
    }
}
