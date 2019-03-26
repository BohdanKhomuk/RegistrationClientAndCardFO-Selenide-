package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Selenide.$x;

public class ConnectedPeople {

    private Frame frame = new Frame ();

    public String getHeadingText(){
        frame.tabFrame( "Tab6" );
        return $x(("//*[@id = 'ctl00_body_pnlCusts']/fieldset/legend")).getText ();
    }
}
