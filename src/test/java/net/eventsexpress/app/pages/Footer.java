package net.eventsexpress.app.pages;

import net.eventsexpress.app.driver.DriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
    protected static final String FOOTER_XPATH = "//div[@class='links-to-pages']";
    protected static final String PRIVACY_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/privacy']";
    protected static final String TERMS_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/terms']";
    protected static final String ABOUT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/about']";
    protected static final String CONTACT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/contactAdmin']";
    protected static final String FACEBOOK_LINK_XPATH = "//i[contains(@class,'facebook')]/parent::*/@href";
    protected static final String INSTAGRAM_LINK_XPATH = "//i[contains(@class,'instagram')]/parent::*/@href";
    protected static final String YOUTUBE_LINK_XPATH = "//i[contains(@class,'youtube')]/parent::*/@href";

    @FindBy(xpath = PRIVACY_LINK_XPATH)
    private WebElement privacyPageLink;

    @FindBy(xpath= ABOUT_LINK_XPATH)
    private WebElement aboutPageLink;

    public Footer() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public Footer navigateToPrivacyPage() {
        privacyPageLink.click();
        return this;
    }

    public Footer navigateToAboutPage(){
        aboutPageLink.click();
        return this;
    }

}
