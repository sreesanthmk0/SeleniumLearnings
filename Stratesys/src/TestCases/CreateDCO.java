//Testing Github
package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDCO {
	
	public static WebDriver driver;
	public static String author = "310273045";
	public static String userName = "310273045";
	public static String Password = "asynchronouS@2017";
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.firefox.marionette","");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://tst.dim.philips.com/otcs/cs.exe");
		login();
		Thread.sleep(10000);
		driver.navigate().to("https://tst.stratesys.dim.philips.com/EBERS-APP");
		
		driver.findElement(By.xpath("//div[@id='menuApps']/div/h4[contains(text(),'Select one of the applications available')]/following-sibling::div/div[@id='buttonEDMS']/div")).click();
		busyIndicator();
		driver.findElement(By.id("dropdown-menu-hamb")).click();
		driver.findElement(By.id("button-newDCOWorkflow")).click();
		
		//Select sel = new Select(driver.findElement(By.id("inputAttr_14_0"));
		
		busyIndicator();
	}
	
	public static void login() throws Throwable {
		
		driver.findElement(By.name("pf.username")).sendKeys(userName);
		driver.findElement(By.name("pf.pass")).sendKeys(Password);
		driver.findElement(By.name("pf.pass")).submit();
	}
	
	public static void busyIndicator() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("loading")), "style", "display: none;"));
	}

	
}
