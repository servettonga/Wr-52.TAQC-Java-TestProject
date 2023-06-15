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
    protected static final String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    // Dropdown Menu
    protected static final String DROPDOWN_MENU_XPATH = "//div[contains(@class, 'dropdown-menu')]";
    protected static final String USER_AVATAR_XPATH = "//div[contains(@class, 'MuiAvatar')]";
    protected static final String USERNAME_XPATH = "//p[@id='userNameAlign']";
    protected static final String MY_PROFILE_XPATH = "//button[contains(text(), 'my profile')]";
    protected static final String HELP_AND_FEEDBACK_XPATH = "//button[contains(text(), 'help and feedback')]";
    protected static final String LOG_OUT_XPATH = "//button[contains(text(), 'log out')]";
    // Login Modal
    protected static final String SIGN_IN_UP_BTN_CSS = "#headbtn";
    protected static final String LOGIN_TAB_XPATH = "(//button[@role='tab']//span[text()='Login'])[2]";
    protected static final String REGISTER_TAB_XPATH = "(//button[@role='tab']//span[text()='Register'])[2]";
    // Sign In
    protected static final String EMAIL_INP_SIGNIN_XPATH = "(//span[ . = 'Sign In']/ancestor::form//input[@name='email'])[2]";
    protected static final String PASSWORD_INP_SIGNIN_XPATH = "(//span[ . = 'Sign In']/ancestor::form//input[@name='password'])[2]";
    protected static final String SIGN_IN_UP_BTN_XPATH = "(//div[@class='MuiDialog-root'][2]//span[@class='MuiButton-label'])[2]";
    protected static final String INCORRECT_PASSWORD_AND_UNCONFIRMED_MSG_XPATH = "(//div[contains(@class, 'text-danger')])[1]";
    // Sign Up
    protected static final String EMAIL_INP_SIGNUP_XPATH = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='email'])[1]";
    protected static final String PASSWORD_INP_SIGNUP_XPATH = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='password'])[1]";
    protected static final String REPASSWORD_INP_SIGNUP_XPATH = "(//span[ . = 'Sign Up']/ancestor::form//input[@name='RepeatPassword'])[1]";
    protected static final String SUCCESS_PAGE_ALERT_TEXT_CSS = "div.alert-success";
    protected static final String UNSUCCESS_PAGE_ALERT_TEXT_XPATH = "//input[@name='password']/parent::*/following-sibling::p[contains(@class, 'Mui-error')]";

    @FindBy(css = SIGN_IN_UP_BTN_CSS)
    private WebElement signInUpButton;

    @FindBy(xpath = EMAIL_INP_SIGNIN_XPATH)
    private WebElement emailInputSignIn;

    @FindBy(xpath = EMAIL_INP_SIGNUP_XPATH)
    private WebElement emailInputSignUp;

    @FindBy(xpath = PASSWORD_INP_SIGNIN_XPATH)
    private WebElement passwordInput;

    @FindBy(xpath = PASSWORD_INP_SIGNUP_XPATH)
    private WebElement passwordInputSignUp;

    @FindBy(xpath = REPASSWORD_INP_SIGNUP_XPATH)
    private WebElement repasswordInputSignUp;

    @FindBy(xpath = SIGN_IN_UP_BTN_XPATH)
    private WebElement signInUp;

    @FindBy(xpath = INCORRECT_PASSWORD_AND_UNCONFIRMED_MSG_XPATH)
    private WebElement incorretPasswordMessage;

    @FindBy(xpath = INCORRECT_PASSWORD_AND_UNCONFIRMED_MSG_XPATH)
    private WebElement loginWithoutConfirmEmail;

    @FindBy(xpath = REGISTER_TAB_XPATH)
    private WebElement registerTab;

    @FindBy(css = SUCCESS_PAGE_ALERT_TEXT_CSS)
    private WebElement successMessage;

    @FindBy(xpath = USERNAME_XPATH)
    private WebElement username;

    @FindBy(xpath = USER_AVATAR_XPATH)
    private WebElement userAvatar;

    @FindBy(xpath = LOG_OUT_XPATH)
    private WebElement logOut;

    @FindBy(xpath = DROPDOWN_MENU_XPATH)
    private WebElement dropdownMenu;


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
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(incorretPasswordMessage));
        String currectMessage = errorMessage.getText();
        String expectedIncorrectMessage = "Incorrect login or password";
        assertThat(errorMessage.isDisplayed())
                    .withFailMessage("Incorrect login message is not displayed").isTrue();
        assertThat(currectMessage.contains(expectedIncorrectMessage) || currectMessage.contains("is not confirmed"))
                    .withFailMessage("Unexpected incorrect login message").isTrue();
        return this;
    }

    @Step("Assert that error message is displayed")
    public void assertLoginWithoutConfirmation(String message) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginWithoutConfirmEmail));
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
