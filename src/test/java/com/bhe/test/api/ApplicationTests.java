package com.bhe.test.api;

import com.bhe.config.APIConfig;
import io.appium.java_client.ios.IOSDriver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;

public class ApplicationTests {

    private static final String base_url = ConfigCache.getOrCreate(APIConfig.class).apiBaseURL();
    private static final String token = ConfigCache.getOrCreate(APIConfig.class).token();
    private static final String clientId = ConfigCache.getOrCreate(APIConfig.class).clientId();
    private static final String clientSec = ConfigCache.getOrCreate(APIConfig.class).clientSec();
    private static final String password = ConfigCache.getOrCreate(APIConfig.class).password();
    private static final String username = ConfigCache.getOrCreate(APIConfig.class).username();
    private static final String grantType = ConfigCache.getOrCreate(APIConfig.class).grantType();
    private static final String secretToken = ConfigCache.getOrCreate(APIConfig.class).secretToken();
    String accessToken = null;
    URL url;
    WebDriver driver = null;
    IOSDriver mobileDriver = null;
    String serviceTicketId = "NE19357104825-G-ALBION_CS-BHEALBN-0-20220910-09";
    String completedstatus = "Completed";
    //String serviceNumber = driver.findElement(By.xpath("//*[@class='SingleTask DraggableSingleTask']/div[@class='SingleTaskColumn truncate Field-STRING'][1]")).getText();
    String dateToday = "2024-04-22";
   String jsonObject = "{\n" +
          "  \"graphs\": [\n" +
            "    {\n" +
            "      \"graphId\": \"graph1\",\n" +
            "      \"compositeRequest\": [\n" +
            "        {\n" +
            "          \"method\": \"POST\",\n" +
           "          \"url\": \"/services/data/v53.0/sobjects/LocateInformation__c/\",\n" +
            "          \"referenceId\": \"LocateInformation11\",\n" +
            "          \"body\": {\n" +
            "            \"LocateCounty__c\": \"\",\n" +
            "            \"LocateCustomer__c\": \"Mallikarjun Chowdary\",\n" +
            "            \"DateReceived__c\": \"" + dateToday + "T13:00:00\",\n" +
            "            \"DateWorkToBegin__c\": \"" + dateToday + "T20:00:00\",\n" +
            "            \"Explosives__c\": \"Y\",\n" +
           "            \"ExternalID__c\": \"" + serviceTicketId + "\",\n" +
            "            \"LocateIntersection__c\": \"RIDGE RD\",\n" +
           "            \"KorterraZone__c\": \"TLRD\",\n" +
           "            \"LocatePriority__c\": \"ROUTINE\",\n" +
            "            \"LocateRange__c\": \"009W\",\n" +
            "            \"LocateRange2__c\": \"010W\",\n" +
            "            \"LocateSection__c\": \"04SW\",\n" +
            "            \"LocateSection2__c\": \"05SW\",\n" +
            "            \"MeetDate__c\": \"" + dateToday + "T13:00:00\",\n" +
            "            \"OneCallPriority__c\": \"NORM NEW STRT LREQ\",\n" +
            "            \"RequestedBy__c\": \"Mallikarjun Chowdary\",\n" +
            "            \"TicketNumber__c\": \"" + serviceTicketId + "\",\n" +
            "            \"Township__c\": \"42N\",\n" +
            "            \"Township2__c\": \"43N\",\n" +
            "            \"TypeOfWork__c\": \"FIBER MAIN NEW\",\n" +
            "            \"LocateCoordinates__Latitude__s\": \"41.979187\",\n" +
            "            \"LocateCoordinates__Longitude__s\": \"-98.083565\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"method\": \"POST\",\n" +
            "          \"url\": \"/services/data/v53.0/sobjects/WorkOrder/\",\n" +
            "          \"referenceId\": \"AB454545454858\",\n" +
            "          \"body\": {\n" +
            "            \"Status\": \"Open\",\n" +
            "            \"WorkType\": {\n" +
            "              \"attributes\": {\n" +
            "                \"type\": \"WorkType\",\n" +
            "                \"url\": \"/services/data/v53.0/sobjects/WorkType\"\n" +
            "              },\n" +
            "              \"Name\": \"Gas Locate Emergency-Distribution\"\n" +
            "            },\n" +
            "            \"Subject\": \"Gas Locate\",\n" +
            "            \"Description\": \"FROM THE INTERSECTION OF 3RD ST AND BOWEN ST, TRAVEL WEST  APPX 1/4 BLOCK. MARK 50FT RADIUS OF ORANGE SAFETY CONES ON  THE NORTH SIDE OF THE ROAD.  CALLER LAT/LON: NAD: ZONE:  MAP NW LAT/LON: 41.9796042  -98.0845068    SE LAT/LON: 41.9787693 -98.0826241\",\n" +
            "            \"ExternalID__c\": \"" + serviceTicketId + "\",\n" +
            "            \"WorkDescription__c\": \"Line Locates\",\n" +
            "            \"Street\": \"16465 Ridge Run Dr\",\n" +
            "            \"City\": \"Monument Central\",\n" +
           "            \"State\": \"CO\",\n" +
            "            \"PostalCode\": \"\",\n" +
            "            \"Country\": \"US\",\n" +
            "            \"Longitude\": \"-104.69520126079568\",\n" +
            "            \"Latitude\": \"39.07061702188589\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
           "          \"method\": \"POST\",\n" +
           "          \"url\": \"/services/data/v53.0/sobjects/ServiceAppointment/\",\n" +
           "          \"referenceId\": \"ServiceAppointment\",\n" +
            "          \"body\": {\n" +
            "            \"ParentRecordId\": \"@{AB454545454858.id}\",\n" +
            "            \"WorkInstructions__c\": \"FROM THE INTERSECTION OF 3RD ST AND BOWEN ST, TRAVEL WEST  APPX 1/4 BLOCK. MARK 50FT RADIUS OF ORANGE SAFETY CONES ON  THE NORTH SIDE OF THE ROAD.  CALLER LAT/LON: NAD: ZONE:  MAP NW LAT/LON: 41.9796042  -98.0845068    SE LAT/LON: 41.9787693 -98.0826241\",\n" +
            "            \"WorkDescription__c\": \"Line Locates\",\n" +
            "            \"Customer__c\": \"Mallikarjun Chowdary\",\n" +
            "            \"HostSystem__c\": \"Korterra\",\n" +
            "            \"ExternalID__c\": \"" + serviceTicketId + "\",\n" +
            "            \"LocateInformationID__c\": \"@{LocateInformation11.id}\",\n" +
            "            \"HostGeolocation__Latitude__s\": \"39.07061702188589\",\n" +
            "            \"HostGeolocation__Longitude__s\": \"-104.69520126079568\",\n" +
            "            \"Street\": \"16465 Ridge Run Dr\",\n" +
            "            \"City\": \"Monument Central\",\n" +
            "            \"State\": \"CO\"\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
           "    }\n" +
            "  ]\n" +
            "}";


