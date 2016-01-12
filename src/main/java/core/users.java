package core;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class users {

	public static String url = "http://piedparker-affg.azurewebsites.net/Account/Login?ReturnUrl=%2F";
	public static String log_in = "piedparker_admin@gmail.com";
	public static String pwd = null;
	public static String cam = "Da1";
	public static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {

		// public static String log_in = "piedparker_admin@gmail.com";
		// public static String log_in = "atisaga@gmail.com";

		driver = new FirefoxDriver();

		/*
		 * Capabilities caps = new DesiredCapabilities(); ((DesiredCapabilities)
		 * caps).setJavascriptEnabled(true); ((DesiredCapabilities)
		 * caps).setCapability("takesScreenshot", true); ((DesiredCapabilities)
		 * caps).setCapability(PhantomJSDriverService.
		 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"phantomjs");
		 * 
		 * 
		 * driver = new PhantomJSDriver(caps);
		 */
		eth_mac eth = new eth_mac();
		pwd = eth.mac();
		pwd = pwd + cam;

		// login method
		login loging = new login();
		loging.logging(driver, url, log_in, "123123");

		System.out.println("login: " + log_in);
		System.out.println("password: " + "");

		
int i=4;
		while (i <=20) {

		// Users
		driver.findElement(By.xpath("//li[3]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Verified button increase tr = tr +!
		driver.findElement(By.xpath("//tr["+i+"]/td[6]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
		
		// verified button
		driver.findElement(By.id("Status1")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("Status1")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Save button
		driver.findElement(By.xpath("//div[4]/div/input")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		i++;
		}
		
		driver.close();

	}

}
