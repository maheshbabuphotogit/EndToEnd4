package commonPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage {
	
	    public static WebDriver driver;
	    public static Properties prop;
	    
	    
	
	@Test
	public void landingpageTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// #1 Setup the config file
		prop = new Properties();
		FileInputStream Fis = new FileInputStream("src/test/resources/config.properties");
		prop.load(Fis);
		
		// #2 Call browser
		String Browser = prop.getProperty("Browser");
		
		 if (Browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
		 
		 driver.manage().window().maximize();
		 // #3 Launch URl
		 
		 String URL = prop.getProperty("URL");
		 driver.get(URL);
		 
		 // Wait mechanism
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 
		 // Enter the credentis
		 WebElement  username = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		 username.sendKeys(prop.getProperty("Username"));
		 
		 
		 WebElement  password = driver.findElement(By.name("password"));
		 password.sendKeys(prop.getProperty("Password"));
		 
		 WebElement  submitbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		 submitbutton.click();
		 
		 
		
		
		
		
		
		
	}

}
