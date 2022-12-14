package com.todolist.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
        },
        features = "src/test/resources/features",
        glue = "com/todolist/step_definitions",
        tags = "@US01",
        dryRun = false,
        publish = true

)
public class CukesRunner {

}
