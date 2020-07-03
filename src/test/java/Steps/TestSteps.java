package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestSteps extends BaseUtil {
    private BaseUtil base;

    public TestSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on main site")
    public void iAmOnMainSite() throws InterruptedException {
        base.Driver.navigate().to("http://automationpractice.com/index.php");
        base.Wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));

        base.Wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchbox [name='search_query']")));
        base.Driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("Dress");

        System.out.println("TEST");

        Assert.assertTrue(base.Wait.until(ExpectedConditions.urlContains("/index")));
    }
}
