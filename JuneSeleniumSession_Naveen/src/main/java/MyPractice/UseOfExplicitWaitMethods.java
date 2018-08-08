package MyPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseOfExplicitWaitMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); // URL
		// Use explicit wait times for the following elements
		//1. for all elements to load
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // This method is a dynamic method which waits for all the elements to load. 
		// The above is not preferred because, we dont need all the elements in major of the times.
			//System.out.println(driver.getTitle());// Print the title of the page
			 
		//2. for the shopNow button on the rotating frame
		driver.manage().window().maximize();  // to maximize the window
		
		System.out.println("Title of the page loaded is :"+driver.getTitle());

		
		// Call the ExplicitWaitMethods
		
		ExplicitWaitMethods waitMethod = new ExplicitWaitMethods();
		
		//To verify the ShopNowButton exists. 
			
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		//System.out.println(getText(driver, createAccountButton, 5));
		//System.out.println(getElementText(driver, createAccountButton, 8));   // old method replaced by ObjRef
		System.out.println(waitMethod.ReadText(driver, createAccountButton, 8));

		
		//To send email address as testEmail@gmail.com
		WebElement createAccountEmail = driver.findElement(By.id("email_create"));
		waitMethod.TypeText(driver, createAccountEmail, 3, "testEmail@gmail.com");
		
		//To click on the button after load - 5 sec
		//clickOn(driver, createAccountButton, 5);  // old method replaced as
		 waitMethod.ClickFoundElement(driver, createAccountButton, 5);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

//	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
//		element.click();
//	}
//	
//	public static void typeText(WebDriver driver, WebElement element, int timeout, String value) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
//		element.sendKeys(value);
//	}
//
//	public static String getText(WebDriver driver, WebElement element, int timeout) {
//		String text = " ";
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElementValue(element, text));
//		text = element.getText();
//		return text;
//	} 
//	
//	public static String getElementText(WebDriver driver, WebElement element, int timeout) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
//		return element.getText();
//		}
	
	}
