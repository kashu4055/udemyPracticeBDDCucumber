package stepDefenition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/vadimgeroim/Downloads/chromedriver");
	    driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
