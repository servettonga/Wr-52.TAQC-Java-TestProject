package net.eventsexpress.app.Pages;

import net.eventsexpress.app.common.BaseWrapper;
import org.testng.Assert;

public class Header extends BaseWrapper {
    private static final String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    private static final String SIGN_IN_UP_BTN_CSS = "#headbtn";
    private static final String LOG_OUT_XPATH = "//button[contains(text(), 'log out')]";
    private static final String USERNAME_XPATH = "//p[@id='userNameAlign']";
    private static final String MY_PROFILE_XPATH = "//button[contains(text(), 'my profile')]";
    private static final String HELP_AND_FEEDBACK_XPATH = "//button[contains(text(), 'help and feedback')]";
    private static final String DROPDOWN_MENU_XPATH = "//div[contains(@class, 'dropdown-menu')]";
    private static final String USER_AVATAR_XPATH = "//div[contains(@class, 'MuiAvatar')]";

    public Header() {
        super();
    }

    public void logOut() {
        findElementByXpath(LOG_OUT_XPATH).click();
    }

    public String getUsername() {
        return findElementByXpath(USERNAME_XPATH).getText();
    }

    public boolean isUserLoggedIn() {
        try {
            findElementByXpath(USER_AVATAR_XPATH);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }

    public void clickDropdownMenu() {
        findElementByXpath(USER_AVATAR_XPATH).click();
    }

    public boolean isDropdownMenuDisplayed() {
        return findElementByXpath(DROPDOWN_MENU_XPATH).getAttribute("class").contains("show");
    }

    public void assertUserLoggedIn() {
        Assert.assertTrue(isUserLoggedIn());
    }
}
