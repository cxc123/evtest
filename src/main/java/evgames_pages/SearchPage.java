package evgames_pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

/**
 * Created by aakumar on 08/11/17.
 */
public class SearchPage
{
    private WebDriver webDriver;
    @FindBy(id = "ptxt")
    private WebElement searchEnter;
    @FindBy(name = "topt[8][min]")
    private WebElement minPrice;
    @FindBy(name = "topt[8][max]")
    private WebElement maxPrice;
    @FindBy(id="sbtn")
    private WebElement searchButton;
    @FindBy(css = "select[name='sid']")
    private WebElement transaction_type;
    @FindBy(css = "select[name='search_region']")
    private WebElement town_district;
    @FindBy(css="select[name='pr']")
    private WebElement searchPeriod;
    @FindBy(css="select[name='sort']")
    private WebElement sortby;
    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void loadSearchPage()
    {


        PageFactory.initElements(webDriver,this);

    }

    public void enterSearchString(String text) throws NoSuchElementException,TimeoutException
    {
        this.searchEnter.sendKeys(text);
    }
    public void enterMinprice(String minPrice) throws NoSuchElementException,TimeoutException
    {
        this.minPrice.sendKeys(minPrice);
    }
    public void enterMaxPrice(String maxPrice) throws NoSuchElementException,TimeoutException
    {
        this.maxPrice.sendKeys(maxPrice);
    }
    public void enterTransaction_type(String input) throws NoSuchElementException,TimeoutException
    {
        Select select = new Select(this.transaction_type);
        select.selectByVisibleText(input);

    }
    public void enterTown_district(String input) throws NoSuchElementException,TimeoutException
    {
        Select select = new Select(this.town_district);
        select.selectByVisibleText(input);
    }
    public void enterSearchPeriod(String input) throws NoSuchElementException,TimeoutException
    {
        Select select = new Select(this.searchPeriod);
        select.selectByVisibleText(input);
    }
    public void enterSortby(String input) throws NoSuchElementException,TimeoutException
    {
        Select select = new Select(this.sortby);
        select.selectByVisibleText(input);
    }
    public SearchResultPage goToSearchResult() throws TimeoutException,NoSuchElementException
    {
        try
        {
            this.searchButton.click();
            return new SearchResultPage(webDriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }


    }


}
