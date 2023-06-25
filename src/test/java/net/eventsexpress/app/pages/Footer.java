package net.eventsexpress.app.pages;

import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.pages.footerpages.AboutPage;
import net.eventsexpress.app.pages.footerpages.PrivacyPage;
import net.eventsexpress.app.pages.footerpages.TermsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Footer extends BasePage {

    @FindBy(xpath = "//footer//a[@href='/privacy']")
    private WebElement privacyPageLink;

    @FindBy(xpath = "//footer//a[@href='/about']")
    private WebElement aboutPageLink;

    @FindBy(xpath = "//footer//a[@href='/terms']")
    private WebElement termsPageLink;

    @FindBy(xpath = "//footer//a[@href='/contactAdmin']")
    private WebElement contactPageLink;

    @FindBy(xpath = "//i[contains(@class,'facebook')]/parent::*/@href")
    private WebElement facebookPageLink;

    @FindBy(xpath = "//i[contains(@class,'instagram')]/parent::*/@href")
    private WebElement instagramPageLink;

    @FindBy(xpath = "//i[contains(@class,'youtube')]/parent::*/@href")
    private WebElement youtubePageLink;


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
