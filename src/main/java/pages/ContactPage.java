package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ContactPage {
    private WebDriver driver;

    @FindBy(id = "add-contact")
    private WebElement addContactButton;

    @FindBy(id = "name")
    private WebElement contactName;

    @FindBy(id = "email")
    private WebElement contactEmail;

    @FindBy(id = "phone")
    private WebElement contactPhone;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='contact-name']")
    private List<WebElement> contactNames;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddContact() {
        addContactButton.click();
    }

    public void enterContactDetails(String name, String email, String phone) {
        contactName.sendKeys(name);
        contactEmail.sendKeys(email);
        contactPhone.sendKeys(phone);
    }

    public void submitContact() {
        submitButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public boolean isContactAdded(String name) {
        for (WebElement contact : contactNames) {
            if (contact.getText().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContactPresent(String name) {
        List<WebElement> contacts = driver.findElements(By.xpath("//td[contains(text(),'" + name + "')]"));
        return !contacts.isEmpty();
    }


    public boolean verifyContactDisplay() {
        return !contactNames.isEmpty(); // Returns true if at least one contact is displayed
    }

    // ✅ New method to delete a contact
    public void deleteContact(String name) {
        for (WebElement contact : contactNames) {
            if (contact.getText().equalsIgnoreCase(name)) {
                contact.findElement(By.xpath(".//following-sibling::button[contains(text(),'Delete')]")).click();
                driver.switchTo().alert().accept(); // Handle alert popup
                break;
            }
        }
    }
}
