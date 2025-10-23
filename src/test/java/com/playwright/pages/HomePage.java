package com.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class HomePage {
    private Page page;

    private final Locator dashboardTitle;


    public HomePage(Page page) {
        this.page = page;
        this.dashboardTitle  = page.locator("h6:has-text('Dashboard')");


    }

    public void isDashboardVisible(){
       dashboardTitle.isVisible();

    }

    public void verifyDashboardTitle(String expected){
        String title = dashboardTitle.textContent();
        Assert.assertEquals(title.trim(), expected, "Dashboard title text does not match!");


    }
}
