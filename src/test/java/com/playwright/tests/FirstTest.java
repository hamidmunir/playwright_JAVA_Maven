package com.playwright.tests;

import com.playwright.base.BaseTest;
import com.playwright.pages.HomePage;
import com.playwright.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {


    @Test
    public void login(){
        test = extent.createTest("Verify Login and Dashboard Title");
        LoginPage loginPage = new LoginPage(page);
        test.info("adding username");
        loginPage.enterUsername("Admin");

        test.info("adding password");
        loginPage.enterPassword("admin123");

        test.info("clicking login button");
        loginPage.clickLoginButton();


    }

    @Test
    public void verifyDashboard(){
        test = extent.createTest("Verify Dashboard title");
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        test.info("adding username");
        loginPage.enterUsername("Admin");

        test.info("adding password");
        loginPage.enterPassword("admin123");

        test.info("clicking login button");
        loginPage.clickLoginButton();

        test.info("verify dashboard is visible");
        homePage.isDashboardVisible();

        test.info("verify dashboard title");
        homePage.verifyDashboardTitle("Dashboard");




    }

    @Test
    public void failTest(){
        test = extent.createTest("Verify failed test");
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        test.info("adding username");
        loginPage.enterUsername("Admin");

        test.info("adding password");
        loginPage.enterPassword("admin123");

        test.info("clicking login button");
        loginPage.clickLoginButton();

        test.info("verify dashboard is visible");
        homePage.isDashboardVisible();

        test.info("verify dashboard title");
        homePage.verifyDashboardTitle("Failed test");




    }


}
