package BondScanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import BondScanner.Utils;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
 
public class GlobalCorporateBonds extends BaseTest {
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
        public void GobalCorporate_AllVsHighYieldPlusInvestmentGrade() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                 
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
                 
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
                //Click ViewResults and Record the number of results
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
                  
                 
                  
                String DeleteComma = lastFourDigits.replace(",", "");
                 
                int AllTotal = Integer.parseInt(DeleteComma);
                System.out.println("Total from All Search: " + AllTotal);
                 
                //Click Edit and change from All to High Yield and submit again
                Utils.GetResultsEditButton(driver).click();
                Utils.GetHighYieldButton(driver).click();
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
                 
                // Record the results for High Yield
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                
                String DeleteComma2 = lastFourDigits.replace(",", "");
                 
                int HYTotal = Integer.parseInt(DeleteComma2);
                System.out.println("Total from High Yield Search: " + HYTotal);
                 
              //Click Edit and change from High Yield to Investment Grade and submit again
                Utils.GetResultsEditButton(driver).click();
                Utils.GetInvestmentGradeButton(driver).click();
                Utils.GetViewResultsButton(driver).click();
               Thread.sleep(3000);
                
               // Record the results for High Yield
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                
                String DeleteComma3 = lastFourDigits.replace(",", "");
                 
                int IGTotal = Integer.parseInt(DeleteComma3);
                System.out.println("Total from Investment Grade Search: " + IGTotal);
                 
                int SumTotal = HYTotal + IGTotal;
                 
