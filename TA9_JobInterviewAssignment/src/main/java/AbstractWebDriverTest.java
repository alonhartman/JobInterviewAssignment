import Enums.DriversPaths;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractWebDriverTest {

    protected WebDriver driver;
    protected String url = "https://todoandroid.herokuapp.com";
    protected String elementValue;
    protected WebElement webElement;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DriversPaths.Chrome.getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
