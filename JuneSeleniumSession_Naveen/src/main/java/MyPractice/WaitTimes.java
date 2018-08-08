package MyPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTimes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.freecrm.com/index.html");
		
		//wait till the complete page loads  --browser page loading
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		System.out.println("Page Title is :"+driver.getTitle());
		//for all elements to load  -- global wait -- implicit wait
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//explicit wait:
		//used for specific element
		
		WebElement chatWindow = driver.findElement(By.linkText("Forgot Password?"));
		String myText = ExplicitWaitMethods.ReadText(driver, chatWindow, 20 );
		System.out.println("Text read from the element is ::"+myText);
		if (myText == "Sign Up"){
			System.out.println("Chatwinow is active. Now closing it.");
			driver.switchTo().activeElement();
			driver.close();
		}
		ExplicitWaitMethods type = new ExplicitWaitMethods(); // as TypeText is not static we have to instantiate the obj ref.
		
		//create elements and use them from the custom methods below	
		WebElement username = driver.findElement(By.name("username"));
		type.TypeText(driver, username, 5, "naveenk");
		
		WebElement pwd = driver.findElement(By.name("password"));
		type.TypeText(driver, username, 5, "test@123");		
		
	
		Thread.sleep(5000);
	
		driver.quit();
	}

	
	

}
