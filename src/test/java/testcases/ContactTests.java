package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;

public class ContactTests extends BaseTest {
    private ContactPage contactPage;

    @BeforeMethod
    public void setupTest() {
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testAddContact() {
        contactPage.clickAddContact();
        contactPage.enterContactDetails("John Doe", "john@example.com", "1234567890");
        contactPage.submitContact();
        Assert.assertTrue(contactPage.isContactAdded("John Doe"), "Contact was not added successfully.");
    }

    @Test
    public void testDisplayContacts() {
        Assert.assertTrue(contactPage.verifyContactDisplay(), "Contacts are not displayed correctly.");
    }


    @Test
    public void testDeleteContact() {
        contactPage.deleteContact("John Doe");
        Assert.assertFalse(contactPage.isContactPresent("John Doe"), "Contact was not deleted successfully.");
    }

    @Test
    public void testLogout() {
        contactPage.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/");
    }
}
