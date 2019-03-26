package com.test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {

    public static String getPolygon() {
        String name = $x ( "//h2" ).shouldBe ( visible ).getText ( );
        System.out.println ( "text " + name );
        return name;
    }

    public void enterInMainPage(String name, String password){
        $("#txtUserName").shouldBe(visible).setValue(name);
        $("#txtPassword").shouldBe(visible).click ();
        $("#txtPassword").shouldBe(visible).setValue ( password );
        $("#btLogIn").shouldBe(visible).click ();
        $("#btChangDate").shouldBe(visible).click ();
        $("#btnBranches").shouldBe(visible).click ();
        $x("(//span[@class = 'k-in'])[2]").shouldBe(visible).click ();
        getWebDriver().navigate ().refresh ();
    }

}



