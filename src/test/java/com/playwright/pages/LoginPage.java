package com.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private final Locator userNameTextBox;
    private  final Locator passwordTextBox ;

    private  final Locator loginButton ;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameTextBox = page.getByPlaceholder("Username");
        this.passwordTextBox = page.getByPlaceholder("Password");
        this.loginButton = page.locator("button.orangehrm-login-button");

    }

    public void enterUsername(String username){
       userNameTextBox.fill(username);

    }

    public void enterPassword(String password){
       passwordTextBox.fill(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
