package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MakeLoanPage extends AbstractPage {
    protected static WebDriver DRIVER;

    @FindBy(id="targetAccount")
    private WebElement targetAccountSelect;

    @FindBy(id="ammount")
    private WebElement amountInput;

    @FindBy(xpath = "//*[@value='Get Loan!']")
    private WebElement makeLoanButton;

    @FindBy(id = "sb-return-message")
    private WebElement returnMessage;

    public MakeLoanPage amount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
        return this;
    }

    public MakeLoanPage clickMakeLoanButton(){
        makeLoanButton.click();
        return this;
    }

    public String getReturnMessage(){
        return returnMessage.getText();
    }
}
