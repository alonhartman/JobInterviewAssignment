import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TA9_TestSelenium extends AbstractWebDriverTest{

    @Test
    public void test_loginWithValidCredentials() throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
        driver.findElement(By.name("phone")).sendKeys("0000000000");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[3]/form/md-content/section/button")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.name("verificationCode")).sendKeys("2822");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        webElement = driver.findElement(By.xpath("//*[@id=\"VerificationCodePromptContainer\"]/div[2]/md-dialog/md-dialog-actions/button/span"));
        webElement.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("h2"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

}
