package Hooks;


import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Hooks {
  
public static WebDriver driver;
	 
	 
	 
  

  @BeforeTest
  public void setup() {
	 
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
      driver.get("https://tutorialsninja.com/demo/");
  }

  @AfterTest
  public void closestmt() {
	  driver.quit();
  }

}
