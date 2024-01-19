package starter.ui.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductCardPage extends PageObject {

    public WebElementFacade productCardForm() {
        return find(By.className("inventory_details"));
    }

    public ProductCardPage clickButtonAddToCart() {
        getButton().shouldContainOnlyText("Add to cart");
        getButton().click();
        return this;
    }

    public WebElementFacade getButton() {
        return find(By.className("inventory_details_desc_container")).find(By.tagName("button"));
    }
}
