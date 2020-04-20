package com.sailfish.learnspring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sailfish
 * @create 2020-04-20-11:11 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private Integer age;
}
