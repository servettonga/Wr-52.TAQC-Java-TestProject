package net.eventsexpress.app.pages;

import java.time.Duration;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class Header {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    protected static final String LOG_OUT_XPATH = "//button[contains(text(), 'log out')]";
    protected static final String USERNAME_XPATH = "//p[@id='userNameAlign']";
    protected static final String MY_PROFILE_XPATH = "//button[contains(text(), 'my profile')]";
    protected static final String HELP_AND_FEEDBACK_XPATH = "//button[contains(text(), 'help and feedback')]";
    protected static final String DROPDOWN_MENU_XPATH = "//div[contains(@class, 'dropdown-menu')]";
    protected static final String USER_AVATAR_XPATH = "//div[contains(@class, 'MuiAvatar')]";
    // Login Modal
    protected static final String SIGN_IN_UP_BTN_CSS = "#headbtn";
    protected static final String MODAL_DIALOG_XPATH = "//div[@class='MuiDialog-root'][2]";
    protected static final String LOGIN_TAB_XPATH = "(//button[@role='tab']//span[text()='Login'])[2]";
    protected static final String REGISTER_TAB_XPATH = "(//button[@role='tab']//span[text()='Register'])[2]";
    protected static final String EMAIL_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='email']";
    protected static final String PASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='password']";
    protected static final String REPASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='RepeatPassword']";
    protected static final String SIGN_IN_UP_BTN_XPATH = "(//div[@class='MuiDialog-root'][2]//span[@class='MuiButton-label'])[2]";
    protected static final String SUCCESS_PAGE_ALERT_TEXT_CSS = "div.alert-success";
    protected static final String UNSUCCESS_PAGE_ALERT_TEXT_XPATH = "//input[@name='password']/parent::*/following-sibling::p[contains(@class, 'Mui-error')]";
    protected static final String INCORRECT_PASSWORD_XPATH = "(//div[contains(@class, 'text-danger')])[1]";

    @FindBy(css = SIGN_IN_UP_BTN_CSS)
    private WebElement signInUpButton;

    @FindBy(xpath = EMAIL_INP_XPATH)
    private WebElement emailInput;

    @FindBy(xpath = PASSWORD_INP_XPATH)
    private WebElement passwordInput;

    @FindBy(xpath = REPASSWORD_INP_XPATH)
    private WebElement passwordInputRepeat;

    @FindBy(xpath = SIGN_IN_UP_BTN_XPATH)
    private WebElement signInUp;

    @FindBy(xpath = INCORRECT_PASSWORD_XPATH)
    private WebElement incorretPasswordMessage;

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

    public Header() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @Step("Click on Sign In/Up button and login")
    public Header login(String email, String password) {
        signInUpButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInUp.click();
        return this;
    }

    @Step("Assert user is logged in")
    public Header assertUserLoggedIn() {
        boolean avatarExists = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(userAvatar)).isDisplayed();
        } catch (TimeoutException e) {
            avatarExists = false;
        }
        assert avatarExists : "User is not logged in";
        return this;
    }

    @Step("Assert user is not logged in")
    public Header assertIncorrectLogin() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(incorretPasswordMessage));
        String currectMessage = errorMessage.getText();
        String expectedIncorrectMessage = "Incorrect login or password";
        assert errorMessage.isDisplayed() : "Incorrect login message is not displayed";
        assert currectMessage.contains(expectedIncorrectMessage) || currectMessage.contains("is not confirmed")
                : "Unexpected incorrect login message";
        return this;
    }

    @Step("Logout user if already logged in")
    public Header logOut() {
        assertUserLoggedIn();
        username.click();
        logOut.click();
        return this;
    }

    @Step("Click on Sign In/Up button and register")
    public Header register(String email, String password) {
        signInUpButton.click();
        registerTab.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordInputRepeat.sendKeys(password);
        signInUp.click();
        return this;
    }

    @Step("Assert registration success")
    public Header assertRegistrationSuccess(String message) {
        WebElement currentMessage = wait.until(ExpectedConditions.visibilityOf(successMessage));
        assert currentMessage.isDisplayed() : "Success message is not displayed";
        assert currentMessage.getText().contains(message) : "Success message is not correct";
        return this;
    }

    public Header assertDropdownMenuDisplayed() {
        assert dropdownMenu.getAttribute("class").contains("show") : "Dropdown menu is not displayed";
        return this;
    }
}
