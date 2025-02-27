package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void testValidLogin() {
        setup();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("valid@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/contact-list");
        teardown();
    }

    @Test
    public void testInvalidLogin() {
        setup();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("invalid@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid email or password"));
        teardown();
    }
}
