package com;

import org.apache.commons.configuration.ConfigurationException;
import javax.imageio.ImageIO;
import javax.management.NotCompliantMBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.StandardMBean;
import javax.management.ObjectName;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.Properties;

public class ImageLoader {
    public static void main(String[] args) throws IOException, ConfigurationException, NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException {

        String fileName = "image.png";

        Properties properties = new Properties();
        InputStream resourceAsStream = ImageLoader.class.getClassLoader().getResourceAsStream("config.properties");
        properties.load(resourceAsStream);

        String url = properties.getProperty("url");
        String path = properties.getProperty("path");

        BufferedImage img = ImageIO.read(new URL(url));

        File file = new File(path + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ImageIO.write(img, "png", file);

        jmxAgentStart();
    }

    public static void jmxAgentStart() throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        PropertiesModelMBean propertiesModelMBean = new PropertiesModel();

        StandardMBean standardMBean = new StandardMBean(propertiesModelMBean, PropertiesModelMBean.class);
        ObjectName objectName = new ObjectName("load_image_jmx:name=first-mbean");

        platformMBeanServer.registerMBean(standardMBean, objectName);

        System.out.println("Please press Enter to stop ...");
        System.in.read();
    }
}
