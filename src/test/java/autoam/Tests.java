package autoam;

import org.testng.annotations.Test;

public class Tests extends Base {
    Page googlePage;
    AutoAmPage autoAmPage;
    @Test(priority = 0)
    public void googleSearch() {
        googlePage = new Page(driver);
        googlePage.searchInput("auto.am");
        googlePage.searchClick();
        googlePage.autoAmLinkClick();
    }
    @Test(priority = 1)
    public void autoAm() {
        autoAmPage = new AutoAmPage(driver);
        autoAmPage.checkAutoAmPageTitle("Ավտոմեքենաների վաճառք Հայաստանում - Auto.am");
        autoAmPage.selectMark("Tesla");
        autoAmPage.selectModel("Model Y");
        autoAmPage.selectYear("2018");
        autoAmPage.customClearedClick();
        autoAmPage.searchBtnClick();
        autoAmPage.checkQuantity("\uE8B6 4");
        autoAmPage.checkPrice("$ 67 000");
    }

}
