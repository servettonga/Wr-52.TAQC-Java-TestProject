package net.eventsexpress.app.config;

import java.net.URL;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;


public class ConfigurationManager {
    protected static Configuration config;

    public static Configuration getConfig() {
        if (config == null) {
            try {
                URL resource = ConfigurationManager.class.getClassLoader().getResource("test.properties");
                config = new Configurations().properties(resource);
            } catch (ConfigurationException e) {
                System.out.println("Configuration file not found");
                System.exit(1);
            }
        }
        return config;
    }

}
