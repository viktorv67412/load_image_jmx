package com;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ImageLoader {
    public static void main(String[] args) throws IOException {

        JMXAgent jmxAgent = new JMXAgent();
        jmxAgent.start();

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
    }
}
