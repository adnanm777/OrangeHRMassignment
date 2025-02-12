package Orangehrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {
	
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000); 

        // Login to OrangeHRM
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        Thread.sleep(5000); 

        // Verify login success
        if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
            driver.quit();
            return;
        }

        // Click on "PIM"
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a.oxd-main-menu-item[href*='pim']")).click();
        System.out.println("Clicked on PIM!");

        Thread.sleep(5000); 
        //driver.quit();
        
        //Add employee name
        
        
    }
}

		
	

