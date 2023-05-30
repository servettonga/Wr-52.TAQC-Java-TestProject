package net.eventsexpress.app.pages;

import net.eventsexpress.app.base.Base;

public class Footer {
    String FOOTER_XPATH = "//div[@class='links-to-pages']";
    String PRIVACY_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/privacy']";
    String TERMS_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/terms']";
    String ABOUT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/about']";
    String CONTACT_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/contactAdmin']";
    String FACEBOOK_LINK_XPATH = "//i[contains(@class,'facebook')]/parent::*/@href";
    String INSTAGRAM_LINK_XPATH = "//i[contains(@class,'instagram')]/parent::*/@href";
    String YOUTUBE_LINK_XPATH = "//i[contains(@class,'youtube')]/parent::*/@href";

    public void scrollToFooter() {
        Base.scrollToElementXpath(FOOTER_XPATH);
    }

}
