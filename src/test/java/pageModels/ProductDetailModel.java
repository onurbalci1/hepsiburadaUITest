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
    By allProduct = By.xpath("//a[@title='Tüm Markalar']");
    By nValue = By.xpath("//a[text()='N']");
    By productNameValue = By.xpath("//span[@class='brand-name']");
    By productLengthValue = By.xpath("//span[@class='brand-length']");
    By newNikeProduct = By.xpath("//div[@class='title-wrapper with-bg for-desktop brand']/div/div/div");



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

    public void ClickAllProduct() {click(allProduct);}
    public void ClickNValue() {click(nValue);}
    int a =  0;
    public int getNikeProductCount() {

        for (WebElement element : webDriver.findElements(productNameValue)){
            a++;
            if (element.getText().contains("Nike"))
                break;
        }
        String nikeProduct = webDriver.findElements(productLengthValue).get(a-1).getText();
        nikeProduct = nikeProduct.substring(0,nikeProduct.length()-nikeProduct.indexOf(" ")-1);
        return Integer.parseInt(nikeProduct);
    }
    public void ClickNikeProduct() {webDriver.findElements(productLengthValue).get(a-1).click();}
    public int getNewNikeProduct(){
        String nikeNewProduct = webDriver.findElement(newNikeProduct).getText();
        nikeNewProduct = nikeNewProduct.substring(0,nikeNewProduct.length()-nikeNewProduct.indexOf(" ")-4).replace(".","");
        return Integer.parseInt(nikeNewProduct);
    }

}

