package net.eventsexpress.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.pages.footerpages.AboutPage;
import net.eventsexpress.app.pages.footerpages.PrivacyPage;
import net.eventsexpress.app.pages.footerpages.TermsPage;


public class Footer extends BasePage {
    protected static final String FOOTER_XPATH = "//footer";
    protected static final String PRIVACY_LINK_XPATH = "//footer//a[@href='/privacy']";
    protected static final String TERMS_LINK_XPATH = "//footer//a[@href='/terms']";
    protected static final String ABOUT_LINK_XPATH = "//footer//a[@href='/about']";
    protected static final String CONTACT_LINK_XPATH = "//footer//a[@href='/contactAdmin']";
    protected static final String FACEBOOK_LINK_XPATH =
            "//i[contains(@class,'facebook')]/parent::*/@href";
    protected static final String INSTAGRAM_LINK_XPATH =
            "//i[contains(@class,'instagram')]/parent::*/@href";
    protected static final String YOUTUBE_LINK_XPATH =
            "//i[contains(@class,'youtube')]/parent::*/@href";

    @FindBy(xpath = PRIVACY_LINK_XPATH)
    private WebElement privacyPageLink;

    @FindBy(xpath = ABOUT_LINK_XPATH)
    private WebElement aboutPageLink;

    @FindBy(xpath = TERMS_LINK_XPATH)
    private WebElement termsPageLink;


    @Step("Click on Privacy link")
    public PrivacyPage navigateToPrivacyPage() {
        privacyPageLink.click();
        return new PrivacyPage();
    }

    @Step("Click on About link")
    public AboutPage navigateToAboutPage() {
        aboutPageLink.click();
        return new AboutPage();
    }

    private boolean isTermsLinkDisplayed() {
        try {
            return termsPageLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click on Terms link")
    public TermsPage clickTermsLink() {
        if (termsPageLink.isEnabled() && isTermsLinkDisplayed()) {
            termsPageLink.click();
            return new TermsPage();
        } else {
            throw new NoSuchElementException("Terms link is not displayed or enabled");
        }
    }

}
