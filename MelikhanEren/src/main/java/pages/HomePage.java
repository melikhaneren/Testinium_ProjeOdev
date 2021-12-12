package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class HomePage extends pages.BasePage {

    SearchBox searchBox ;
    By priceLocator = new By.ByCssSelector("span.price");
    By cartContainerLocator = new By.ByCssSelector(".header-bag-icon");
    By acceptCookiesLocator = new By.ByCssSelector(".cookie__dismiss");
    By deleteProduct = new By.ByCssSelector(".cart-square-link[title=Sil]");
    By addProduct = new By.ByCssSelector("a.oq-up.plus");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    public void addTheProduct() {

        click(addProduct);
    }

    public void deleteTheProduct() {

        click(deleteProduct);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    private int getCartCount(){

        String count = find(priceLocator).getText();
        System.out.println(count);
        return Integer.parseInt(count);

    }

    public void acceptCookies(){
            click(acceptCookiesLocator);
    }
}
