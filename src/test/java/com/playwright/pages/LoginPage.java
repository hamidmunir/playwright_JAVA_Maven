package com.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private final Locator userNameTextBox;
    private  final Locator passwordTextBox ;

    private  final Locator loginButton ;

    /*Useful locator finding approaches*

    page.locator("#name")  -> By id attribute

    page.locator("input[name='lname'"])  -> By name attribute

    page.locator("input[value='lname'"])  -> By value

    page.locator("select#option") -> find dropdown

    page.locator("//input[@type='fname']") -> Xpath

     */

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
