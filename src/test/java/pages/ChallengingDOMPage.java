package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ChallengingDOMPage {
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Challenging DOM")
    private WebElement correctPage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]")
    private WebElement values;

    public ChallengingDOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotoPage() {
        correctPage.click();
    }


    public void modifyValues() {
        String[] words = values.getText().split(" ");
//        I know this solution is hideous and there are better ways to
//        make it work but that's what I could think of in a limited time
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < 6; i++) {
            list.add(words[i].charAt(words[i].length() - 1));
        }
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list) {
            builder.append(ch);
        }
        String res = builder.toString();
        assertThat(res, is("000000"));
    }

}
