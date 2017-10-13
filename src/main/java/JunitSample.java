import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitSample {

    protected static final WebDriver DRIVER = new ChromeDriver();
    protected static final String DRIVER_EXE = "webdriver.chrome.driver";
    protected static final String DRIVER_PATH = "C:\\temp\\test automation training\\chromedriver.exe";
    protected static final String API_URL = "http://localhost:8080/samplebank/index";


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty(DRIVER_EXE, DRIVER_PATH);
        DRIVER.get(API_URL);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        DRIVER.close();
        DRIVER.quit();
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
    public void addAccount(){
        DRIVER.findElement(By.xpath("//*[@href='addAccount']")).click();

        Assert.assertEquals("New Customer Account",DRIVER.findElement(By.xpath("//*[@class='sb-content-desc']")).getText());

        WebElement ownerCpfElement = DRIVER.findElement(By.id("ownerCpf"));

    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}
