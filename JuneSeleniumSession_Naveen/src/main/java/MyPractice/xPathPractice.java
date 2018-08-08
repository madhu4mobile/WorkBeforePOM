package MyPractice;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class xPathPractice {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.practiceselenium.com/practice-form.html");
		
		//Agenda: to identify different types of HTML elements like text_fields, link, button, chk box etc
		
		//1. Text field Identify by Name
				
		driver.findElement(By.name("firstname")).sendKeys("MyFirstName");
		driver.findElement(By.name("lastname")).sendKeys("MyLastNme");
		
		//using xpath  -- the second one does not work.
		driver.findElement(By.xpath("//input[@name='firstname']")).clear(); // To clear the existing value
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("SecondAttempt");
		driver.findElement(By.xpath("//input[@name='lastname']")).clear(); // To clear the existing value
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ThirdAttempt");
				//driver.findElement(By.xpath("//input[@name='firstname' and @type='text']")).sendKeys("SecondAttempt");
		//radio buttons select female as sex
		driver.findElement(By.xpath("//input[@id='sex-1']")).click();
		
		// select number of years drinking chai --> 5 ( so 4th index is to be selected
		List<WebElement> chaiYears = driver.findElements(By.xpath("//*[@name='exp']"));
		System.out.println("Number of options for ChaiYears: "+chaiYears.size());
		if(!chaiYears.get(4).isSelected()) {//This will return true if the 5th radio button is not selected
			chaiYears.get(4).click();
		}else {
			System.out.println("Chai Drinking year 5 is already selected");
		}
		// use the value 08/05/2018 in the date stopped field
		driver.findElement(By.id("datepicker")).sendKeys("08/05/2018");
		
		//select blacktea and oolang tea as favorite tea -- checkBox
		System.out.println("Checking out BlackTea and OOlong Tea As favorite teas");
		driver.findElement(By.name("BlackTea")).click();
		driver.findElement(By.name("oolongtea")).click();
		
		//exciting about chai checkbox
		List<WebElement> excitingFact = driver.findElements(By.xpath("//div[@class='control-group' ]//input[starts-with(@id,'tool')]"));
				// explanation of x-path: it is in div - class 'control-group' and input 'starts-with' id 'tool'
		for(int i=0;i<excitingFact.size();i++) {
			//System.out.println(excitingFact.get(i).getAttribute("value"));// to print all values of checkboxes
			if (excitingFact.get(i).getAttribute("value").contains("Harmless")){// To select the checkbx with text Harmless
				excitingFact.get(i).click();
				System.out.println("The Exciting option --> Harmless addiction is selected");
			}
		}
		//To select Asia from continent
		System.out.println("**************************");
		WebElement eContinent = driver.findElement(By.xpath("//select[@id='continents']"));
		Select oSelect = new Select(eContinent);
		oSelect.selectByVisibleText("Asia");
		System.out.println("Continent Asia is selected from DropDown from Visible text");
		Thread.sleep(5000);
		oSelect.selectByIndex(0); // BACK TO usa
		System.out.println("Continent is Taken back to default value USA");
		System.out.println("**************************");
		
		//Get the list of all options in Lets get back to work..List
		WebElement myDropDown = driver.findElement(By.xpath("//select[@id='selenium_commands']"));//Step1 to create webelementn for TheDropdown
		Select dropDown = new Select(myDropDown); // step2: To initiate the select obj reference
		List<WebElement> options = dropDown.getOptions(); // step3: to get options from the select obj-ref
		System.out.println("The available options in dropdown list are:");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		System.out.println("Time to click Ok button");
		driver.findElement(By.id("submit")).submit();
		Thread.sleep(5000);
		//Verify that the home page is reached.
		String Title = "Welcome2";
		String PresentPageTitle = driver.getTitle();
		Assert.assertEquals(Title, PresentPageTitle);
		System.out.println("Reached HomePage");
		driver.quit();
	}

}
