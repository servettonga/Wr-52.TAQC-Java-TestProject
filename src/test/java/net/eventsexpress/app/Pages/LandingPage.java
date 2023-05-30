package net.eventsexpress.app.Pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.eventsexpress.app.common.BaseWrapper;

public class LandingPage extends BaseWrapper {
    // Hero
    String CREATE_EVENT_BTN_XPATH = "//button[contains(text(), 'Create event')]";
    String FIND_EVENT_BTN_XPATH = "//a[text()='Find event']";
    String JOIN_EVENTSEXPRESS_BTN_XPATH = "//button[text()='Join EventsExpress']";
    // Upcoming Events
    String JOIN_EVENT_BTN_XPATH = "//a[text()='Join event']";
    String EXPlORE_MORE_EVENTS_BTN_XPATH = "//a[text()='Explore more events']";
    // UI
    String BACKGROUND_IMAGE_CSS = "article[style~='background-image:']";
    // Login Modal
    String SIGN_IN_UP_BTN_CSS = "#headbtn";
    String MODAL_DIALOG_XPATH = "//div[@class='MuiDialog-root'][2]";
    String LOGIN_TAB_XPATH = "(//button[@role='tab']//span[text()='Login'])[2]";
    String REGISTER_TAB_XPATH = "(//button[@role='tab']//span[text()='Register'])[2]";
    String EMAIL_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='email']";
    String PASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='password']";
    String REPASSWORD_INP_XPATH = MODAL_DIALOG_XPATH + "//input[@name='RepeatPassword']";
    String SIGN_IN_UP_BTN_XPATH = "(//div[@class='MuiDialog-root'][2]//span[@class='MuiButton-label'])[2]";
    String SUCCESS_PAGE_ALERT_TEXT_CSS = "div.alert-success";
    String UNSUCCESS_PAGE_ALERT_TEXT_XPATH = "//input[@name='password']/parent::*/following-sibling::p[contains(@class, 'Mui-error')]";
    String INCORRECT_PASSWORD_XPATH = "(//div[contains(@class, 'text-danger')])[1]";

    public LandingPage() {
    }

    public String login(String email, String password) {
        findElementByCSS(SIGN_IN_UP_BTN_CSS).click();
        findElementByXpath(EMAIL_INP_XPATH).sendKeys(email);
        findElementByXpath(PASSWORD_INP_XPATH).sendKeys(password);
        findElementByXpath(SIGN_IN_UP_BTN_XPATH).click();
        try {
            return findElementByXpath(INCORRECT_PASSWORD_XPATH).getText();
        }
        catch (RuntimeException ex) {
            return "Logged in successfully.";
        }
    }

    public String register(String email, String password) {
        findElementByCSS(SIGN_IN_UP_BTN_CSS).click();
        findElementByXpath(REGISTER_TAB_XPATH).click();
        findElementByXpath(EMAIL_INP_XPATH).sendKeys(email);
        findElementByXpath(PASSWORD_INP_XPATH).sendKeys(password);
        findElementByXpath(REPASSWORD_INP_XPATH).sendKeys(password);
        findElementByXpath(SIGN_IN_UP_BTN_XPATH).click();
        return findElementByCSS(SUCCESS_PAGE_ALERT_TEXT_CSS).getText();
    }

    public String getBackgroundImage() {
        Pattern pattern = Pattern.compile("\\/([^\\/]+\\.jpg)");
        String input = findElementByCSS(BACKGROUND_IMAGE_CSS).getAttribute("style");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public LandingPage goTo() {
        return this;
    }
}