package com.test.registrationClientFO;

import com.test.methods.Frame;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdditionalDetails {

    private Frame frame = new Frame ();

    private void enterCt104Val(String firstFilldData){
        $("#gvMain_ctl04_edEdVal").shouldBe(visible).click ();
        $("#gvMain_ctl04_edEdVal").shouldBe(visible).sendKeys( firstFilldData );
    }

    private void enterCt105Val(String dateOfIdentification){
        $("#gvMain_ctl05_edEdVal").shouldBe(visible).click ();
        $("#gvMain_ctl05_edEdVal").shouldBe(visible).sendKeys( dateOfIdentification );
    }

    public String getGeneralText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Загальні")).getText ();
    }

    public String getFinMonText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Фін.мон.")).getText ();
    }

    public String getBPKText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("БПК")).getText ();
    }

    public String getSanctionsText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Санкції")).getText ();
    }

    public String getCreditRegisterText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Для Кредитного реєстру")).getText ();
    }

    public String getOtherText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Інші")).getText ();
    }

    public String getRiskCriteriaText(){
        frame.tabFrame( "Tab5" );
        return $( By.linkText("Критерії ризику")).getText ();
    }

    public void enterGeneral(){
        frame.tabFrame( "Tab5" );
        $("#gvMain_ctl02_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//div[@title = '2']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }

    public void enterFinMon(String citizenship, String firstFilldData, String dateOfIdentification, String position, String sourcesFunds){
        frame.tabFrame( "Tab5" );
        $x("//a[contains(text(),'Фін.мон')]").shouldBe(visible).click ();
        $("#gvMain_ctl02_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//td[contains(text(),'Відсутні')]").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        frame.tabFrame( "Tab5" );
        $("#gvMain_ctl03_edEdVal").shouldBe(visible).setValue ( citizenship );
        this.enterCt104Val( firstFilldData );
        this.enterCt105Val( dateOfIdentification );
        $("#gvMain_ctl10_edEdVal").shouldBe(visible).setValue ( position );
        $("#gvMain_ctl11_edEdVal").shouldBe(visible).setValue ( sourcesFunds );
        $("#gvMain_ctl06_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//div[@title = 'YES']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        frame.tabFrame( "Tab5" );
        $("#gvMain_ctl08_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//tr[@class = 'k-alt']/td").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        frame.tabFrame( "Tab5" );
        $("#gvMain_ctl09_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//div[@title = 'Задовільний']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }

    public void enterOther(){
        frame.tabFrame( "Tab5" );
        $x("//a[contains(text(),'Інші')]").shouldBe(visible).click ();
        $("#gvMain_ctl03_imgEdHelp").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//div[@title = '1']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }
}
