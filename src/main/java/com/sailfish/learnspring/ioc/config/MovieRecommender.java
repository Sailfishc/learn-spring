package com.sailfish.learnspring.ioc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

/**
 * @author sailfish
 * @create 2020-04-25-10:39 上午
 */
@Component
@ToString
public class MovieRecommender {

    private final String catalog;

    public MovieRecommender(@Value("${catalog.name}") String catalog) {
        this.catalog = catalog;
    }

    public String getCatalog() {
        return catalog;
    }
}
