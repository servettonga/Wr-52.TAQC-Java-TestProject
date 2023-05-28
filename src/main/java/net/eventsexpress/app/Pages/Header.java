package net.eventsexpress.app.Pages;

import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Common.BaseWrapper;

public class Header extends BaseWrapper{
    String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    String SIGN_IN_UP_BTN_CSS = "#headbtn";
    String LOG_OUT_XPATH = "//button[contains(text(), 'log out')]";
    String USERNAME_XPATH = "//p[@id='userNameAlign']";
    String MY_PROFILE_XPATH = "//button[contains(text(), 'my profile')]";
    String HELP_AND_FEEDBACK_XPATH = "//button[contains(text(), 'help and feedback')]";
    String DROPDOWN_MENU_XPATH = "//div[contains(@class, 'dropdown-menu')]";
    String USER_AVATAR_XPATH = "//div[contains(@class, 'MuiAvatar')]";

    public Header(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        findElementByXpath(LOG_OUT_XPATH).click();
    }

    public String getUsername() {
        return findElementByXpath(USERNAME_XPATH).getText();
    }

    public boolean isUserLoggedIn() {
        return findElementByXpath(USERNAME_XPATH).isDisplayed();
    }

    public void clickDropdownMenu() {
        findElementByXpath(USER_AVATAR_XPATH).click();
    }

    public boolean isDropdownMenuDisplayed() {
        return findElementByXpath(DROPDOWN_MENU_XPATH).getAttribute("class").contains("show");
    }
}
