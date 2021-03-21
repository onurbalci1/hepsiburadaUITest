package tests;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageModels.ProductDetailModel;


public class ProductDetailTest extends BaseTest {
    @Test
    public void evaluationTest() {
        background();
        ProductDetailModel productDetailModel = new ProductDetailModel(webDriver);
        webElements = productDetailModel.listYes();
        for (WebElement element : webElements){
            productDetailModel.scrollDown();
            element.click();
            break;
        }

        webElements = productDetailModel.listThanks();
        for (WebElement element : webElements){
            Assert.assertEquals(element.getText(), "Teşekkür Ederiz.", "İstenilen mesaj gösterilmedi...");
            break;
        }
    }

    @Test
    public void evaluationDropboxTest() {
        background();
        ProductDetailModel productDetailModel = new ProductDetailModel(webDriver);
        List<String> values = new ArrayList<>();
        values.add("Varsayılan");
        values.add("En yeni değerlendirme");
        values.add("En faydalı değerlendirme");
        values.add("Puana göre azalan");
        values.add("Puana göre artan");
        productDetailModel.scrollDown();
        webElements = productDetailModel.listDropbox();
        int count = 0;
        for (WebElement element : webElements){
            Assert.assertEquals(element.getText(), values.get(count), "Dropbox'da içeriği yanlış");
            count++;
        }
    }
}
