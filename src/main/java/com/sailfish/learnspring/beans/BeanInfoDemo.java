package com.sailfish.learnspring.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author sailfish
 * @create 2020-04-20-11:13 PM
 */
public class BeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);

            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String name = propertyDescriptor.getName();
            if ("age".equalsIgnoreCase(name)) {
                propertyDescriptor.setPropertyEditorClass(StringToInteger.class);
                Person sailfish = new Person("sailfish", 18);
                propertyDescriptor.createPropertyEditor(sailfish);
                System.out.println(sailfish);
            }
        });
    }

    static class StringToInteger extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }
}
