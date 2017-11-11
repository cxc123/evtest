package evgames_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

/**
 * Created by aakumar on 08/11/17.
 */
public class HomePage {
    private WebDriver webDriver;
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void loadHomePage()
    {

        PageFactory.initElements(webDriver,this);

    }
    @FindBy(css="a[title='По-русски']")
    private WebElement language;
    @FindBy(css = "a[title='Объявления Электротехника']")
    private WebElement section;

    public SectionPage goToSectionPage() throws TimeoutException,NoSuchElementException
    {
        try {
            this.section.click();
            return new SectionPage(webDriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }


    }

    public void changeLanguage() throws  TimeoutException,NoSuchElementException
    {
        try
        {
            this.language.click();

        }
        catch (Exception e)
        {

        }

    }

}
