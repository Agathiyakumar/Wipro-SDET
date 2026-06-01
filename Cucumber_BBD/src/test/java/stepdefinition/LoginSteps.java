package stepdefinition;



import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import Hooks.Hooks;
import io.cucumber.java.en.*;

public class LoginSteps {

    WebDriver driver;
    
    Hooks hk =new Hooks();
    
    
    @Given("user opens browser and navigates to website")
    public void openBrowser() {
    	
    	hk.setup();
    }

    @When("user clicks on My Account")
    public void clickMyAccount() {
    	
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        
    }

    @When("user clicks on Login option")
    public void clickLoginOption() {
        driver.findElement(By.linkText("Login")).click();
    }

    @When("user enters email")
    public void enterEmail(String email) {
        driver.findElement(By.id("input-email")).sendKeys("smithran.v.eee.2021@snsct.org");
    }

    @When("user enters password")
    public void enterPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys("Sowmithran@24");
    }

    @When("user clicks on Login button")
    public void clickLogin() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        System.out.println("User Login Successful");
    }

    @When("user navigates to Mac products")
    public void navigateToMac() {
    	
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        Actions a = new Actions(driver);
        
        a.moveToElement(desktops).perform();
        
        driver.findElement(By.linkText("Mac (1)")).click();
        
        System.out.println("User navigates to products successfully");
    }

    @Then("user adds product to wishlist")
    public void addWishlist() {
    	
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        
        System.out.println("Product successfully added to wishlist");
    }

    @Then("user adds product to cart")
    public void addCart() {
    	
        driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]")).click();
        
        System.out.println("Product successfully added to cart");
    }

    @Then("user opens product and prints details")
    public void printDetails() {
    	
        driver.findElement(By.linkText("iMac")).click();

        String name = driver.findElement(By.tagName("h1")).getText();
        String price = driver.findElement(By.tagName("h2")).getText();

        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
        
        System.out.println("Product details displayed successfully");

    }

    @Then("user fills contact us form")
    public void contactForm() {
    	
        driver.findElement(By.linkText("Contact Us")).click();

        driver.findElement(By.id("input-name")).sendKeys("Sowmith");
        driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("input-enquiry")).sendKeys("Price enquiry");

        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        
        System.out.println("Contact us form working successfully");
    }

    @Then("user closes browser")
    public void closeBrowser() {
    	hk.closestmt();;
    }
}