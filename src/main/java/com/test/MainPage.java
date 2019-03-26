package com.test;

import com.test.methods.Frame;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private Frame frame = new Frame ();

    public void enterFunction(String name){
        frame.todefCont ();
        $("#findOpersText").shouldBe(visible).setValue(name);
        $x("//div[@id='oper-3039']/div[2]/span").shouldBe(visible).click ();
    }
}

