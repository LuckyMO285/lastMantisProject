package lastMantisProject;

/**
 * Created by luck on 23.04.17.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/reports/mainReport.json"},
        features = {"src/test/java/resources/features"},
        glue = {"lastMantisProject.stepdefs"}
)

public class Runner {

}
