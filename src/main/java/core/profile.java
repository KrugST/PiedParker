package core;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class profile {
	
	public static void main(String[] args) throws IOException, InterruptedException

	{
	

	String pwd="";
	String url = "http://piedparker-affg.azurewebsites.net/Account/Login?ReturnUrl=%2F";
	String log_in = "stan@afamilyfriendgroup.com";
	String cam = "Da1";
	//String log_in = "piedparker_admin@gmail.com";
	
	eth_mac eth = new eth_mac();
	pwd = eth.mac();
	pwd = pwd + cam;

	WebDriver driver = new FirefoxDriver();

	login loging = new login();
	loging.logging(driver, url, log_in, pwd);
	
	driver.findElement(By.xpath("//li[3]/a/span")).click();
	
	
	driver.close();
	
	
	}
	
	
}
