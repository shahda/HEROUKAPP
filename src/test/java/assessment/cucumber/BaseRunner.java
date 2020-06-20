package assessment.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions

        (features = "src/test/resources/Features", // Folder location of 'feature' files (relative to project root)
                glue = {"assessment.steps", // Folder location containing 'steps' files (relative to project java root)
                        "assessment.cucumber"
                },
                plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},


                snippets = SnippetType.CAMELCASE, // Specify camelCase for generated method names.


                monochrome = true // Simpler display output (no control codes to confuse windows).
                //tags = {"~@ignore"}) // Which tags to run
        )
public class BaseRunner {
}

