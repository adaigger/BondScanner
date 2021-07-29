package BondScanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
 
public class NonUSSovereign extends BaseTest{
    WebDriver driver;
     @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\devuser6\\Desktop\\geckodriver-v0.24.0-win32\\geckodriver.exe");
              
        }
      
      
        @BeforeMethod
		public void setUpMethod() throws Exception {
            System.out.println("--------Starting Test--------");
            driver = Utils.getDriver();
        }
      
        @AfterMethod
		public void tearDownMethod() throws Exception {
            System.out.println("--------Test Finished--------");
            driver.quit();
        }
         
        
         
         
        @Test
        public void USSovereign_YTWPercentTest() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Sovereign Bonds tab
            Utils.GetSovereignTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2026");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
           Utils.GetYTWMax(driver).sendKeys("3.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from 3% Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int Total3 = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to IG
            Utils.GetResultsEditButton(driver).click();       
             
             
            Utils.GetYTWMax(driver).clear();
            Utils.GetYTWMax(driver).sendKeys("6.0");
             
             
           Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for IG
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from 6% Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int Total6 = Integer.parseInt(DeleteComma2);
             
            if (Total6 > Total3){
                System.out.println("Total from 6% search " + Total6 + " Is correctly Larger than 3% Total " + Total3);
                test.log(LogStatus.PASS, "Total from 6% search " + Total6 + " Is correctly Larger than 3% Total " + Total3);
            }
              
            else{
                System.out.println("Total from 6% search " + Total6 + " Is incorrectly Smaller than 3% Total " + Total3);
                test.log(LogStatus.FAIL, "Total from 6% search " + Total6 + " Is incorrectly Smaller than 3% Total " + Total3);
            }
             
             
        }
         
        @Test
        public void USSovereign_AllVsUSD() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Sovereign Bonds tab
            Utils.GetSovereignTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2026");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("6.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from all Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int AllTotal = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to USD
            Utils.GetResultsEditButton(driver).click();       
             
             
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
             
             
             
           Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for IG
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from USD Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int USDTotal = Integer.parseInt(DeleteComma2);
             
            if (USDTotal < AllTotal){
                System.out.println("Total from USD search " + USDTotal + " Is correctly smaller than all Total " + AllTotal);
                test.log(LogStatus.PASS, "Total from USD search " + USDTotal + " Is correctly smaller than all Total " + AllTotal);
            }
              
            else{
                System.out.println("Total from USD search " + USDTotal + " Is incorrectly larger than all Total " + AllTotal);
                test.log(LogStatus.FAIL, "Total from USD search " + USDTotal + " Is incorrectly larger than all Total " + AllTotal);
            }
             
             
        }
         
        @Test
        public void USSovereign_AllVsSumCurrencies() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
           
            driver.get(homePage);
             
            //Click on  Sovereign Bonds tab
            Utils.GetSovereignTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2026");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("6.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from all Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int AllTotal = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to USD
            Utils.GetResultsEditButton(driver).click();       
             
      
             
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
             
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for USD
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from USD Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int USDTotal = Integer.parseInt(DeleteComma2);
     /*        
          //Click Edit and change from USD to CAD
            Utils.GetResultsEditButton(driver).click();       
             
             
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
             
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for CAD
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from CAD Search: " + lastFourDigits);
              
            String DeleteComma3 = lastFourDigits.replace(",", "");
             
            int CADTotal = Integer.parseInt(DeleteComma3);
             */
          //Click Edit and change from CAD to EUR
           
            Utils.GetResultsEditButton(driver).click(); 
             
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
             
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for EUR
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from EUR Search: " + lastFourDigits);
              
            String DeleteComma4 = lastFourDigits.replace(",", "");
             
            int EURTotal = Integer.parseInt(DeleteComma4);
             
            //Click Edit and change from EUR to GBP
            Utils.GetResultsEditButton(driver).click();
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
             
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for GBP
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from GBP Search: " + lastFourDigits);
              
            String DeleteComma5 = lastFourDigits.replace(",", "");
             
            int GBPTotal = Integer.parseInt(DeleteComma5);
             
            int SumTotal = USDTotal + 0 + EURTotal + GBPTotal;
             
            if (SumTotal == AllTotal){
                System.out.println("Total from all currencies added " + SumTotal + " Is correctly equal to all search Total " + AllTotal);
                test.log(LogStatus.PASS, "Total from all currencies added " + SumTotal + " Is correctly equal to all search Total " + AllTotal);
            }
              
            else{
                System.out.println("Total from all currencies added " + SumTotal + " Is incorrectly Not Equal to all search Total " + AllTotal);
                test.log(LogStatus.FAIL, "Total from all currencies added " + SumTotal + " Is incorrectly Not Equal to all search Total " + AllTotal);
            }
             
             
        }
}
