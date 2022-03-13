package sauseDemo;

import org.testng.annotations.Test;

public class SauceDemoTest extends SeleniumBase {
    SauceDemoPage sauceDemoPage;

    @Test(priority = 0)
    public void loginTest() {
        sauceDemoPage = new SauceDemoPage(SeleniumBase.driver);
        sauceDemoPage.login();
        sauceDemoPage.check(sauceDemoPage.getProducts(), "PRODUCTS");
        sauceDemoPage.selection(sauceDemoPage.getPrice(), 2);
        sauceDemoPage.checkProductPrice();
        sauceDemoPage.click(sauceDemoPage.getAddToCart());
        sauceDemoPage.click(sauceDemoPage.getCartBtn());
        sauceDemoPage.checkItem(sauceDemoPage.getItem());
        sauceDemoPage.click(sauceDemoPage.getCheckOut());
        sauceDemoPage.fillInfo("Mariam", "Aghajanyan", "0070");
        sauceDemoPage.click(sauceDemoPage.getContinueBtn());
        sauceDemoPage.check(sauceDemoPage.getTotal(), "Total: $53.99");
        sauceDemoPage.click(sauceDemoPage.getFinishBtn());
        sauceDemoPage.check(sauceDemoPage.getMessage(), "THANK YOU FOR YOUR ORDER");
        sauceDemoPage.click(sauceDemoPage.getBackToHomeBtn());
    }



}
