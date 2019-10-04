package me.bristermitten.demoplumberapp;

import me.bristermitten.plumber.data.ConfigVar;
import me.bristermitten.plumber.data.Configuration;

@Configuration(fileName = "test.yml")
public class TestConfig {

    @ConfigVar("name")
    private String name = "Hello";
}
