package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    private WebDriver driver;

    @FindBy(id = "signup")
    private WebElement signupButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'success-message')]") // Update XPath based on your DOM
    private WebElement successMessage;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void enterUserDetails(String name, String email, String password) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void submitSignup() {
        submitButton.click();
    }

    public boolean isSignupSuccessful() {
        return successMessage.isDisplayed(); // ✅ Fixes the issue
    }
}
