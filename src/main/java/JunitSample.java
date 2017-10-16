import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class JunitSample {

    protected static WebDriver DRIVER;
    protected static final String DRIVER_EXE = "webdriver.chrome.driver";
    protected static final String DRIVER_PATH = "C:\\temp\\test automation training\\chromedriver.exe";
    protected static final String API_URL = "http://localhost:8080/samplebank/index";


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty(DRIVER_EXE, DRIVER_PATH);
        DRIVER = new ChromeDriver();
        DRIVER.get(API_URL);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
//        DRIVER.close();
//        DRIVER.quit();
    }

    @Before
    public void setUp() throws Exception{
        WebElement usernameElement = DRIVER.findElement(By.id("username"));
        usernameElement.sendKeys("admin");

        WebElement passwordElement = DRIVER.findElement(By.id("password"));
        passwordElement.sendKeys("admin");

        DRIVER.findElement(By.xpath("//*[@value='Login']")).click();

        Assert.assertEquals("Welcome, admin (logout)",DRIVER.findElement(By.id("sb-username")).getText());
    }

    @After
    public void tearDown() throws Exception{
        DRIVER.findElement(By.xpath("//*[@href='logout']")).click();
    }

    @Test
    public void addAccountTest(){
        DRIVER.findElement(By.xpath("//*[@href='addAccount']")).click();

        Assert.assertEquals("New Customer Account",DRIVER.findElement(By.xpath("//*[@class='sb-content-desc']")).getText());

        WebElement ownerCpfElement = DRIVER.findElement(By.id("ownerCpf"));

        ownerCpfElement.sendKeys("14785833718");

        DRIVER.findElement(By.xpath("//*[@value='Create Account']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());

    }

    @Test
    public void depositTest(){
        DRIVER.findElement(By.xpath("//*[@href='deposit']")).click();

        Select drpAccount = new Select(DRIVER.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("07249738933");

        DRIVER.findElement(By.id("ammount")).sendKeys("12.13");
        DRIVER.findElement(By.xpath("//*[@value='Deposit']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());
    }

    @Test
    public void accountInformationTest(){
        DRIVER.findElement(By.xpath("//*[@href='accountInfo']")).click();
        Select drpAccount = new Select(DRIVER.findElement(By.id("ownerCpfSelect")));
        drpAccount.selectByVisibleText("07249738933");

        DRIVER.findElement(By.xpath("//*[@value='Get Information']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());
    }

    @Test
    public void withdrawnTest(){
        DRIVER.findElement(By.xpath("//*[@href='withdraw']")).click();

        WebElement pageTitle = DRIVER.findElement(By.xpath("//*[contains(@class, 'sb-content-desc')]"));
        Assert.assertEquals("Withdraw Amount",pageTitle.getText());

        Select drpAccount = new Select(DRIVER.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("07249738933");

        DRIVER.findElement(By.id("ammount")).sendKeys("0.01");

        DRIVER.findElement(By.xpath("//*[@value='Withdraw']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());
    }

    @Test
    public void transferTest(){
        DRIVER.findElement(By.xpath("//*[@href='transfer']")).click();

        WebElement pageTitle = DRIVER.findElement(By.xpath("//*[contains(@class, 'sb-content-desc')]"));
        Assert.assertEquals("Transfer Amount Between Accounts",pageTitle.getText());

        Select drpAccountSource = new Select(DRIVER.findElement(By.id("sourceAccount")));
        drpAccountSource.selectByVisibleText("07249738933");

        Select drpAccountTarget = new Select(DRIVER.findElement(By.id("targetAccount")));
        drpAccountTarget.selectByVisibleText("07233893794");

        DRIVER.findElement(By.id("ammount")).sendKeys("0.01");

        DRIVER.findElement(By.xpath("//*[@value='Transfer']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());
    }

    @Test
    public void loansTest(){
        DRIVER.findElement(By.linkText("Loans")).click();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }

        DRIVER.findElement(By.xpath("//*[@href='loan']")).click();

        WebElement pageTitle = DRIVER.findElement(By.xpath("//*[contains(@class, 'sb-content-desc')]"));
        Assert.assertEquals("Credit Operations: Get Loan",pageTitle.getText());

        Select drpAccountSource = new Select(DRIVER.findElement(By.id("targetAccount")));
        drpAccountSource.selectByVisibleText("07233893794");

        DRIVER.findElement(By.id("ammount")).sendKeys("10.00");

        DRIVER.findElement(By.xpath("//*[@value='Get Loan!']")).click();

        WebElement successMessage = DRIVER.findElement(By.id("sb-return-message"));
        Assert.assertEquals("Operation completed with success",successMessage.getText());
    }
}
