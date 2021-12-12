package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends pages.BasePage {

  //  Random rand = new Random();
    //By filterOptionLocator = By.id("filter-label");
    By productNameLocator = new By.ByCssSelector(".product-lazy-image");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

  /*  public boolean isOnProductPage() {
        return isDisplayed(filterOptionLocator);
    }*/

    //int product = rand.nextInt(getAllProducts().size());

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
        // getAllProducts().get(product).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

}
