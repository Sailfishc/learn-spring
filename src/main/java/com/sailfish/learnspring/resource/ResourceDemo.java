package com.sailfish.learnspring.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author sailfish
 * @create 2020-04-25-6:21 下午
 */
public class ResourceDemo {


    public static void main(String[] args) throws IOException {

        ClassPathResource resource = new ClassPathResource("META-INF/config/container-config.xml");
        URL url = resource.getURL();  // file:/Users/sailfish/Projects/IdeaProjects/spring-learn/learn-spring/target/classes/META-INF/config/container-config.xml

    }
}
