package autoam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page {
    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchField;
    @FindBy(name = "btnK")
    WebElement searchButton;

    @FindBy(css = "a[href='https://auto.am/']")
    WebElement autoAmLink;


    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchInput(String input) {
        searchField.sendKeys(input);
    }

    public void searchClick() {
        searchButton.click();
    }

    public void autoAmLinkClick() {
        autoAmLink.click();
    }



}
class AutoAmPage {
    WebDriver driver;
    @FindBy(id = "filter-make")
    WebElement mark;

    @FindBy(id = "v-model")
    WebElement model;

    @FindBy(name = "year[gt]")
    WebElement year;

    @FindBy(className = "lever")
    WebElement customsCleared;

    @FindBy(id = "search-btn")
    WebElement searchBtn;

    @FindBy(id = "research-btn")
    WebElement quantity;

    @FindBy(css = "#ad-2732552 > div.card-action > div > span")
    WebElement price;

    public AutoAmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAutoAmPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title, "Title not match!!!");
    }

    public void selectMark(String mark_) {
        Select marks = new Select(mark);
        marks.selectByVisibleText(mark_);
    }

    public void selectModel(String model_) {
        Select models = new Select(model);
        models.selectByVisibleText(model_);
    }

    public void selectYear(String year_) {
        Select years = new Select(year);
        years.selectByValue(year_);
    }

    public void customClearedClick() {
        if (customsCleared.isSelected() == false) {
            customsCleared.click();
        }
    }

    public void searchBtnClick() {
        searchBtn.click();
    }

    public void checkQuantity(String quantity_) {
        Assert.assertEquals(quantity.getText(), quantity_, "Wrong quantity");
    }

    public void checkPrice(String price_) {
        Assert.assertEquals(price.getText(), price_, "Wrong price");
    }


}