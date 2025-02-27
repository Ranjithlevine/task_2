package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTest extends BaseTest {
    private SignupPage signupPage;

    @Test
    public void testSignup() {
        setup();
        signupPage = new SignupPage(driver);
        signupPage.clickSignupButton();
        signupPage.enterUserDetails("testuser", "test@example.com", "password123");
        signupPage.submitSignup();
        Assert.assertTrue(signupPage.isSignupSuccessful());
        teardown();
    }
}
