package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EconomicNorms {

    private Frame frame = new Frame ();

    public void correctDetails(){
        /*frame.tabFrame( "Tab2" );
        $("#ddl_ISE_com").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//*[@title = '11002']").shouldBe(visible).doubleClick ();*/
        frame.tabFrame( "Tab2" );
        $("#ddl_FS_com").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//*[@title = '32']").shouldBe(visible).doubleClick ();
        frame.tabFrame( "Tab2" );
        $("#ddl_VED_com").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//*[@title = 'N2529']").shouldBe(visible).doubleClick ();
        /*frame.tabFrame( "Tab2" );
        $("#ddl_K050_com").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//*[@title= '192']").shouldBe(visible).doubleClick ();*/
    }
}
