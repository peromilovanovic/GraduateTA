package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Test1 {
	private static WebDriver driver;
	private String URL;
	
  @Test
  public void TestGoogle() 
  {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  Sleeper.sleepTightInSeconds(10);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  URL="https://www.google.com";
  }

  @AfterClass
  public void tearDown() 
  {
	  driver.close();
  }

}
