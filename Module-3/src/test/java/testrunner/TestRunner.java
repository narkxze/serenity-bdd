package testrunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( glue="stepdefs",
        plugin = "pretty",
        features = "src/test/resources/features",
        tags="@m3")
public class TestRunner {
}
