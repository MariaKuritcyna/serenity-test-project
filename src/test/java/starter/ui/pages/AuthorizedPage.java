package starter.ui.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class AuthorizedPage extends PageObject {

    public AuthorizedPage getLogin() {
        find(By.id("user-name"));
        return this;
    }

    public AuthorizedPage setLogin(String login) {
        find(By.id("user-name")).sendKeys(login);
        return this;
    }

    public AuthorizedPage setPassword(String password) {
        find(By.id("password")).sendKeys(password);
        return this;
    }

    public AuthorizedPage clickLogin() {
        find(By.id("login-button")).click();
        return this;
    }

}
