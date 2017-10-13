import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
    public static void main(String[] args) {


//        final String ownerCpf = GeradorCPF.gerar();

        WebElement ownerCpfElement = driver.findElement(By.id("ownerCpf"));
        ownerCpfElement.sendKeys("07249738933");
        driver.findElement(By.xpath("//*[@value='Create Account']")).click();

        WebElement successMessage = driver.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());

        driver.findElement(By.xpath("//*[@href='deposit']")).click();

        Select drpAccount = new Select(driver.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("07249738933");

        driver.findElement(By.id("ammount")).sendKeys("12.13");
        driver.findElement(By.xpath("//*[@value='Deposit']")).click();

        Assert.assertEquals("Operation completed with success",successMessage.getText());


//        driver.close();
//        driver.quit();


    }
}
