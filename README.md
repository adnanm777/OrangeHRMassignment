# OrangeHRMassignment
This project automates the login process for the OrangeHRM demo site using Selenium WebDriver and clicks on the "PIM" section.

# OrangeHRM Login Automation

This project automates the login process for **OrangeHRM** using **Selenium WebDriver** in Java. It logs into the application and clicks on the **PIM** menu.

## 🛠️ Prerequisites

Ensure you have the following installed:

- **Java 8 or higher**  
- **Maven (for dependency management)**  
- **Chrome Browser**  
- **ChromeDriver** (Managed automatically using WebDriverManager)  

package Orangehrm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

public class OrangeHRMLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);

        if (driver.getCurrentUrl().contains("dashboard")) System.out.println("✅ Login Successful!");
        else { System.out.println("❌ Login Failed!"); driver.quit(); return; }

        driver.findElement(By.cssSelector("a.oxd-main-menu-item[href*='pim']")).click();
        System.out.println("✅ Clicked on PIM!");
        Thread.sleep(5000);
        driver.quit();
    }
}



