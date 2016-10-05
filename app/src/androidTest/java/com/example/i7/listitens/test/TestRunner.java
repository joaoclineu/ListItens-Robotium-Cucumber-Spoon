package com.example.i7.listitens.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by i7 on 23/09/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        plugin = {"html:/mnt/sdcard/cucumber",
        "junit:/mnt/sdcard/cucumber/JUnitReport.xml",
        "json:/mnt/sdcard/cucumber/JSONReport.json"},
        glue = "com.example.i7.listitens.test",
        tags = {"@TDC"}
)
public class TestRunner {
}
