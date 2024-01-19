package starter.ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class UiStepDefinitions {

    @Steps
    ProductSteps productSteps;

    @Given("Открыт сайт {string}.")
    public void openWebsite(String url) {
        productSteps.openWebsite(url);
    }

    @When("Я авторизуюсь под {string}.")
    public void logInBy(String login) {
        productSteps.authorize(login);
    }

    @And("Изменяю сортировку на {string}.")
    public void changeTheSorting(String sortTo) {
        productSteps.changeSorting(sortTo);
    }

    @And("Кликаю на название товара \\(карточка в левом нижнем углу).")
    public void clickOnProductName() {
        productSteps.clickOnLeftCornerProduct();
    }


    @And("Проверяю, что корзина пустая.")
    public void checkCartEmpty() { productSteps.cartIsEmpty();
    }

    @And("Кликаю на “Add to cart”.")
    public void clickOnAddToCart() {
        productSteps.addProductToCart();
    }

    @Then("Текст “Add to cart” заменяется на “Remove”.")
    public void textAddToCartReplacedWithRemove() {
        productSteps.checkButtonText();
    }

    @And("Товар успешно добавлен в корзину \\(счетчик с кол-ом товаров изменился).")
    public void productSuccessfullyAddedToTheCart() {
        productSteps.checkCounterCart();
        productSteps.checkProductOnCart();
    }

}
