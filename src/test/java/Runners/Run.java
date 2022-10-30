package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/todoItem.feature",
        glue = {"StepDefinitions"}
)
public class Run extends AbstractTestNGCucumberTests  {
}
