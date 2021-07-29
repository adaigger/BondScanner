package BondScanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
 
 
public class USTreasuries extends BaseTest {
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
        public void USTreasuries_End2021VsEnd2022() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on US CDs tab
            Utils.GetTreasuryTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("0.5");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 25)
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
              
            System.out.println("Total from 2021 Search: " + lastFourDigits);
              
            int end2021Total = Integer.parseInt(lastFourDigits);
             
             
            //Click Edit and change from 2021 to 2022
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetMaturityDateEnd(driver).clear();
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2022");
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for Germany
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
              
            System.out.println("Total from 2022 Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int end2022Total = Integer.parseInt(DeleteComma);
             
            if (end2022Total > end2021Total){
                System.out.println("Total from 2022 search " + end2022Total + " Is correctly larger than 2021 Total " + end2021Total);
                test.log(LogStatus.PASS, "Total from 2022 search " + end2022Total + " Is correctly larger than 2021 Total " + end2021Total);
            }
              
            else{
                System.out.println("Total from 2022 search " + end2022Total + " Is incorrectly Less than 2021 Total " + end2021Total);
                test.log(LogStatus.FAIL, "Total from 2022 search " + end2022Total + " Is incorrectly Less than 2021 Total " + end2021Total);
            }
             
             
        }
         
        @Test
        public void USTreasuries_YieldToWorstRangeTest() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on treasuries tab
            Utils.GetTreasuryTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("0.5");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 25)
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
              
            System.out.println("Total from greater range Search: " + lastFourDigits);
              
            int bigRangeTotal = Integer.parseInt(lastFourDigits);
             
             
            //Click Edit and change from 0.0 to 0.1
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetYTWMin(driver).clear();
           Utils.GetYTWMin(driver).sendKeys("0.1");
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for Germany
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
              
            System.out.println("Total from samller range Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int smallRangeTotal = Integer.parseInt(DeleteComma);
             
            if (bigRangeTotal > smallRangeTotal){
                System.out.println("Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.PASS, "Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
            }
              
            else{
                System.out.println("Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.FAIL, "Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
            }
             
             
        }
         
        @Test
        public void USTreasuries_CouponRangesTest() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on US CDs tab
            Utils.GetTreasuryTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values for coupon ranges range
            Utils.GetCouponMin(driver).sendKeys("0");
            Utils.GetCouponMax(driver).sendKeys("10");
             
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
              
            System.out.println("Total from greater range Search: " + lastFourDigits);
              
            String DeleteComma1 = lastFourDigits.replace(",", "");
             
            int bigRangeTotal = Integer.parseInt(DeleteComma1);
             
             
            //Click Edit and change from 0.0 to 0.1
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetCouponMax(driver).clear();
            Utils.GetCouponMax(driver).sendKeys("5");
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for Germany
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
              
            System.out.println("Total from smaller range Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int smallRangeTotal = Integer.parseInt(DeleteComma);
             
            if (bigRangeTotal > smallRangeTotal){
                System.out.println("Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.PASS, "Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
            }
              
            else{
                System.out.println("Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.FAIL, "Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
            }
             
             
        }
         
        @Test
        public void USTreasuries_CouponRangesTestSmallerGap() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
             
            driver.get(homePage);
             
            //Click on US CDs tab
            Utils.GetTreasuryTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values for coupon ranges range
            Utils.GetCouponMin(driver).sendKeys("0");
            Utils.GetCouponMax(driver).sendKeys("5");
             
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
              
            System.out.println("Total from greater range Search: " + lastFourDigits);
              
            String DeleteComma1 = lastFourDigits.replace(",", "");
             
            int bigRangeTotal = Integer.parseInt(DeleteComma1);
             
             
            //Click Edit and change from 0.0 to 0.1
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetCouponMin(driver).clear();
            Utils.GetCouponMin(driver).sendKeys("2");
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for Germany
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
              
            System.out.println("Total from smaller range Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int smallRangeTotal = Integer.parseInt(DeleteComma);
             
            if (bigRangeTotal > smallRangeTotal){
                System.out.println("Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.PASS, "Total from greater range search " + bigRangeTotal + " Is correctly larger than smaller range Total " + smallRangeTotal);
            }
              
            else{
                System.out.println("Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
                test.log(LogStatus.FAIL, "Total from greater range search " + bigRangeTotal + " Is incorrectly Less than smaller range Total " + smallRangeTotal);
            }
             
             
        }
}
