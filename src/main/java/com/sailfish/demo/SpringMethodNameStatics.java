package com.sailfish.demo;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sailfish
 * @create 2020-05-05-3:36 下午
 */
@Slf4j
public class SpringMethodNameStatics {

    static Map<String, Integer> methodNameMap = new HashMap<>();
    static List<String> classNameList = new ArrayList<>();
    static List<String> blackMethod = new ArrayList<>();

    static {
        blackMethod.add("is");
        blackMethod.add("set");
        blackMethod.add("get");
        blackMethod.add("to");
        blackMethod.add("hash");
        blackMethod.add("equals");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        InputStream is = SpringMethodNameStatics.class.getResourceAsStream("spring-context-5.2.5.RELEASE.jar");
        String packName = "org.springframework.context";
//        getClassByAnnotation(packName, null, null, false);

        String springJarName = "jar:file:/Users/sailfish/.m2/repository/org/springframework/spring-context/5.2.5.RELEASE/spring-context-5.2.5.RELEASE-sources.jar!/org/springframework";
        URL url = new URL(springJarName);
        JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            getJavaClassInfo(jarEntry);
        }
        classNameList.forEach((a) -> System.out.println(a));
        methodNameMap.keySet().forEach(a -> System.out.println(a));
    }

    private static void getJavaClassInfo(JarEntry jarEntry) {
        if (jarEntry.isDirectory()) {
            return;
        }
        String name = jarEntry.getName();
        if (!name.endsWith(".java")) {
            return;
        }
        int idx = name.lastIndexOf("/");
        String packagePath = name.substring(0, idx + 1);
        String className = name.substring(idx + 1, name.length() - 5);
        String packageName = packagePath.replace("/", ".");
//        System.out.println(packageName + className);
        classNameList.add(packageName + className);

        final String fullClassName = packageName + className;
        if ("org.springframework.context.support.GenericGroovyApplicationContext".equals(fullClassName)) {
            return;
        }
        try {
            Class<?> clazz = Class.forName(fullClassName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();

                String firstLowerName = methodName.substring(0, getFirstUpperIndex(methodName));
//                System.out.println(firstLowerName);
                if (blackMethod.contains(firstLowerName)) {
                    continue;
                }
                methodNameMap.put(methodName, methodNameMap.getOrDefault(methodName, 0) + 1);
            }
        } catch (Throwable e) {

        }

    }

    private static int getFirstUpperIndex(String methodName) {
        int index = methodName.length();
        for (int i = 0; i < methodName.length(); i++) {
            char c = methodName.charAt(i);
            if (Character.isUpperCase(c)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void getClassByAnnotation(String packageName, Class<?> parent, Class<? extends Annotation> annotation, boolean recursive) {
        // Get the name of the package and replace it
        String packageDirName = packageName.replace('.', '/');
        // Defines an enumerated collection and loops to process the URL in this directory
        Enumeration<URL> dirs;
        try {
            dirs = SpringMethodNameStatics.class.getClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                // Next
                URL url = dirs.nextElement();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
