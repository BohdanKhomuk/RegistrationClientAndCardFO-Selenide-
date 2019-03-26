package com.test.registrationClientFO;

import com.test.methods.Frame;

import static com.codeborne.selenide.Selenide.$x;

public class CDO {

    private Frame frame = new Frame ();

    public String getHeadingText(){
        frame.tabFrame( "Tab8" );
        return $x(("///h1[text() = 'Підключення користувачів до Систем Дистанційного Обслуговування (СДО)']")).getText ();
    }
}
