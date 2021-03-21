package pageModels;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductDetailModel extends BaseModel {

    By txtSearch = By.className("desktopOldAutosuggestTheme-input");
    By listProductTitles = By.className("product-title");
    By tabProductReviews = By.id("productReviewsTab");
    By listYesAnswer = By.xpath("//div[@class='hermes-ReviewCard-module-1lb7d']/div[1]");
    By listThanksResponse = By.xpath("//span[text()='Teşekkür Ederiz.']");
    By listDropdown = By.xpath("//div[@class = 'hermes-Sort-module-1YI0F']/div");



    public ProductDetailModel(WebDriver webDriver){
        super(webDriver);
    }
    public void setProduct(String product){
        sendKey(txtSearch, product + Keys.ENTER);
    }
    public List<WebElement> listProductTitle(){
        return getText(listProductTitles);
    }
    public void clickProductReviews(){
        click(tabProductReviews);
    }
    public List<WebElement> listYes(){
        return getText(listYesAnswer);
    }
    public List<WebElement> listThanks(){
        return getText(listThanksResponse);
    }
    public List<WebElement> listDropbox(){
        return getText(listDropdown);
    }

}
