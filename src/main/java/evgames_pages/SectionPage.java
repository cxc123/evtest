package evgames_pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

/**
 * Created by aakumar on 08/11/17.
 */
public class SectionPage {

    @FindBy(css="a[title='Искать объявления']")
    private WebElement search;
    private WebDriver webDriver;
    public SectionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void loadSectionPage()
    {

        PageFactory.initElements(webDriver,this);

    }

    public SearchPage goToSearchPage() throws TimeoutException,NoSuchElementException
    {
        try
        {
            this.search.click();
            return new SearchPage(webDriver);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }

    }

}
