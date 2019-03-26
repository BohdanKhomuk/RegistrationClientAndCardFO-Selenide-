package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Selenide.$x;

public class TaxpayerDetails {

    private Frame frame = new Frame ();

    public String getHeadingText(){
        frame.tabFrame( "Tab1" );
        return $x(("//*[@id = 'tb_main']/tbody/tr[1]/td/label")).getText ();
    }
}
