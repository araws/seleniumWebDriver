package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/qlo-create-new-account.feature",
        plugin = {"pretty", "html:out"}
)
public class QloAccountCreateTest {

}