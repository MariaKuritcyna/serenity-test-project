package starter.ui.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    public WebElementFacade cartForm() {
        return find(By.id("cart_contents_container"));
    }

    public int getCountProductInCart() {
        ListOfWebElementFacades cartItems = find(By.className("cart_list")).thenFindAll(By.className("cart_item"));
        return cartItems.size();
    }
}
