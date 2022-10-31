package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodoPage {
    @FindBy(xpath = "//input[@class='new-todo']")
    public WebElement txtTodo;
    @FindBy(xpath = "//section//ul[@class='todo-list']")
    public WebElement todoList;
    @FindBy(xpath = "//section//ul[@class='todo-list']//li")
    public WebElement todoListItem;
    @FindBy(xpath = "//section//ul[@class='todo-list']/li[@class='todo']//button[@class='destroy']")
    public WebElement btnDelete;
    WebDriver driver;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
