package e2e;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * To run cucumber test.
 */
@RunWith(Cucumber.class)

@CucumberOptions(features = "classpath:features", plugin = { "pretty", "html:target/cucumber" })
public class CucumberTest {

}