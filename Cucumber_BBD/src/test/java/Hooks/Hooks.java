package Hooks;


import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Hooks {
  
	 WebDriver driver;
	 
	 
	 Hooks(WebDriver driver)
	 {
		 this.driver=driver;
	 }
  

  @BeforeTest
  public void beforeTest() {
	 
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
      driver.get("https://tutorialsninja.com/demo/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
