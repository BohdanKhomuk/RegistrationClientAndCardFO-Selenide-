package com.test.registrationCardFO;

import com.codeborne.selenide.SelenideElement;
import com.test.methods.CheckPageAvailability;
import com.test.methods.Frame;
import com.test.methods.ReadingFromFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class CustomerAccounts {

    private Frame frame = new Frame ();
    private CheckPageAvailability checkPageAvailability = new CheckPageAvailability ();

    public String getTextBtnSPECPARAM_INT(){
        return $(("#btnSPECPARAM_INT")).getText ();
    }

    public String getTextBtnDPT(){
        return $(("#btnDPT")).getText ();
    }

    public String getTextBtnBPK(){
        return $(("#btnBPK")).getText ();
    }

    public String getTextBtnCVK(){
        return $(("#btnCVK")).getText ();
    }

    private void saveOptions() throws IOException {
        frame.todefCont ();
        List<SelenideElement> linkElements1 = $$(By.tagName("head"));
        System.out.println ( linkElements1 );
        $("#btSave").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab3");

        //Confirmation window 1
        checkPageAvailability.threePage ("T1" );
        $("#btOk").shouldBe(visible).click ();

        //Confirmation window 2
        checkPageAvailability.threePage ( "T1" );

        if (ReadingFromFile.read ( "Polygon.txt" ).equals( "DB OBMMFOT" )) {
            Runtime.getRuntime ( ).exec ( ".\\Cancel.exe" );
            switchTo ( ).defaultContent ( );
        }

        $x("//*[@value='Ok']").shouldBe(visible).click ();
        //getWebDriver ().navigate ().refresh ();
        checkPageAvailability.twoPage ( "ctl00" );

        // $("#bTab3").shouldBe(visible).click ();
        String mainWindows = getWebDriver ().getWindowHandle();
        System.out.println ( "Win01 " + mainWindows );
        switchTo ().window ( mainWindows ).close ();
        ArrayList<String> tabs1237 = new ArrayList<> ( getWebDriver ().getWindowHandles ( ) );
        System.out.println ( "tabs1237" + tabs1237 );
        switchTo ( ).window ( tabs1237.get ( 0 ) );
        System.out.println ( "Win7 " + tabs1237 );
        String mainWindows2117 = getWebDriver ().getWindowHandle ( );
        System.out.println ( "21first7 " + mainWindows2117 );
        SelenideElement elementID7 = $x("//*[@id]");
        String id7 = elementID7.getAttribute ( "id" );     // for getting id of each element
        System.out.println ( "id7 " + id7 );
    }

    public void saveOptionsEdit() {
        frame.todefCont ();
        List<SelenideElement> linkElements1 = $$(By.tagName("head"));
        System.out.println ( linkElements1 );
        $("#btSave").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab3");

        //Confirmation window 1
        checkPageAvailability.threePage ("T1" );
        $("#btOk").shouldBe(visible).click ();

        //Confirmation window 2
        checkPageAvailability.threePage ( "T1" );
        $x("//*[@value='Ok']").shouldBe(visible).click ();
        checkPageAvailability.twoPage ( "ctl00" );

        // $("#bTab3").shouldBe(visible).click ();
        String mainWindows = getWebDriver ().getWindowHandle();
        switchTo ().window ( mainWindows ).close ();
        ArrayList<String> tabs1237 = new ArrayList<> ( getWebDriver ().getWindowHandles ( ) );
        switchTo ( ).window ( tabs1237.get ( 0 ) );
        SelenideElement elementID7 = $x("//*[@id]");
    }

    public void createCustAcc(String nsb, String value) throws IOException {

        $("#btOpen").shouldBe(visible).click ();

        ArrayList<String> tabs123443 = new ArrayList<> (getWebDriver ().getWindowHandles());
        switchTo().window(tabs123443.get(0));
        SelenideElement elementID13 = $x("//*[@id]");
        String id1344 = elementID13.getAttribute("id");     // for getting id of each element
        System.out.println ( "id1344 " + id1344 );
        checkPageAvailability.twoPage ( "ctl00" );
        getWebDriver ().manage ().window ().maximize ();
        frame.toTabFrameAcc("#Tab0");
        $("#tbNbs").shouldBe(visible).setValue ( nsb );
        $("#bAccountMask").shouldBe(visible).click ();
        $("#ddOb22").shouldBe(visible).click ();
        //new Actions(driver).moveByOffset(1, 1).click().build().perform();
        checkPageAvailability.threePage ( "webService" );
        $("#td_21").shouldBe(visible).click ();
        checkPageAvailability.twoPage ( "ctl00" );

        //Other
        $("#bTab3").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab3");

        if (ReadingFromFile.read ( "Polygon.txt" ).equals( " " )){
            $("#btnOTHERS").shouldBe(visible).click ();
            frame.toTabFrameAcc("#Tab3");
            $("#HREF_1").shouldBe(visible).click ();
            String mainWindows10 = getWebDriver ().getWindowHandle(); //запоминаем первое окно
            for(String windowsHandls : getWebDriver ().getWindowHandles()){
                if(!windowsHandls.equals(mainWindows10)){
                    switchTo().window(windowsHandls);
                }
            }
            $("#r_1").shouldBe(visible).click ();
            switchTo().window(mainWindows10);
            frame.toTabFrameAcc ("#Tab0");
            $("#btnSPECPARAM").shouldBe(visible).click ();
        }

        $("#VALUE_5").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_4").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_3").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_2").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        this.saveOptions();
    }

    public void editCustAcc(String nlsAlt){
        frame.toMainFrame();
        $("#btFind").shouldBe(visible).click ();
        $("#r_1").shouldBe(visible).click ();

        String mainWindows22 = getWebDriver ().getWindowHandle();

        $("#btEdit").shouldBe(visible).click ();
        for(String windowsHandls1234 : getWebDriver ().getWindowHandles()){
            if(!windowsHandls1234.equals(mainWindows22)){
                switchTo().window(windowsHandls1234);
            }
        }

        frame.toTabFrameAcc("#Tab0");
        getWebDriver ().manage ().window ().maximize ();
        $("#tbNlsAlt").shouldBe(visible).setValue ( nlsAlt );
        //Financial details -----------------------------//
        frame.todefCont ();
        $("#bTab1").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab1");
        $("#ddVidBlkD").shouldBe(visible).click ();

        String mainWindows3 = getWebDriver().getWindowHandle(); //запоминаем первое окно
        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows3);
        frame.toTabFrameAcc("#Tab1");
        $("#ddVidBlkK").shouldBe(visible).click ();
        String mainWindows45 = getWebDriver ().getWindowHandle(); //запоминаем первое окно
        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows45);
        frame.todefCont ();
        //Access rights ---------------------------------//
        $("#bTab2").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab2");
        $("#btAdd").shouldBe(visible).click ();
        String mainWindows5 = getWebDriver().getWindowHandle(); //запоминаем первое окно

        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows5);
        frame.todefCont ();
        //Special parameters
        $("#bTab3").shouldBe(visible).click ();
        frame.toTabFrameAcc("#Tab3");
        $("#btnSPECPARAM").shouldBe(visible).click ();
    }

    public void closeCustAcc(String nls){
        frame.toMainFrame();
        $("#tbFindNls").shouldBe(visible).setValue ( nls );
        $("#btFind").shouldBe(visible).click ();
        $("#r_1").shouldBe(visible).click ();
        $("#btClose").shouldBe(visible).click ();
        $("#closureReason5").shouldBe(visible).click ();
        $("#alertify-ok").shouldBe(visible).click ();
        String mainWindows6 = getWebDriver ().getWindowHandle();
        for(String windowsHandls : getWebDriver ().getWindowHandles()){
            if(!windowsHandls.equals(mainWindows6)){
                switchTo().window(windowsHandls);
            }
        }
        checkPageAvailability.twoPage ( "T1" );
        //$x("//input[@value = 'Ok']").shouldBe(visible).click ();
        Actions action = new Actions(getWebDriver ());
        action.sendKeys( Keys.ENTER).build().perform();
        switchTo().window(mainWindows6);
    }
}

