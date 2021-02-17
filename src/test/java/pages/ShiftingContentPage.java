package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ShiftingContentPage {

    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Shifting Content")
    private WebElement correctPage;

    @FindBy(how = How.LINK_TEXT, using = "Elemental Selenium")
    private WebElement homeButton;

    String colorBefore, colorAfter;

    public ShiftingContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
     public void afterHover() {
         Actions builder = new Actions(driver);
         builder.moveToElement(homeButton).perform();
         colorAfter = homeButton.getCssValue("color");
     }

     public void beforeHover() {
         colorBefore = homeButton.getCssValue("color");
     }

     public void checkColors() {
        assertThat(colorBefore, is(not(colorAfter)));
     }


    public void gotoPage() {
        correctPage.click();
    }

}
