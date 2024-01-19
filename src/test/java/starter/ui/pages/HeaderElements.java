package starter.ui.pages;


import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HeaderElements extends PageObject {

    public HeaderElements clickOnCart() {
        find(By.className("shopping_cart_container")).click();
        return this;
    }

    public void cartIsEmpty() {
        shouldNotBeVisible(By.className("shopping_cart_badge"));
    }

    public int getCounterNumber() {
        return Integer.parseInt(find(By.className("shopping_cart_container")).find(By.className("shopping_cart_badge")).getText());
    }

}
