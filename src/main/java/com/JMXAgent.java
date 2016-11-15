package com;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class JMXAgent extends Thread {

    @Override
    public void run() {

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        PropertiesModel propertiesModel = new PropertiesModel();

        try {
            StandardMBean standardMBean = new StandardMBean(propertiesModel, PropertiesModel.class);
            ObjectName objectName = new ObjectName("load_image_jmx:name=first-mbean");

            platformMBeanServer.registerMBean(standardMBean, objectName);

            System.out.println("Please press Enter to stop ...");
            System.in.read();

        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }
}
