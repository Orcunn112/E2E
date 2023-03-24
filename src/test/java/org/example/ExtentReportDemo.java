package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ///

    public WebDriver driver;
    ExtentReports extent;

    @BeforeTest
    public void config() {
//        ExtentReports, ExtentSparkReporter
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Orcunn112");

    }

    @Test
    public void initialDemo() {

        //        WebDriver driver=new FirefoxDriver(); eğer firefox istersen bunu kullan
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        ExtentTest test = extent.createTest("initial Demo");
        driver.get("https://rahulshettyacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.close();
//        test.fail("Result don't macth");
        extent.flush();
//        driver.quit();
    }
}
