package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Boolean.FALSE;

public class TodoSteps {
    public WebDriver driver;

    @Before
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user navigate todos page")
    public void user_navigate_todos_page() {
        driver.get("https://todomvc.com/examples/vue/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("user add {string} and hit enter")
    public void user_add_and_hit_enter(String string) {
        WebElement we = driver.findElement(By.xpath("//input[@class='new-todo']"));
        we.sendKeys(string);
        we.sendKeys(Keys.ENTER);
    }

    @Then("user should be able to see {string}")
    public void user_should_be_able_to_see(String string) {
        String eleText = driver.findElement(By.xpath("//section//ul[@class='todo-list']")).getText();
        eleText.contains(string);
    }

    @When("user delete {string}")
    public void user_delete(String string) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//section//ul[@class='todo-list']//li")));
        actions.click().build().perform();
        driver.findElement(By.xpath("//section//ul[@class='todo-list']/li[@class='todo']//button[@class='destroy']")).click();
    }

    @Then("user should not be able to see {string}")
    public void user_should_not_be_able_to_see(String string) {
        String eleText = driver.findElement(By.xpath("//section//ul[@class='todo-list']")).getText();
        Assert.assertEquals(FALSE, eleText.contains(string));
    }

    @When("user complete {string}")
    public void user_complete(String string) {
        driver.findElement(By.xpath("//section//ul[@class='todo-list']/li[@class='todo']//label[text()='" + string + "']/preceding-sibling::input")).click();
    }

    @When("user click {string} link button")
    public void user_click_link_button(String string) {
        driver.findElement(By.xpath("//footer[@class='footer']//li/a[@href=\"#/" + string + "\"]")).click();
    }

    @When("user click {string} button")
    public void user_click_button(String string) {
        driver.findElement(By.xpath("//button[contains(text(),'" + string + "')]")).click();
    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}
