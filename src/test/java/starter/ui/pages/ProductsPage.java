package starter.ui.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {

    public WebElementFacade productsForm() {
        return find(By.id("inventory_container"));
    }

    public void changeSorting(String sort) {
        find(By.className("product_sort_container")).selectByVisibleText(sort);
    }

    public ListOfWebElementFacades getItems() {
        return find(By.id("inventory_container")).thenFindAll(By.className("inventory_item"));
    }

    public ProductsPage clickOnProductByIndex(int index) {
        getItems().get(index).find(By.className("inventory_item_name")).click();
        return this;
    }
}
