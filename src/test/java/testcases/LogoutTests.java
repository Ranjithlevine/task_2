package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;

public class LogoutTests extends BaseTest {
    private ContactPage contactPage;

    @Test
    public void testLogout() {
        setup();
        contactPage = new ContactPage(driver);
        contactPage.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/");
        teardown();
    }
}
