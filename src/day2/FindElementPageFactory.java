package day2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import day1.Setup;

public class FindElementPageFactory extends Setup{

	public static void main(String[] args) {
		//Load Browser
		loadBrowser("chrome");
		//Load URL
		loadURL("https://www.toolsqa.com/automation-practice-form/");
		//Search/Find Element & sendKey
		searchElement(By.xpath("//input[@name='firstname']")) .sendKeys("Automation");
		//Search/Find Element & sendKey
		searchElement(By.name("lastname")).sendKeys("Practice");
		//Verify element is display or not ?? return : true/false
		System.out.println("Is Display : "+searchElement(By.className("control-group")).isDisplayed());
		// Click on linkText and download file
		searchElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		// getText from Partial Link Text
		String s = searchElement(By.partialLinkText("Hybrid Framework")).getText();
		System.out.println("Get Text : "+s);
		// Check is Redio button is select or not?
		System.out.println("Is Radio button select"+searchElement(By.id("sex-0")).isSelected());
		//Click on Gender Radio button
		searchElement(By.id("sex-0")).click();
		// Check is Redio button is select or not? after selecting it
		System.out.println("Is Radio button select"+searchElement(By.id("sex-0")).isSelected());
		searchElement(By.id("exp-6")).click();
		// Check if Checkbox is not selected then it will select it.
		if(!searchElement(By.id("profession-1")).isSelected())
		{
			searchElement(By.id("profession-1")).click();
		}
		// Upload file 
		searchElement(By.id("photo")).sendKeys("C:\\Users\\GS-1629\\Downloads\\OnlineStore.zip");
		// Select Dropdown option
		WebElement dropdown = searchElement(By.id("continents"));
		dropdown.click();
		Select selectdd = new Select(dropdown);
		//Select value by index
		selectdd.selectByIndex(2);
		//select value by value
		// Here selectByValue is not work, because dropdown -> option do not have value attribute
//		selectdd.selectByValue("Australia");
		//select value by visible text
		selectdd.selectByVisibleText("Antartica");
		
		// If we wants to deSelect value from drop down then follow
		selectdd.deselectByIndex(2);
		// Deselect by value
		selectdd.deselectByValue("Antartica");
		//Deselect By visible text
		selectdd.deselectByVisibleText("Antartica");
		
		
		// SELECT MYLTIPLE VALUES FROM DORPDOW
		WebElement multipledd = searchElement(By.id("selenium_commands"));
		Select mulSelect = new Select(multipledd);
		
		mulSelect.selectByIndex(1);
		mulSelect.selectByIndex(2);
		closeBrowser();
	}
	
	
	public static WebElement searchElement(By locator)
	{
		return Setup.driver.findElement(locator);
	}
	
	
	public void test()
	{
		WebElement element = driver.findElement(By.name("firstname"));
		element.sendKeys("Automation practice");
	}
	
	public void MultipleElements()
	{
		List<WebElement> ls = driver.findElements(By.xpath("//nput"));
		
	}
}
