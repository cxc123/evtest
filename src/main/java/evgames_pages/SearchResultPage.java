package evgames_pages;

import models.ProductDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by aakumar on 08/11/17.
 */
public class SearchResultPage {
    private WebDriver webDriver;
    @FindBy(css = "tr[id^='tr_']")
    public List<WebElement> productElement;
    @FindBy(linkText = "Расширенный поиск")
    private WebElement advancedSearch;
    @FindBy(linkText = "Цена")
    private WebElement priceSort;
    @FindBy(css = "div.filter_second_line_dv > span:nth-child(3) > select")
    private WebElement option;
    @FindBy(linkText = "Закладки")
    private WebElement memo;
    @FindBy(css = "a#a_fav_sel")
    private WebElement addtoMemo;
    @FindBy(css="a#alert_ok")
    private WebElement alertok;
    public SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void loadSearchResultPage()
    {


        PageFactory.initElements(webDriver,this);

    }
    public MemoPage goToMemoPage() throws TimeoutException,NoSuchElementException,Exception
    {
        String parentWindow=webDriver.getWindowHandle();
        this.memo.click();
        for(String s:webDriver.getWindowHandles())
        {
            if(!s.equalsIgnoreCase(parentWindow))
            {
                webDriver.switchTo().window(s).close();
            }
        }
        webDriver.switchTo().window(parentWindow);
        this.memo.click();
        return new MemoPage(webDriver);

    }
    public List<ProductDetail> selectProduct(int n)throws TimeoutException,NoSuchElementException
    {
        List<ProductDetail> productDetails = new ArrayList<>();
        for(int i=0;i<n;i++)
       {
           productElement.get(i).findElement(By.cssSelector("input[type='checkbox']")).click();
           WebElement w=productElement.get(i).findElement(By.cssSelector("a[id^='dm_']"));
           ProductDetail productDetail = new ProductDetail();
           productDetail.setHref(w.getAttribute("href"));
           productDetail.setId(w.getAttribute("id"));
           productDetails.add(productDetail);
       }

        return productDetails;

    }
    public void addToMemo() throws TimeoutException,NoSuchElementException,Exception
    {
        new WebDriverWait(webDriver,1000).until(ExpectedConditions.elementToBeClickable(this.addtoMemo)).click();
        new WebDriverWait(webDriver,1000).until(ExpectedConditions.elementToBeClickable(this.alertok)).click();
    }
    public void optionSelect() throws TimeoutException,NoSuchElementException
    {
        Select select= new Select(option);
        select.selectByVisibleText("Продажа");
    }
    public void sortPrice() throws TimeoutException,NoSuchElementException
    {
        this.priceSort.click();
    }
    public SearchPage goToSearchPage() throws TimeoutException,NoSuchElementException
    {
        this.advancedSearch.click();
        return  new SearchPage(webDriver);

    }
}
