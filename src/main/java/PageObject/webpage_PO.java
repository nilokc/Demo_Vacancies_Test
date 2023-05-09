package PageObject;

import driver.DriverBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Global_Vars;

import java.util.List;
import java.util.Random;

import static io.cucumber.messages.internal.com.fasterxml.jackson.core.io.NumberInput.parseInt;

public class webpage_PO extends PageObject_Base {

    private @FindBy(css = "#cookiescript_accept")
    WebElement cookie_button;

    //private @FindBy(id = "sl")
    private @FindBy(id = "sl")
    WebElement category_dropbox;

    private @FindBy(linkText = "Research & Development")
    WebElement category;

    private @FindBy(xpath = "//button[contains(text(),'All languages')]")
    WebElement Languages;

    private @FindBy(xpath = "//label[contains(text(),'English')]")
    WebElement English;

    private @FindBy(css = "[class='text-secondary pl-2']")
    WebElement OpenVacancyNumber;

    private @FindBy(xpath = "//*[text()='Research & Development']")
    List<WebElement> jobs;

    private @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/a")
    List<WebElement> open_jobs;

    private @FindBy(xpath = "//*[@id='sl']")
    List<WebElement> dropdown_category_list;

    private @FindBy(xpath = "//button[contains(text(),'All departments')]")
    WebElement button_AllDepartments;

    private @FindBy(xpath = "//*[@class='dropdown-item']")
    WebElement dropdown_Items;

    public webpage_PO() { super(); }
    public void navigateTo_VEEAM_Career_Page() {
        navigateTo_URL(Global_Vars.JOBS_HOMEPAGE_URL);
    }

    public void accept_cookies() {
        waitForWebElementAndClick(cookie_button);
    }

    public void select_category() {
        waitForWebElementAndClick(category_dropbox);
        waitForWebElementAndClick(category);
    }

    public void VerifyVacancyNumber()
    {
        Assert.assertEquals(open_jobs.size(),10);
        System.out.print("Test passes if Open vacancies are verified with actual number: " +open_jobs.size());
    }

    public void VerifyVacancyNumberwithWebSiteData()
    {
        System.out.println("This case is for comparing open jobs number (which is filtered) with the data written on webpage -Vacancies Open for all departments and languages" + '\n' + "Vacancies Open :" +parseInt(OpenVacancyNumber.getText()));
        Assert.assertNotEquals(open_jobs.size(),parseInt(OpenVacancyNumber.getText()));
    }


    public void select_language() {
        waitForWebElementAndClick(Languages);
        waitForWebElementAndClick(English);
    }

    public void clickon_alldepartments() {
        waitForWebElementAndClick(button_AllDepartments);
    }

    public void clickon_languageButton() {
        waitForWebElementAndClick(Languages);
    }
}
