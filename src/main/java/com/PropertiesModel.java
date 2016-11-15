package com;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesModel implements PropertiesModelMBean {

    @Override
    public String getUrl() {
        Properties properties = new Properties();

        try (InputStream resourceAsStream = ImageLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("url");
    }

    @Override
    public void setUrl(String url) throws ConfigurationException {
        PropertiesConfiguration propertiesConfiguration
                = new PropertiesConfiguration("/Users/viktor/Desktop/Java EE/git_repos/load_image_jmx/src/main/resources/config.properties");

        propertiesConfiguration.setProperty("url", url);
        propertiesConfiguration.save();
    }

    @Override
    public String getPath() {
        Properties properties = new Properties();

        try (InputStream resourceAsStream = ImageLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("path");
    }

    @Override
    public void setPath(String path) throws ConfigurationException {
        PropertiesConfiguration propertiesConfiguration
                = new PropertiesConfiguration("/Users/viktor/Desktop/Java EE/git_repos/load_image_jmx/src/main/resources/config.properties");

        propertiesConfiguration.setProperty("path", path);
        propertiesConfiguration.save();
    }
}
