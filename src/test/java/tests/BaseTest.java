package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageModels.ProductDetailModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    List<WebElement> webElements;
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //ProductDetailModel productDetailModel = new ProductDetailModel(webDriver);
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.hepsiburada.com/");
    }

    public void background(){
        ProductDetailModel productDetailModel = new ProductDetailModel(webDriver);
        productDetailModel.setProduct("Iphone");
        webElements = productDetailModel.listProductTitle();
        webElements.get(0).click();
        productDetailModel.clickProductReviews();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
