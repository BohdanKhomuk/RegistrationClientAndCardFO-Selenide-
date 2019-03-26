package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Selenide.$x;

public class ClientSegments {

    private Frame frame = new Frame ();

    public String getHeadingText(){
        frame.tabFrame( "Tab7" );
        return $x(("//*[@id = 'ctl00_body_pnlCustsSegments']/fieldset/legend")).getText ();
    }
}
