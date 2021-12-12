import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;

    @Test
    @Order(1) // koşulacak testlerin testmethodorder'a göre sıralanması
//    @Disabled("Due to BUG-123 disabled")
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("pantolan");

       /* Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!");*/
    }

    @Test
    @Order(2)
    public void  Scroll(){
        homePage = new HomePage(driver);
        homePage.searchBox().ScrollDown();
    }
    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);// içindeki integer liste sırasını veriyor. Burayı RANDOM
      /*Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");*/
    }

    @Test
    @Order(4)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        /*Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");*/
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();

       /* Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Product was not added to cart!");*/
    }

    @Test
    @Order(6)
    public void add_Product(){
        cartPage = new CartPage(driver);
        homePage.addTheProduct();
    }

    @Test
    @Order(7)
    public void delete_product(){
        cartPage = new CartPage(driver);
        homePage.deleteTheProduct();
    }
}
