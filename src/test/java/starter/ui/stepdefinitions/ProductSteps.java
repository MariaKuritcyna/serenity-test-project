package starter.ui.stepdefinitions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.junit.Assert;
import starter.ui.pages.*;

public class ProductSteps extends UIInteractions {

    AuthorizedPage authorizedPage;
    ProductsPage productsPage;
    ProductCardPage productCardPage;
    HeaderElements headerElements;
    CartPage cartPage;

    @Step
    public void openWebsite(String url) {
        openUrl(url);
    }

    @Step
    public void authorize(String login) {
        authorizedPage.setLogin(login).setPassword("secret_sauce").clickLogin();
    }

    @Step
    public void changeSorting(String sort) {
        productsPage.productsForm().shouldBeVisible();
        productsPage.changeSorting(sort);
    }

    @Step
    public void clickOnLeftCornerProduct() {
        int size = productsPage.getItems().size();
        if (size % 2 == 0) {
            productsPage.clickOnProductByIndex(size - 2);
        } else {
            productsPage.clickOnProductByIndex(size - 1);
        }
    }

    @Step
    public void addProductToCart() {
        productCardPage.productCardForm().shouldBeVisible();
        productCardPage.clickButtonAddToCart();
    }

    @Step
    public void cartIsEmpty() {
        headerElements.cartIsEmpty();
    }

    @Step
    public void checkButtonText() {
        productCardPage.getButton().shouldContainOnlyText("Remove");
    }

    @Step
    public void checkCounterCart() {
        Assert.assertEquals("Количество товаров не верно", headerElements.getCounterNumber(), 1);
    }

    @Step
    public void checkProductOnCart() {
        headerElements.clickOnCart();
        cartPage.cartForm().shouldBeVisible();
        Assert.assertEquals("Количество товаров не верно", cartPage.getCountProductInCart(), 1);
    }
}
