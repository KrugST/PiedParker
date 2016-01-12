package core;

import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import java.util.concurrent.TimeUnit;

public class listings {

	public static String url = "http://piedparker.azurewebsites.net/Account/Login?ReturnUrl=%2F";
	public static String log_in = "stan@afamilyfriendgroup.com";


	public static String pwd = null;
	public static WebDriver driver = null;
	public static String csvFile = "Test.csv";
	public static BufferedReader br = null;

	public static PrintStream out = null;
	public static String line = null;

	public static void main(String[] args) throws IOException, InterruptedException

	{

		driver = new FirefoxDriver();
/*
		
		 Capabilities caps = new DesiredCapabilities(); ((DesiredCapabilities)
		 caps).setJavascriptEnabled(true); ((DesiredCapabilities)
		  caps).setCapability("takesScreenshot", true); ((DesiredCapabilities)
		  caps).setCapability(PhantomJSDriverService.
		  PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"phantomjs.exe");
		  
		  
		  driver = new PhantomJSDriver(caps);
*/		 
		eth_mac eth = new eth_mac();
		pwd = eth.mac();

		
		// login method
		login loging = new login();
		
		
		loging.logging(driver, url, log_in, "123");

		br = new BufferedReader(new FileReader(csvFile));
		out = new PrintStream(new FileOutputStream("out.txt"));

		while ((line = br.readLine()) != null) 
		{
			
			add(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			delete(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} // end while

		
			
	
		
		br.close();
		driver.close();
		out.close();

	}

	public static void add(WebDriver drv) throws IOException, InterruptedException {

		String cvsSplitBy = ";";
		String text_case_id = null;
		String title = null;
		String description = null;
		String Type_Size = null;
		String Type_Type = null;
		String Type_Description = null;
		String address = null;
		String Rate_Hourly = null;
		String Rate_Daily = null;
		String Rate_Weekly = null;
		String startDate = null;
		String endDate = null;
		String startTime = null;
		String endTime = null;

		String[] csv = line.split(cvsSplitBy);

		text_case_id = csv[0];
		title = csv[1];
		description = csv[2];
		Type_Size = csv[3];
		Type_Type = csv[4];
		Type_Description = csv[5];
		address = csv[6];
		Rate_Hourly = csv[7];
		Rate_Daily = csv[8];
		Rate_Weekly = csv[9];
		startDate = csv[10];
		endDate = csv[11];
		startTime = csv[12];
		endTime = csv[13];
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Listings
		driver.findElement(By.xpath("//li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Create new
		driver.findElement(By.id("createBtn")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
		driver.findElement(By.id("Description")).clear();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("Description")).sendKeys(description);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Select sel = new Select(driver.findElement(By.id("Type_Size")));
		sel.selectByVisibleText(Type_Size);

		Select sel2 = new Select(driver.findElement(By.id("Type_Type")));
		sel2.selectByVisibleText(Type_Type);

		driver.findElement(By.id("Type_Description")).clear();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("Type_Description")).sendKeys(Type_Description);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// add photo

		//String fileToUpload = "/parking.png";
		//String absolutePathToFile = getFilePath(fileToUpload);
		// System.out.println(absolutePathToFile);
		//driver.findElement(By.id("fileUpload2")).sendKeys(absolutePathToFile);

		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//div[3]/div/label/span")).click();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.ESCAPE);

		driver.findElement(By.id("Title")).clear();
		driver.findElement(By.id("Title")).sendKeys(title);

		// Next button
		driver.findElement(By.xpath("//div[3]/ul/li[2]/a")).click();

		// add address
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys(address);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.id("searchBtn")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Next button
		driver.findElement(By.xpath("//div[3]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.id("Rate_Hourly")).clear();
		driver.findElement(By.id("Rate_Hourly")).sendKeys(Rate_Hourly);

		driver.findElement(By.id("Rate_Daily")).clear();
		driver.findElement(By.id("Rate_Daily")).sendKeys(Rate_Daily);

		driver.findElement(By.id("Rate_Weekly")).clear();
		driver.findElement(By.id("Rate_Weekly")).sendKeys(Rate_Weekly);

		// Next button
		driver.findElement(By.xpath("//div[3]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// driver.findElement(By.id("Availability_IsAllDay")).sendKeys("True");
		driver.findElement(By.id("startDate")).clear();
		driver.findElement(By.id("startDate")).sendKeys(startDate);

		driver.findElement(By.id("endDate")).clear();
		driver.findElement(By.id("endDate")).sendKeys(endDate);

		driver.findElement(By.id("startTime")).clear();
		driver.findElement(By.id("startTime")).sendKeys(startTime);

		driver.findElement(By.id("endTime")).clear();
		driver.findElement(By.id("endTime")).sendKeys(endTime);

		// Finish button
		driver.findElement(By.xpath("//div[3]/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println(text_case_id + " " + title + " " + description + " " + Type_Size + " " + Type_Type + " "
				+ Type_Description + " " + address + " " + Rate_Hourly + " " + Rate_Daily + " " + Rate_Weekly + " "
				+ startDate + " " + endDate + " " + startTime + " " + endTime);
		out.println(text_case_id + " " + title + " " + description + " " + Type_Size + " " + Type_Type + " "
				+ Type_Description + " " + address + " " + Rate_Hourly + " " + Rate_Daily + " " + Rate_Weekly + " "
				+ startDate + " " + endDate + " " + startTime + " " + endTime);

	} // end add

	public static void delete(WebDriver drv) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		
		//li[2]/a/span
		driver.findElement(By.xpath("//li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		
		// delete button tr[*]/td[*]/a[3]
		driver.findElement(By.xpath("//tr[*]/td[*]/a[3]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		
		
		// confirm delete button
		driver.findElement(By.xpath("//div/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		/*
		// listings button
		driver.findElement(By.xpath("//li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//tr[4]/td[15]/a[2]
		
		// delete button //tr[2]/td[7]/a[3]
		driver.findElement(By.xpath("//tr[1]/td[*]/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// confirm delete button
		driver.findElement(By.xpath("//div/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		*/
		
		
		// String title_td =
		// driver.findElement(By.xpath("//tr[2]/td[2]/h5")).getText();
		// System.out.println("Title: " + title_td);
		// out.println("Deleting Title: " + title_td);

	} // end delete

	public static String getFilePath(String relativePath) {
		System.out.println("CALLED: getFilePath");
		String projectDir = System.getProperty("user.dir");
		projectDir = projectDir.replace("\\", "/");
		String absolutePath = projectDir + relativePath;
		System.out.println("Generated file path: " + absolutePath);
		return absolutePath;
	} // end getFilePath
}
