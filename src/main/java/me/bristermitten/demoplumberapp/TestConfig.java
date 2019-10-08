package me.bristermitten.demoplumberapp;

import me.bristermitten.plumber.files.ConfigVar;
import me.bristermitten.plumber.files.Configuration;

@Configuration(fileName = "test.yml")
public class TestConfig {

    @ConfigVar("name")
    private String name = "Hello";
}
