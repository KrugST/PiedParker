package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	public String logging(WebDriver driver, String url, String log_in, String pwd)

	{

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.id("LoginEmail")).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("LoginEmail")).sendKeys(log_in);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


		driver.findElement(By.id("LoginPassword")).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("LoginPassword")).sendKeys(pwd);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[3]/div/button")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return null;

	}

}
