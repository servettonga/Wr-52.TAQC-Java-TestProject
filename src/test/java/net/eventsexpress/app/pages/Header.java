package net.eventsexpress.app.pages;

import net.eventsexpress.app.base.Base;
import net.eventsexpress.app.utils.Utils;

public class Header {
    protected static String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    protected static String LOG_OUT_XPATH = "//button[contains(text(), 'log out')]";
    protected static String USERNAME_XPATH = "//p[@id='userNameAlign']";
    protected static String MY_PROFILE_XPATH = "//button[contains(text(), 'my profile')]";
    protected static String HELP_AND_FEEDBACK_XPATH = "//button[contains(text(), 'help and feedback')]";
    protected static String DROPDOWN_MENU_XPATH = "//div[contains(@class, 'dropdown-menu')]";
    protected static String USER_AVATAR_XPATH = "//div[contains(@class, 'MuiAvatar')]";
    // Login Modal
    protected static String SIGN_IN_UP_BTN_CSS = "#headbtn";
    protected static String MODAL_DIALOG_XPATH = "//div[@class='MuiDialog-root'][2]";
    protected static String LOGIN_TAB_XPATH = "(//button[@role='tab']//span[text()='Login'])[2]";
    protected static String REGISTER_TAB_XPATH = "(//button[@role='tab']//span[text()='Register'])[2]";
    protected static String EMAIL_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='email']";
    protected static String PASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='password']";
    protected static String REPASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='RepeatPassword']";
    protected static String SIGN_IN_UP_BTN_XPATH = "(//div[@class='MuiDialog-root'][2]//span[@class='MuiButton-label'])[2]";
    protected static String SUCCESS_PAGE_ALERT_TEXT_CSS = "div.alert-success";
    protected static String UNSUCCESS_PAGE_ALERT_TEXT_XPATH = "//input[@name='password']/parent::*/following-sibling::p[contains(@class, 'Mui-error')]";
    protected static String INCORRECT_PASSWORD_XPATH = "(//div[contains(@class, 'text-danger')])[1]";

    public static void login(String email, String password) {
        assertUserNotLoggedIn();
        Base.findElementByCSS(SIGN_IN_UP_BTN_CSS).click();
        Base.findElementByXpath(EMAIL_INP_XPATH).sendKeys(email);
        Base.findElementByXpath(PASSWORD_INP_XPATH).sendKeys(password);
        Base.findElementByXpath(SIGN_IN_UP_BTN_XPATH).click();
    }

    public static void register(String email, String password) {
        Base.findElementByCSS(SIGN_IN_UP_BTN_CSS).click();
        Base.findElementByXpath(REGISTER_TAB_XPATH).click();
        Base.findElementByXpath(EMAIL_INP_XPATH).sendKeys(email);
        Base.findElementByXpath(PASSWORD_INP_XPATH).sendKeys(password);
        Base.findElementByXpath(REPASSWORD_INP_XPATH).sendKeys(password);
        Base.findElementByXpath(SIGN_IN_UP_BTN_XPATH).click();
        Utils.sleep(1000);
    }

    public static void assertRegistrationSuccess(String message) {
        assert Base.findElementByCSS(SUCCESS_PAGE_ALERT_TEXT_CSS).getText() == message
                : "Registration is not successful";
    }

    public static void logOut() {
        if (isUserLoggedIn()) {
            Base.findElementByXpath(USERNAME_XPATH).click();
            Base.findElementByXpath(LOG_OUT_XPATH).click();
        }
    }

    public static String getUsername() {
        return Base.findElementByXpath(USERNAME_XPATH).getText();
    }

    private static boolean isUserLoggedIn() {
        try {
            Base.findElementByXpath(USER_AVATAR_XPATH);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }

    public static void assertUserLoggedIn() {
        assert isUserLoggedIn() : "User is not logged in";
    }

    public static void assertUserNotLoggedIn() {
        assert !isUserLoggedIn() : "User is logged in";
    }

    public static void clickDropdownMenu() {
        Base.findElementByXpath(USER_AVATAR_XPATH).click();
    }

    public static void assertDropdownMenuDisplayed() {
        assert Base.findElementByXpath(DROPDOWN_MENU_XPATH).getAttribute("class").contains("show");
    }
}
