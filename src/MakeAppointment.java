import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class MakeAppointment {

    @Test
    void TC1001MakeAppointment_Success() throws InterruptedException  {
        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		Select option1 = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
		option1.selectByVisibleText("Seoul CURA Healthcare Center");
		driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]"));
		radio2.click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("18/1/2023");
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Hello World");
		driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
		String result = driver.findElement(By.id("comment")).getText();
		if(result.equalsIgnoreCase("Hello World"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		Thread.sleep(4000);
        driver.quit();
        driver = null;
    }
}