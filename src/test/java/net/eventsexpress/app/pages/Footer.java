package net.eventsexpress.app.pages;

import net.eventsexpress.app.base.Base;

public class Footer {
    protected static String FOOTER_XPATH = "//div[@class='links-to-pages']";
    protected static String PRIVACY_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/privacy']";
    protected static String TERMS_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/terms']";
    protected static String ABOUT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/about']";
    protected static String CONTACT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/contactAdmin']";
    protected static String FACEBOOK_LINK_XPATH = "//i[contains(@class,'facebook')]/parent::*/@href";
    protected static String INSTAGRAM_LINK_XPATH = "//i[contains(@class,'instagram')]/parent::*/@href";
    protected static String YOUTUBE_LINK_XPATH = "//i[contains(@class,'youtube')]/parent::*/@href";

    public void scrollToFooter() {
        Base.scrollToElementXpath(FOOTER_XPATH);
    }

}
