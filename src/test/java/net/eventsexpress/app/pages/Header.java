package net.eventsexpress.app.pages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.utils.User;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Header extends BasePage {

    @FindBy(css = "#EEButton")
    private WebElement eventExpressLogo;

    // Dropdown Menu
    @FindBy(xpath = "//div[contains(@class, 'dropdown-menu')]")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//div[contains(@class, 'MuiAvatar')]")
    private WebElement userAvatar;

    @FindBy(xpath = "//p[@id='userNameAlign']")
    private WebElement username;

    @FindBy(xpath = "//button[contains(text(), 'log out')]")
    private WebElement logOut;

    @FindBy(xpath = "//button[contains(text(), 'my profile')]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//button[contains(text(), 'help and feedback')]")
    private WebElement helpAndFeedback;

    // Login Modal
    @FindBy(css = "#headbtn")
    private WebElement signInUpButton;

    @FindBy(xpath = "(//button[@role='tab']//span[text()='Login'])[2]")
    private WebElement loginTab;

    @FindBy(xpath = "(//button[@role='tab']//span[text()='Register'])[2]")
    private WebElement registerTab;

    // Sign In
    @FindBy(xpath = "(//span[ . = 'Sign In']/ancestor::form//input[@name='email'])[2]")
    private WebElement emailInputSignIn;

    @FindBy(xpath = "(//span[ . = 'Sign In']/ancestor::form//input[@name='password'])[2]")
    private WebElement passwordInput;

    @FindBy(xpath = "(//div[@class='MuiDialog-root'][2]//span[@class='MuiButton-label'])[2]")
    private WebElement signInUp;

    @FindBy(xpath = "(//div[contains(@class, 'text-danger')])[1]")
    private WebElement incorrectLoginMessage;

    // Sign Up
    @FindBy(xpath = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='email'])[1]")
    private WebElement emailInputSignUp;

    @FindBy(xpath = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='password'])[1]")
    private WebElement passwordInputSignUp;

    @FindBy(xpath = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='RepeatPassword'])[1]")
    private WebElement repasswordInputSignUp;

    @FindBy(css = "div.alert-success")
    private WebElement successMessage;


    @Step("Click on Sign In/Up button and login")
    public Header login(User user) {
        signInUpButton.click();
        emailInputSignIn.sendKeys(user.username());
        passwordInput.sendKeys(user.password());
        signInUp.click();
        return this;
    }

    @Step("Assert that user is logged in")
    public Header assertUserLoggedIn() {
        boolean avatarExists = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(userAvatar)).isDisplayed();
        } catch (TimeoutException e) {
            avatarExists = false;
        }
        assertThat(avatarExists).withFailMessage("User is not logged in").isTrue();
        return this;
    }

    @Step("Assert that user is not logged in")
    public Header assertIncorrectLogin() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(incorrectLoginMessage));
        String currentMessage = errorMessage.getText();
        String expectedIncorrectMessage = "Incorrect login or password";
        assertThat(errorMessage.isDisplayed())
                    .withFailMessage("Incorrect login message is not displayed").isTrue();
        assertThat(currentMessage.contains(expectedIncorrectMessage) || currentMessage.contains("is not confirmed"))
                    .withFailMessage("Unexpected incorrect login message").isTrue();
        return this;
    }

    @Step("Assert that error message is displayed")
    public void assertLoginWithoutConfirmation(String message) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(incorrectLoginMessage));
        assertThat(errorMessage.isDisplayed())
                    .withFailMessage("Element with message is not found").isTrue();
        assertThat(errorMessage.getText().contains(message)).withFailMessage("Error message is not correct").isTrue();
    }

    @Step("Logout user if already logged in")
    public Header logOut() {
        assertUserLoggedIn();
        username.click();
        logOut.click();
        return this;
    }

    @Step("Click on Sign In/Up button and register")
    public Header register(User user) {
        signInUpButton.click();
        registerTab.click();
        emailInputSignUp.sendKeys(user.username());
        passwordInputSignUp.sendKeys(user.password());
        repasswordInputSignUp.sendKeys(user.password());
        signInUp.click();
        return this;
    }

    @Step("Assert registration success")
    public Header assertRegistrationSuccess(String message) {
        WebElement currentMessage = wait.until(ExpectedConditions.visibilityOf(successMessage));
        assertThat(currentMessage.isDisplayed())
                    .withFailMessage("Success message is not displayed").isTrue();
        assertThat(currentMessage.getText().contains(message))
                    .withFailMessage("Success message is not correct").isTrue();
        return this;
    }

    @Step("Assert that dropdown menu is displayed")
    public Header assertDropdownMenuDisplayed() {
        assertThat(dropdownMenu.getAttribute("class").contains("show"))
                    .withFailMessage("Dropdown menu is not displayed").isTrue();
        return this;
    }

}
