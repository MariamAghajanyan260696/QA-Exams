package practicePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page1 extends Base1 {
    WebDriver driver;

    @FindBy(css = "input[value='radio2']")
    WebElement radioButton;

    @FindBy(id = "autocomplete")
    WebElement input;

    @FindBy(id = "dropdown-class-example")
    WebElement select;

    @FindBy(id = "checkBoxOption1")
    WebElement checkBox;

    @FindBy(id = "openwindow")
    WebElement openWindowBtn;

    @FindBy(id = "opentab")
    WebElement openTabBtn;

    @FindBy(id = "name")
    WebElement inputField;

    @FindBy(id = "alertbtn")
    WebElement alertBtn;

    @FindBy(id = "confirmbtn")
    WebElement confirmBtn;

    @FindBy(css = "#product > tbody > tr:nth-child(10) > td:nth-child(2)")
    WebElement row;

    @FindBy(id = "hide-textbox")
    WebElement hideBtn;

    @FindBy(id = "displayed-text")
    WebElement textField;

    @FindBy(id = "show-textbox")
    WebElement showBtn;

    @FindBy(id = "mousehover")
    WebElement mouseHover;

    @FindBy(linkText = "Reload")
    WebElement reload;

    public Page1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getRadioBtn() {
        return radioButton;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getSelect() {
        return select;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getOpenWindowBtn() {
        return openWindowBtn;
    }

    public WebElement getOpenTabBtn() {
        return openTabBtn;
    }

    public WebElement getInputField() {
        return inputField;
    }

    public WebElement getAlertBtn() {
        return alertBtn;
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public WebElement getRow() {
        return row;
    }

    public WebElement getHideBtn() {
        return hideBtn;
    }

    public WebElement getTextField() {
        return textField;
    }

    public WebElement getShowBtn() {
        return showBtn;
    }

    public WebElement getMouseHover() {
        return mouseHover;
    }

    public WebElement getReload() {
        return reload;
    }


    public void click(WebElement elem) {
        elem.click();
    }

    public void input(WebElement elem, String text) {
        elem.sendKeys(text);
    }

    public void select(WebElement elem, int index) {
        Select select = new Select(elem);
        select.selectByIndex(index);
    }

    public void windowHandle(WebElement elem, String windowTitle) {

        String winHandleBefore = driver.getWindowHandle();
        click(elem);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(driver.getTitle(), windowTitle, "Wrong title");
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }

    public void checkAlertText(String text) {
        Assert.assertEquals(driver.switchTo().alert().getText(), text, "Wrong text");
        driver.switchTo().alert().accept();
    }

    public void isElementDisplayed(WebElement elem) {
        elem.isDisplayed();
    }

    public void mouseHoverHandle(WebElement elem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).build().perform();
    }

    public void tableHandle(WebElement elem, String text) {
        String txt = elem.getText();
        Assert.assertEquals(txt, text, "Error");
    }

}
