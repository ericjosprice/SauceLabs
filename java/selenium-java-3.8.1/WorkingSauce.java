import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.assertEquals;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkingSauce {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

	/**
	* Task I: Update the test code so when it runs, the test clicks the "I am a link" link.
	*
	* Task II - Comment out the code from Task I. Update the test code so when it runs, 
	* the test is able to write "Sauce" in the text box that currently says "I has no focus".
	*
	* Task III - Update the test code so when it runs, it adds an email to the email field, 
	* adds text to the comments field, and clicks the "Send" button.
	* Note that email will not actually be sent!
	*
	* Task IV - Add a capability that adds a tag to each test that is run.
        * See this page for instructions: https://wiki.saucelabs.com/display/DOCS/Test+Configuration+Options
	*/

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 7");
    caps.setCapability("browserName", "chrome");
    caps.setCapability("version", "48");
    caps.setCapability("name", "Guinea-Pig Sauce");
    
    //setting up tags for task IV
    // // unable to get the next line to compile without an error
    // String tags = Arrays.asList("Task1", "Task2", "Task3", "Task4");
    // caps.setCapability("tags", tags);


    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

  /**
  * Goes to Sauce Lab's guinea-pig page and verifies the title
  */

    driver.get("https://saucelabs.com/test/guinea-pig");
    assertEquals("I am a page title - Sauce Labs", driver.getTitle());

// Task I
    // commented next line as per Task II
    // driver.findElement(By.id("i_am_an_id")).click();

// Task II
    driver.findElement(By.id("i_am_a_textbox")).click();
    driver.findElement(By.id("i_am_a_textbox")).sendKeys("Sauce");

// Task III
    // key in email
    driver.findElement(By.id("fbemail")).sendKeys("example@fake.com");
    //key in a comment
    driver.findElement(By.id("comments")).sendKeys("Add a comment");
    //click submit
    driver.findElement(By.id("submit")).click();

// Task IV

    driver.quit();
  }
}
