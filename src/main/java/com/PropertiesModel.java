package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesModel implements PropertiesMBean {

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
    public void setUrl(String url) {

        Properties properties = new Properties();

        try (InputStream resourceAsStream = ImageLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(resourceAsStream);
            properties.setProperty("url", url);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void setPath(String path) {

        Properties properties = new Properties();

        try (InputStream resourceAsStream = ImageLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(resourceAsStream);
            properties.setProperty("path", path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
