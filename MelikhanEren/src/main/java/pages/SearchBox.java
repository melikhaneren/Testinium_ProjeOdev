package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class SearchBox extends pages.BasePage {

    By searchBoxLocator = By.id("search_input");
    By submitButtonLocator = new By.ByCssSelector("button.searchButton");
    By seeMore = new By.ByCssSelector("p.lazy-load-text");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        click(searchBoxLocator);
        type(searchBoxLocator , text);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        click(submitButtonLocator);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void ScrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        click(seeMore);
    }
}
