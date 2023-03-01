package contoh2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
//import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.io.Files;

public class logintest {

	public static void main(String[] args) throws IOException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Suherlina\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		//menunggu hingga elemen tertentu berhasil ditemukan
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")));
		
		
		//implicit wait : menunggu dengan batas waktu yang jelas
		//TIDAK MENUNDA SCREENSHOT
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//tangkap layar
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\OUTPUT\\2023\\03\\01\\logintest.png"));
		
		
		//driver.close();
	}
	
	
}
