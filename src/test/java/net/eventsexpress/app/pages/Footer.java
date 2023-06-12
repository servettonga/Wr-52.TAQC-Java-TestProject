package net.eventsexpress.app.pages;

import net.eventsexpress.app.driver.DriverManager;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class Footer {
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

    public Footer() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @Step("Click on Privacy link")
    public Footer navigateToPrivacyPage() {
        privacyPageLink.click();
        return this;
    }

    @Step("Click on About link")
    public Footer navigateToAboutPage() {
        aboutPageLink.click();
        return this;
    }

    public boolean isTermsLinkDisplayed() {
        try {
            return termsPageLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickTermsLink() {
        if (termsPageLink.isEnabled() && isTermsLinkDisplayed()) {
            termsPageLink.click();
        } else {
            throw new NoSuchElementException("Terms link is not displayed or enabled");
        }
    }
}
