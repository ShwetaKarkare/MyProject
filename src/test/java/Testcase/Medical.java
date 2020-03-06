package Testcase;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Medical {

	@Test
	public void createPatient() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.openemr.io/a/openemr");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.name("clearPass")).sendKeys("pass");
		driver.findElement(By.className("fa-sign-in")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).perform();
		driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.name("pat")));
		
		driver.findElement(By.name("form_fname")).sendKeys("Shweta");
		driver.findElement(By.name("form_lname")).sendKeys("Pat");
		driver.findElement(By.id("form_DOB")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("xdsoft_today")).click();
		Select gender = new Select (driver.findElement(By.id("form_sex")));
		gender.selectByIndex(1);
		
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		driver.findElement(By.xpath("/html/body/center/input")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	
	
	
}
