package stepDefinitions;

import PageObject.PageObject_Base;
import PageObject.webpage_PO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;
import java.util.Random;


public class web_page extends PageObject_Base {

    private webpage_PO webpage_po;
    public web_page(webpage_PO webpage_po) {
        this.webpage_po = webpage_po;
    }
    private WebDriver driver = getDriver();




    @Given("I access the veeam career page")
    public void i_access_the_veeam_career_page() {
        webpage_po.navigateTo_VEEAM_Career_Page();
    }


     @When("The URL is mapped to {string}")
     public void the_url_is_mapped_to(String string) {
        System.out.println("Connected via browser to carrier link");
    }

    @And("Disable Cookie PopUp")
    public void disable_cookie_pop_up() {

        webpage_po.accept_cookies();
    }
    @And("Click on All Departments combobox and check Research & Development")
    public void click_on_all_departments_combobox_and_check_research_development() {

        webpage_po.select_category();
        System.out.println("Pick Research & Development from dropdown menu");
    }
    @And("Click on All languages combobox and check English")
    public void click_on_all_languages_combobox_and_check_english() {

        webpage_po.select_language();
        System.out.println("English is selected from dropbox");
    }

    @And("I find the open vacancies and count them")
    public void i_find_the_open_vacancies_and_count_them() {
        webpage_po.VerifyVacancyNumber();
    }

    @When("I count open vacancies and verify with number on carrier page")
    public void i_count_open_vacancies_and_verify_with_number_on_carrier_page() {
        webpage_po.VerifyVacancyNumberwithWebSiteData();
        System.out.println("Count number of jobs & given number of 'Vacancies open' are expected to be not equal");
    }

    @When("Click All Departments combobox and pick any department")
    public void click_all_departments_combobox_and_pick_any_department() {


        webpage_po.waitForWebElementAndClick(By.xpath("//button[contains(text(),'All departments')]"));
        int size_dep = driver.findElements(By.xpath("//*[@class='dropdown-item']")).size();
        int rnd_dep = (int) (Math.random()*(size_dep-1)+2);
        webpage_po.waitForWebElementAndClick(By.xpath("//*[@id='root']/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/a["+rnd_dep+"]"));

        webpage_po.waitForWebElementAndClick(By.xpath("//button[contains(text(),'All languages')]"));
        int size_lan = driver.findElements(By.xpath("//*[@class='custom-control-label']")).size();
        int rnd_lan = (int) (Math.random()*(size_lan));
        webpage_po.waitForWebElementAndClick(By.xpath("//*[@for='lang-option-"+rnd_lan+"']"));
    }


    @Then("Terminate test case")
    public void terminate_test_case() {
        System.out.println("This case terminated");
    }
    @After
    public void teardown(){
        driver.quit();
    }

}
