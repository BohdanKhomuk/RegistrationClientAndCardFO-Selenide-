package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Selenide.$x;

public class CDO {

    private Frame frame = new Frame ();

    public String getHeadingText(){
        frame.tabFrame( "Tab8" );
        return $x(("//*[@id = 'clmode']/following-sibling::h1")).getText ();
    }
}
