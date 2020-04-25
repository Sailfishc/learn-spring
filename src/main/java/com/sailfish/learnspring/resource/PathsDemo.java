package com.sailfish.learnspring.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sailfish
 * @create 2020-04-25-7:29 下午
 */
public class PathsDemo {


    public static void main(String[] args) {
        System.out.println(Paths.get(".").toAbsolutePath());
        Path path = Paths.get("src/main/resources/META-INF/config/container-config.xml");
        System.out.println(Files.exists(path));
        try {
            Files.newBufferedReader(path).lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
