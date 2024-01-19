package starter.api.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ApiStepDefinitions {

    RequestSpecification specification;

    Map<String, String> body;

    @Given("URL {string} path {string}")
    public void givenUrl(String url, String path) {
        specification = given().baseUri(url).basePath(path);
    }

    @When("Я дергаю метод GET с параметром {string}")
    public void whenRequestGet(String params) {
        when().get(params);
    }

    @Then("Возвращается Status code {int}")
    public void checkStatusCode(int code) {
        then().statusCode(code);
    }

    @And("В ответе в объекте data есть {string} со значением {string}")
    public void checkParamOnDataObject(String key, String value) {
        then().body("data." + key, Matchers.hasItem(value));
    }

    @And("В ответе есть {string} со значением {}")
    public void checkParam(String key, String value) {
        then().body(key, Matchers.hasToString(value));
    }

    @When("Я дергаю метод POST c request body \\(name:рандомно сгенерированное значение, job:рандомно сгенерированное значение)")
    public void whenRequestPost() {
        body = Map.of("name", randomAlphabetic(6), "job", randomAlphabetic(10));
        specification.body(body).contentType(ContentType.JSON).post();
    }

    @And("В ответе есть {string} с рандомно сгенерированным значением")
    public void thenChecking(String key) {
        then().body(key, Matchers.equalTo(body.get(key)));
    }
}