                if (AllTotal >= SumTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than High Yield and Investment Grade totals combined " + SumTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than High Yield and Investment Grade totals combined " + SumTotal);
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than High Yield and Investment Grade totals combined " + SumTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than High Yield and Investment Grade totals combined " + SumTotal);
                }
    
        }
         
         
        @Test
        public void GlobalCorporate_AllVsGermany() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.5");
            Utils.GetYTWMax(driver).sendKeys("1.5");
             
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
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            int AllTotal = Integer.parseInt(lastFourDigits);
             
             
            //Click Edit and change from All to Germany
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetCountryIssuer(driver).click();
             
            for (int i=0; i<81; i++){
                Utils.GetCountryIssuer(driver).sendKeys(Keys.ARROW_DOWN);
                if(i == 79){
                    Utils.GetCountryIssuer(driver).sendKeys(Keys.ENTER);}}
             
            
             
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for Germany
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
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
              
            System.out.println("Total from Germany Search: " + lastFourDigits);
              
            int GermanTotal = Integer.parseInt(lastFourDigits);
             
            if (AllTotal > GermanTotal){
                System.out.println("Total from All search " + AllTotal + " Is correctly larger than German Total " + GermanTotal);
                test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than German Total " + GermanTotal);
            }
              
            else{
                System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than German Total " + GermanTotal);
                test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than German Total " + GermanTotal);
            }
             
             
        }
         
         
        @Test
        public void GlobalCorporate_AllVsGBP() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.5");
            Utils.GetYTWMax(driver).sendKeys("1.5");
             
            //Select GPB from dropdown
                 
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
             
            List<WebElement> element =
                    driver.findElements(By.xpath("//ul[@class='_dd1']/li[4]"));
                    for (int i = 0; i < element.size(); i++) {
                     String temp = element.get(i).getText();
                    if (temp.equals("GBP")) {
                     element.get(i).click();
                    break;
                     }
                     }
             
             
             
             
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
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            int AllTotal = Integer.parseInt(lastFourDigits);
             
             
             
             
            if (AllTotal == 0){
                System.out.println("Total from GBP search is correctly " + AllTotal);
                test.log(LogStatus.PASS, "Total from GBP search is correctly " + AllTotal);
            }
              
            else{
                System.out.println("Total from GBP search " + AllTotal + " Should be 0 ");
                test.log(LogStatus.FAIL, "Total from GBP search " + AllTotal + " Should be 0 ");
            }
             
             
        }
         
        @Test
        public void GlobalCorporate_AllVsLimitedIndustry() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
                
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
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
                  
                System.out.println("Total from All Search: " + lastFourDigits);
                  
                int AllTotal = Integer.parseInt(lastFourDigits);
                 
                 
                //Click Edit and change from All to Some Industries and submit again
                Utils.GetResultsEditButton(driver).click();
                //Click Select None
                Utils.GetNoneInd(driver).click();
                //Click the first three Industries
                Utils.GetEnergyCheck(driver).click();
                Utils.GetBasicCheck(driver).click();
                Utils.GetIndustrialCheck(driver).click();
                 
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
         
                totalnum =  Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                System.out.println("Total from Limited Search: " + lastFourDigits);
                  
                int LimitedTotal = Integer.parseInt(lastFourDigits);
                 
                if (AllTotal > LimitedTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal);
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal);
                }
     
        }
         
        @Test
        public void GlobalCorporate_VerifyIndustrialFilter() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
                
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
                //Click Select None
                Utils.GetNoneInd(driver).click();             
                //Click the first three Industries
                Utils.GetEnergyCheck(driver).click();
                Utils.GetBasicCheck(driver).click();
                Utils.GetIndustrialCheck(driver).click();
                 
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
                  
                System.out.println("Total from All Search: " + lastFourDigits);
                  
                int AllTotal = Integer.parseInt(lastFourDigits);
                 
                //Click Edit and change from All to High Yield and submit again
                Utils.GetResultsEditButton(driver).click();
                
                //Unselect Industries
                
                Utils.GetEnergyCheck(driver).click();
                Utils.GetBasicCheck(driver).click();
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
         
                 
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                System.out.println("Total from Indusrty Search: " + lastFourDigits);
                  
                int LimitedTotal = Integer.parseInt(lastFourDigits);
                 
                if (AllTotal > LimitedTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal);
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal);
                }
         
        }
         
         
        @Test
        public void GlobalCorporate_AllVsHighYieldPlusInvestmentGrade2030() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2030");
                
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
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
                  
                System.out.println("Total from All Search: " + lastFourDigits);
                  
                String DeleteComma = lastFourDigits.replace(",", "");
                 
                int AllTotal = Integer.parseInt(DeleteComma);
                 
                 
                //Click Edit and change from All to High Yield and submit again
                Utils.GetResultsEditButton(driver).click();
                Utils.GetHighYieldButton(driver).click();
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
                 
                // Record the results for High Yield
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                System.out.println("Total from High Yield Search: " + lastFourDigits);
                  
                int HYTotal = Integer.parseInt(lastFourDigits);
                 
              //Click Edit and change from All to High Yield and submit again
                Utils.GetResultsEditButton(driver).click();
                Utils.GetInvestmentGradeButton(driver).click();
                Utils.GetViewResultsButton(driver).click();
               Thread.sleep(3000);
                
               // Record the results for High Yield
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
                if (totalnum.length() == 22)
                {
                    lastFourDigits = totalnum.substring(totalnum.length() - 3);
                }
                else if (totalnum.length() == 25)
                {
                    lastFourDigits = totalnum.substring(totalnum.length() - 5);
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
                  
                System.out.println("Total from Investment Grade Search: " + lastFourDigits);
                  
                DeleteComma = lastFourDigits.replace(",", "");
                 
                int IGTotal = Integer.parseInt(DeleteComma);
                 
                int SumTotal = HYTotal + IGTotal;
                 
                if (AllTotal > SumTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than High Yield and Investment Grade totals combined " + SumTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than High Yield and Investment Grade totals combined " + SumTotal); 
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than High Yield and Investment Grade totals combined " + SumTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than High Yield and Investment Grade totals combined " + SumTotal); 
                }
    
        }
         
         
        @Test
        public void GlobalCorporate_AllVsGermany2030() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2030");
                
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
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
                  
                System.out.println("Total from All Search: " + lastFourDigits);
                  
                String DeleteComma = lastFourDigits.replace(",", "");
                 
                int AllTotal = Integer.parseInt(DeleteComma);
                 
                     
                 
               //Click Edit and change from All to Germany
                Utils.GetResultsEditButton(driver).click();       
                 
                Utils.GetCountryIssuer(driver).click();
                 
                for (int i=0; i<81; i++){
                    Utils.GetCountryIssuer(driver).sendKeys(Keys.ARROW_DOWN);
                    if(i == 79){
                        Utils.GetCountryIssuer(driver).sendKeys(Keys.ENTER);}}
                 
                
                 
 
                 
                 
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
                 
             // Record the results for Germany
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                System.out.println("Total from Germany Search: " + lastFourDigits);
                  
                int GermanTotal = Integer.parseInt(lastFourDigits);
                 
                if (AllTotal > GermanTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than German Total " + GermanTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than German Total " + GermanTotal); 
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than German Total " + GermanTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than German Total " + GermanTotal);
                }
         
                 
                
        }
         
         
         
        @Test
        public void GlobalCorporate_GBP2021VSGBP2030() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2030");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.5");
            Utils.GetYTWMax(driver).sendKeys("1.5");
             
            //Select GPB from dropdown
                 
            Utils.GetCurrency(driver).click();
            Utils.GetCurrency(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
             
            List<WebElement> element =
                    driver.findElements(By.xpath("//ul[@class='_dd1']/li[4]"));
                    for (int i = 0; i < element.size(); i++) {
                     String temp = element.get(i).getText();
                    if (temp.equals("GBP")) {
                     element.get(i).click();
                    break;
                     }
                     }
             
             
             
             
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
              
            System.out.println("Total from GBP 2021 Search: " + lastFourDigits);
              
            int Total2030 = Integer.parseInt(lastFourDigits);
             
            //Click Edit and change from 2021 to 2030
            Utils.GetResultsEditButton(driver).click();
            Utils.GetMaturityDateEnd(driver).clear();
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
             
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
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
              
            System.out.println("Total from GBP 2030 Search: " + lastFourDigits);
              
            int Total2021 = Integer.parseInt(lastFourDigits);
             
            if (Total2030 > Total2021){
                System.out.println("Total from 2030 search " + Total2030 + " Is correctly larger than 2021 Total " + Total2021);
                test.log(LogStatus.PASS, "Total from 2030 search " + Total2030 + " Is correctly larger than 2021 Total " + Total2021); 
            }
              
            else{
                System.out.println("Total from 2030 search" + Total2030 + " Is incorrectly Less than 2021 Total " + Total2021);
                test.log(LogStatus.FAIL, "Total from 2030 search" + Total2030 + " Is incorrectly Less than 2021 Total " + Total2021);
            }
             
        }
         
         
         
        @Test
        public void GlobalCorporate_VerifyIndustrialFilter2030() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
      
                System.out.println("--------Opening Bond Scanner--------");
                String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                //driver = new ChromeDriver(options);
                
                driver.get(homePage);
                  
                //Get current date and format it
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = sdf.format(date);
                
                //Enter Current date into the Maturity Date starting field
                Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
                 
                //Enter end 2021 date into end date field
                Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
                
                //Enter the values 0.5 - 1.5 for the Yield to Worst range
                Utils.GetYTWMin(driver).sendKeys("0.5");
                Utils.GetYTWMax(driver).sendKeys("1.5");
                 
                //Click Select None
                Utils.GetNoneInd(driver).click();
                //Click the first three Industries
                Utils.GetEnergyCheck(driver).click();
                Utils.GetBasicCheck(driver).click();
                Utils.GetIndustrialCheck(driver).click();
                 
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
                  
                System.out.println("Total from All Search: " + lastFourDigits);
                  
                int AllTotal = Integer.parseInt(lastFourDigits);
                 
                //Click Edit and change from All to High Yield and submit again
                Utils.GetResultsEditButton(driver).click();
                
                //Unselect Industries
                
                Utils.GetEnergyCheck(driver).click();
                Utils.GetBasicCheck(driver).click();
                Thread.sleep(3000);
         
                //Submit the new search
                Utils.GetViewResultsButton(driver).click();
                Thread.sleep(3000);
                 
                totalnum = Utils.GetTotalNum(driver).getText();
                  
                lastFourDigits = "";     //substring containing last 4 characters
                  
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
                  
                System.out.println("Total from Limited Search: " + lastFourDigits);
                  
                int LimitedTotal = Integer.parseInt(lastFourDigits);
                 
                if (AllTotal > LimitedTotal){
                    System.out.println("Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal);
                    test.log(LogStatus.PASS, "Total from All search " + AllTotal + " Is correctly larger than Limited Total " + LimitedTotal); 
                }
                  
                else{
                    System.out.println("Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal);
                    test.log(LogStatus.FAIL, "Total from All search " + AllTotal + " Is incorrectly Less than Limited Total " + LimitedTotal); 
                }
         
        }
}