    public void postOAuth() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.header("Authorization", "Bearer " + token);
        request.formParams("grant_type", grantType, "client_id", clientId, "client_secret", clientSec, "username", username, "password", password + secretToken);
        Response response = request.post("/services/oauth2/token");
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        accessToken = JsonPath.from(jsonString).get("access_token");
        Assertions.assertEquals(200, response.statusCode());
        System.out.println("First API Call successfull");
    }

    public void locateCopy() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + accessToken);
        request.body(jsonObject);
        Response response = request.post("/services/data/v53.0/composite/graph");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
        System.out.println("Second API Call successfull");

    }

    public void login() {
        System.out.println("Launching browser");
        // WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get(base_url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mpolan@systemadmin.bhereports");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password1234");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        System.out.println("Clicked login");

    }

    public void verifyServiceAppointStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(d -> driver.findElement(By.xpath("//*[@title='Minimize']")).isDisplayed());
        driver.findElement(By.xpath("//*[@title='Minimize']")).click();
        System.out.println("Clicked Minimize");
        wait.until(d -> driver.findElement(By.xpath("//a[@title='Field Service']")).isDisplayed());
        driver.findElement(By.xpath("//a[@title='Field Service']")).click();
        wait.withTimeout(Duration.ofSeconds(60));
       System.out.println("Clicked Field Service");


       //wait.until(d ->driver.findElement(By.xpath("//button[@aria-label='Search']"))).isDisplayed();



        driver.switchTo().frame(0);

        wait.until(d -> driver.findElement(By.xpath("//*[@id='TaskSearchFilterInput']")).isDisplayed());
        driver.findElement(By.xpath("//*[@id='TaskSearchFilterInput']")).sendKeys(serviceTicketId);
        //driver.findElement(By.xpath("//*[@data-key='search']")).sendKeys(serviceTicketId);
        System.out.println("Entered text: " + serviceTicketId);


    }

    public void dispatchServiceAppointment() throws InterruptedException {
//        // Verify Service apointment number

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
      wait.until(d -> driver.findElement(By.xpath("//*[@class='SingleTask DraggableSingleTask']/div[@class='SingleTaskColumn truncate Field-STRING'][1]")).isDisplayed());
    String serviceNumber = driver.findElement(By.xpath("//*[@class='SingleTask DraggableSingleTask']/div[@class='SingleTaskColumn truncate Field-STRING'][1]")).getText();
     String status = driver.findElement(By.xpath("//*[@class='SingleTask DraggableSingleTask']/div[@class='SingleTaskColumn truncate Field-PICKLIST']")).getText();
       System.out.println(serviceNumber);
       System.out.println(status);
     driver.findElement(By.xpath("//*[@class='SingleTaskCheckboxAndColor']/input[@type='checkbox']")).click();
//////        // driver.findElement(By.xpath("//*[@title='Dispatch']")).click();
       driver.findElement(By.xpath("//*[@title='Schedule']")).click();

       driver.findElement(By.xpath("//*[@placeholder='Search resources']")).sendKeys("Daniel");
       driver.switchTo().defaultContent();

       driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Search...']")).sendKeys(serviceTicketId);

        wait.until(d ->driver.findElement(By.xpath("//span[@part='formatted-rich-text'][contains(text(),'G-ALBION_CS-BHEALBN-0-20220910-09')]")).isDisplayed());
        driver.findElement(By.xpath("//span[@part='formatted-rich-text'][contains(text(),'G-ALBION_CS-BHEALBN-0-20220910-09')]")).click();
        wait.until(d ->driver.findElement(By.xpath("//a[contains(text(),'SA-')]")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'SA-')]")).click();
        wait.until(d ->driver.findElement(By.xpath("//span[contains(text(),'Edit Status')]/parent::*")).isDisplayed());
        driver.findElement(By.xpath("//span[contains(text(),'Edit Status')]/parent::*")).click();
        wait.until(d ->driver.findElement(By.xpath("//a[contains(text(),'Scheduled')]")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'Scheduled')]")).click();
        wait.until(d ->driver.findElement(By.xpath("//a[contains(text(),'Dispatched')]")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'Dispatched')]")).click();
        driver.findElement(By.xpath("//*[@title='Save']")).click();
        driver.quit();




     //   wait.until(d -> driver.findElement(By.xpath("//*[@class='serviceNumber']")).isDisplayed());


    }


    public void simulatorTest() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723";
        url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("platformName", "iOS");
       capabilities.setCapability("useNewWDA", true);
   capabilities.setCapability("appium:noReset", true);
   capabilities.setCapability("USE_PREBUILT_WDA", false);
     capabilities.setCapability("appium:platformVersion", "16.2");
      //capabilities.setCapability("appium:deviceName", "iPad Pro (12.9-inch)");
    capabilities.setCapability("appium:automationName", "XCUITest");
      capabilities.setCapability("appium:udid", "BCC1CA64-03FD-421F-865C-ADB1F70EEB1C");
     capabilities.setCapability("appium:app", "/Users/miipe/Desktop/Appium Inspector/FieldServiceApp-Simulator-248.0.47-iOS.zip");
     capabilities.setCapability("appium:newCommandTimeout", "50000");

     mobileDriver = new IOSDriver(url, capabilities);


