package net.eventsexpress.app.config;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationManager {
    protected static Configurations configs = new Configurations();
    protected static Configuration config;

    public static Configuration getConfig() {
        if (config == null) {
            try {
                config = configs.properties(new File("src/test/resources/test.properties"));
            } catch (ConfigurationException e) {
                System.out.println("Configuration file not found");
                e.printStackTrace();
                System.exit(1);
            }
        }
        return config;
    }
}
