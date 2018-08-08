package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class mouseHoverPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.toolsqa.com");
		//driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		//To use Explicit wait methods from class 
		ExplicitWaitMethods waitMethod = new ExplicitWaitMethods(); // as TypeText is not static we have to instantiate the obj ref
		
		
		
		//WebElement eInputForm = driver.findElement(By.xpath("//*[@id='treemenu']/li/ul/li[1]/a"));
		
		// first Hover  on tutorial menu to open it
		WebElement tutorialMenu = driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]/a/span/span"));
		
		//waitMethod.WaitForElementVisibility(driver, tutorialMenu, 7);  // waits till the tutorial menu element is visible
		
		//Before moving the mouse, action obj-ref has to be created
		Actions action = new Actions(driver);
        //Then need to move to element and then perform on the element to activate it.
		action.
		moveToElement(tutorialMenu).
		build().
		perform();
		//Now wait for the element visible
		waitMethod.WaitForElementVisibility(driver, tutorialMenu, 7);  // waits till the tutorial menu element is visible
		
		//Now Hover to the submenu  -- Web automation tool
		WebElement subElement = driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]/ul/li[2]/a/span/span"));
        
		//waitMethod.ClickFoundElement(driver, subElement, 5);  // this is just a click method
		
		action.
        moveToElement(subElement).
        build().
        perform();
		
		// after perform, wait for the element to be visible - explicitly
		waitMethod.WaitForElementVisibility(driver, subElement, 7);
        
        

//        //Now need to click on the sub-submenu Selenium in Java
        WebElement subSubElement = driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]/ul/li[2]/ul/li[3]/a/span/span"));
        
        //waitMethod.ClickFoundElement(driver, subSubElement, 5);  // this method works as it is driver.click()

        action.moveToElement(subSubElement).build().perform(); // does not work
        // wait for the subSubElement till it is visible and then perform
        waitMethod.WaitForElementVisibility(driver, subSubElement, 7);
        
        //action.click(); // does not work
        //action.click(subSubElement);
		String expectedTitle = "Free Selenium Tutorial | Selenium WebDriver Tutorials | For Beginners";
		
		String actualPageTitle = driver.getTitle();
		
		System.out.println("The Page Title after clicking 3rd sub menu is : "+actualPageTitle);
		
		Assert.assertEquals(expectedTitle, actualPageTitle);
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