//    capabilities.setCapability("platformName", "iOS");
//   capabilities.setCapability("useNewWDA", false);
//////////        capabilities.setCapability("appium:noReset", true);
//    capabilities.setCapability("appium:platformVersion", "16.2");
//     capabilities.setCapability("appium:deviceName", "iPad Pro (11-inch)");
//    capabilities.setCapability("appium:automationName", "XCUITest");
//  capabilities.setCapability("appium:udid", "552ED69D-7D92-4C59-9E5E-787B47A49606");
//   mobileDriver = new IOSDriver(url, capabilities);

//        mobileDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='Get started - Go to next slide']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Skip']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Log In']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='I Accept']")).click();
//
//
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='choose connection button']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Sandbox']")).click();
//
//        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        // mobileDriver.findElement(By.className("//XCUIElementTypeTextField")).sendKeys("daniel.silva@technician.bhereports");
//
//
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeSecureTextField")).sendKeys("Password123");
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Username']")).sendKeys("daniel.silva@technician.bhereports");
//        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='Go']")).click();
//       // mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@label='Log In']")).click();
//
//        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=' Allow ']")).click();
//
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name='Passcode field']")).sendKeys("miipe" + "\n");
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Turn on Location Services']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='Allow While Using App']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Turn on Notifications']")).click();
//        mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page'])[2]")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Enable Camera Access']")).click();
//        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();

        mobileDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
       // mobileDriver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name='Passcode field']")).sendKeys("miipe" + "\n");
       // mobileDriver.findElement(By.xpath("//XCUIElementTypeImage[@name='LightningDesignSystem.sldsIcon.utility/notification']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='NavRail.view' and @label='Profile']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='DataSyncPrimingCell.syncButton']")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='NavRail.view' and @label='Schedule']")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='ScheduleListItemView.addressLabel']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='ActionBarHeaderView.headerTitleLabel']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeCell[@name='ActionBarCell'])[1]")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Travel']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Next'])[3]")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Next'])[3]")).click();


        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='ActionBarHeaderView.headerTitleLabel']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeCell[@name='ActionBarCell'])[1]")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Start Work']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Next'])[3]")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       // mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Next'])[3]")).click();

        mobileDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='ActionBarHeaderView.headerTitleLabel']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeCell[@name='ActionBarCell'])[1]")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Completed']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Next'])[3]")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeTextView")).sendKeys("Done");
        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeOther[@name='Next']")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='Today's Service Appointments']")).click();
        mobileDriver.findElement(By.xpath("(//XCUIElementTypeButton[@name='appointment.actions'])[1]")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='View Detail']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='NavRail.view' and @label='Profile']")).click();
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='DataSyncPrimingCell.syncButton']")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        mobileDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='NavRail.view' and @label='Schedule']")).click();
        mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



        //XCUIElementTypeButton[@name="NavRail.view" and @label="Profile"]
        //XCUIElementTypeButton[@name="DataSyncPrimingCell.syncButton"]
        //XCUIElementTypeButton[@name="NavRail.view" and @label="Schedule"]
        //XCUIElementTypeButton[@name="Today's Service Appointments"]
        //XCUIElementTypeButton[@name="appointment.actions"])[2]
        //XCUIElementTypeButton[@name="View Detail"]
        //XCUIElementTypeButton[@name="appointment.actions"])[1]



















    }



    public void  CompletedServiceJob ()

    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(d -> driver.findElement(By.xpath("//*[@title='Minimize']")).isDisplayed());
        driver.findElement(By.xpath("//*[@title='Minimize']")).click();
        System.out.println("Clicked Minimize");
        wait.until(d -> driver.findElement(By.xpath("//a[@title='Field Service']")).isDisplayed());
        driver.findElement(By.xpath("//a[@title='Field Service']")).click();
        System.out.println("Clicked Field Service");
        driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Search...']")).sendKeys(serviceTicketId);

        wait.until(d ->driver.findElement(By.xpath("//span[@part='formatted-rich-text'][contains(text(),'G-ALBION_CS-BHEALBN-0-20220910-09')]")).isDisplayed());
        driver.findElement(By.xpath("//span[@part='formatted-rich-text'][contains(text(),'G-ALBION_CS-BHEALBN-0-20220910-09')]")).click();
        wait.until(d ->driver.findElement(By.xpath("//a[contains(text(),'SA-')]")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'SA-')]")).click();
        wait.until(d ->driver.findElement(By.xpath("//span[contains(text(),'Edit Status')]/parent::*/preceding-sibling::span/span"))).isDisplayed();
        String Status= driver.findElement(By.xpath("//span[contains(text(),'Edit Status')]/parent::*/preceding-sibling::span/span")).getText();
        assert Status.equals(completedstatus);
        driver.quit();


//        driver.switchTo().frame(0);
//        //wait.until(d -> driver.findElement(By.xpath("//*[@id='TaskSearchFilterInput']")).isDisplayed());
//       // driver.findElement(By.xpath("//*[@id='TaskSearchFilterInput']")).sendKeys(serviceTicketId);
//        wait.until(d ->driver.findElement(By.xpath("//*[@placeholder='Search resources']")).isDisplayed());
//        driver.findElement(By.xpath("//*[@placeholder='Search resources']")).sendKeys("Daniel");
//        driver.quit();
//        //wait.until(d ->driver.findElement(By.xpath("//*[@title='Daniel Silva']")).isDisplayed());

    }



}



