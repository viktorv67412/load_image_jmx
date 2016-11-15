package com;

import org.apache.commons.configuration.ConfigurationException;

public interface PropertiesModelMBean {

    String getUrl();

    void setUrl(String url) throws ConfigurationException;

    String getPath();

    void setPath(String path) throws ConfigurationException;
}
