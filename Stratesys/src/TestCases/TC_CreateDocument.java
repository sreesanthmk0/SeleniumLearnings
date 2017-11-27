package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_CreateDocument {

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
		createDocument();
		System.out.println(docNumber("Test_DOC_04Sep1.0"));
		//driver.close();
		InReview(docNumber("Test_DOC_04Sep1.0"));
	}


	public static void login() throws Throwable {
		
		driver.findElement(By.name("pf.username")).sendKeys(userName);
		driver.findElement(By.name("pf.pass")).sendKeys(Password);
		driver.findElement(By.name("pf.pass")).submit();
		
	}
	
	public static void createDocument() throws Throwable {
		driver.findElement(By.xpath("//div[@id='menuApps']/div/h4[contains(text(),'Select one of the applications available')]/following-sibling::div/div[@id='buttonEDMS']/div")).click();
		busyIndicator();
		driver.findElement(By.id("dropdown-menu-hamb")).click();
		driver.findElement(By.id("button-newDocumentWorkflow")).click();
		busyIndicator();
		driver.findElement(By.xpath("//div/span[contains(text(),'Name')]/following-sibling::input")).sendKeys("Test_DOC_04Sep1.0");
		select_WebElement("//div/span[contains(text(),'Center')]/following-sibling::select","GLOBAL QMS");
		select_WebElement("//div/span[contains(text(),'Document Type')]/following-sibling::select","Sree_Test");
		//driver.findElement(By.xpath("//div/span[contains(text(),'DCO')]/following-sibling::input")).click();
		//busyIndicator();
		//System.out.println(driver.findElement(By.id("templatetitle")).getText());
		//driver.findElement(By.xpath("//table[@id='templateResultsTable']/tbody/tr[1]/td[1]")).click();
		//busyIndicator();
		//driver.findElement(By.xpath("//div/span[contains(text(),'Authors')]/following-sibling::input")).click();
		//select_WebElement("//div/span[contains(text(),'Find')]/following-sibling::select","User Log-in");
		//driver.findElement(By.xpath("//div/span[contains(text(),'that starts with')]/following-sibling::input")).sendKeys(author);
		//driver.findElement(By.id("searchUsers")).click();
		//busyIndicator();
		//driver.findElement(By.xpath("//td[contains(text(),'310273045')]")).click();
		driver.findElement(By.xpath("//div/span[contains(text(),'Reason for Change')]/following-sibling::textarea")).sendKeys("Test_DOC_23Aug1.0");
		driver.findElement(By.xpath("//div[@id='pendingTaskDocumentsBody']/div")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Document')]")).click();
		busyIndicator();
		Runtime.getRuntime().exec("F:\\Workspace\\Stratesys\\src\\trial_DRC_Release1_HISS\\UploadDoc.exe");
		busyIndicator();
		delay();
		driver.findElement(By.id("Disposition_Create")).click();
		//busyIndicator();
		driver.navigate().refresh();
		delay();
		delay();
		System.out.println("Done Creating");
	}
	
	public static String docNumber(String docName) throws Throwable {
		System.out.println("docname1");
		delay();
		System.out.println("docname2");
		driver.findElement(By.id("seeAllWF")).click();
		driver.findElement(By.id("inTableGeneric")).sendKeys(docName);
		String docn = driver.findElement(By.xpath("//tbody[@id='tableSeeAllBody']/tr[@style=	'display: table-row;']/td[1]")).getText().split("-") [2].split(" ") [0];
		driver.findElement(By.id("inTableGeneric")).clear();
		driver.navigate().refresh();
		delay();
		delay();
		return docn;
	} 
	
	public static void createDCO() throws Throwable {
		driver.findElement(By.id("dropdown-menu-hamb")).click();
		driver.findElement(By.id("button-newDCOWorkflow")).click();
		busyIndicator();
		
		driver.findElement(By.xpath("//div[@id='pendingTaskDocumentsAnnexes']/div[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Document')]")).click();
		busyIndicator();
		Runtime.getRuntime().exec("F:\\Workspace\\Stratesys\\src\\trial_DRC_Release1_HISS\\UploadDoc.exe");
		driver.findElement(By.id("Disposition_Create")).click();
		busyIndicator();
		driver.findElement(By.id("collapseWFdesp")).click();
		
	}
	
	public static void select_WebElement(String xpath, String val) {
		Select	sel = new Select(driver.findElement(By.xpath(xpath)));
		sel.selectByVisibleText(val);
	}
	
	public static void  applicationLogin() throws Throwable {
		delay();
		driver.findElement(By.id("user")).sendKeys("TestAuthor1");
		driver.findElement(By.id("password")).sendKeys("Philip$123");
		driver.findElement(By.id("loginEBERS")).click();
		//driver.findElement(arg0)
	}
	
	public static void busyIndicator() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("loading")), "style", "display: none;"));
		}

	
	public static void delay() throws Throwable {
		Thread.sleep(10000);
	}
	
	public static void InReview(String docNum) throws Throwable 
	{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		//driver.findElement(By.id("buttonEDMS")).click();
		busyIndicator();
		driver.findElement(By.id("seeAllTasks")).click();
		driver.findElement(By.id("inTableGeneric")).sendKeys(docNum);
		//driver.findElement(By.id("inTableGeneric")).sendKeys(docName);	
		driver.findElement(By.id("tableSeeAllBody")).click(); 
		driver.findElement(By.id("Disposition_Review")).click();
	}	
	
}





