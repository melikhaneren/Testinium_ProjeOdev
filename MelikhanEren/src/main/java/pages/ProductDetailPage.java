package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends pages.BasePage {

    By addToCartButtonLocator = new By.ByCssSelector(".add-to-cart[id=pd_add_to_cart]"); //pd_add_to_cart lc için
    By addSize = By.id("option-size");
   // By addHeight = By.id("option-height");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addSize);
       // click(addHeight);
        click(addToCartButtonLocator);
    }
}
