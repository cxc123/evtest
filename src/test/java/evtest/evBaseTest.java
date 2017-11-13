package evtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 11/11/17.
 */
public class evBaseTest {
    WebDriver driver;
    String currentDir = System.getProperty("user.dir");
    @Parameters({ "browser" })
    @BeforeTest
    public void setup(String browser) throws Exception
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", currentDir+"/"+"chromedriver");
            driver  = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("firefox"))
        {

            System.setProperty("webdriver.chrome.driver", currentDir+"/"+"geckodriver");
             driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get("http://www.ss.com");

    }

    @AfterTest
    public void tearDown() throws  Exception
    {
        driver.quit();

    }
}
