package utils;

import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ViTaLES on 06.02.2016.
 */
public class PropertyLoader {

    private static final String PROPERTY_FILE = "/application.properties";

    public static String loadProperty(String name)
    {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            Assert.fail("Incorrect property name - " + name);
        }
        String value = "";
        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }


}
