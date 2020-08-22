package bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/qlo-create-new-account.feature",
        plugin = {"pretty", "html:target/cucumber"}
)
public class QloAccountCreateTest {

}