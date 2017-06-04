package com.sun;

import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lebron374 on 2017/6/4.
 */
public class SelfServiceLoader {
    public static final String MAPPING_CONFIG_PREFIX = "META-INF/services";

    public static <S> List<S> load(Class<S> service) throws Exception {
        String mappingConfigFile = MAPPING_CONFIG_PREFIX + "/" + service.getName();
        Enumeration<URL> configFileUrls = SelfServiceLoader.class.getClassLoader().getResources(mappingConfigFile);

        if (null == configFileUrls) {
            return null;
        }

        List<S> services = new LinkedList<S>();
        while(configFileUrls.hasMoreElements()) {
            URL configFileUrl = configFileUrls.nextElement();
            String configContent = IOUtils.toString(configFileUrl.openStream(), "utf-8");
            String[] serviceNames = configContent.split("\r\n");
            for (String serviceName : serviceNames) {
                Class serviceClass = SelfServiceLoader.class.getClassLoader().loadClass(serviceName);
                Object serviceInstance = serviceClass.newInstance();
                services.add((S)serviceInstance);
            }
        }

        return services;
    }
}
