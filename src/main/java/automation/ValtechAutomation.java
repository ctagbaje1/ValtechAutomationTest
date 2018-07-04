package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ValtechAutomation {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.ie.driver", "C:\\TEMP\\valtech\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.valtech.com/");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test()
    public void goValtechPage() throws InterruptedException {
        Thread.sleep(2000);
        String bodyText = driver.findElement(By.xpath("//h2[contains(text(),'Latest news')]")).getText();
        System.out.println(bodyText);
        Thread.sleep(2000);
        Assert.assertTrue(bodyText.toLowerCase().contains("latest news"));

// Assert that H1 tag in each page is displaying(SAME for work and services)
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/about/']")).click();
        Thread.sleep(3000);
        String h1Text = driver.findElement(By.xpath("//h1[contains(text(),'About')]")).getText();

        Assert.assertTrue(h1Text.contains("About"));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/work/']")).click();
        Thread.sleep(3000);
        String h1WorkText = driver.findElement(By.xpath("//h1[contains(text(),'Work')]")).getText();

        Assert.assertTrue(h1WorkText.contains("Work"));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/services/']")).click();
        Thread.sleep(3000);
        String h1servicesText = driver.findElement(By.xpath("//h1[contains(text(),'Services')]")).getText();
        Assert.assertTrue(h1servicesText.contains("Services"));
        Thread.sleep(2000);

// Navigate to contact page and output how many VALTECH offices in total

        driver.findElement(By.xpath("//i[@class='icons glyph']")).click();
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.cssSelector(".contactcountry>h3"));
        System.out.println("VALTECH offices in total is "+ results.size());


    }



}


