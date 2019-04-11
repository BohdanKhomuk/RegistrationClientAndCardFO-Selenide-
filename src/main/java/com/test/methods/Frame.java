package com.test.methods;

import static com.codeborne.selenide.Selenide.*;

public class Frame {

    public void todefCont(){
        switchTo().defaultContent();
    }

    public void toMainFrame(){
        todefCont();
        switchTo().frame($("#mainFrame"));
    }

    public void toTabFrameAcc(String path){
        todefCont();
        switchTo().frame( $(path));
    }

    public void kContentFrame(){
        toMainFrame();
        switchTo().frame($(".k-content-frame"));
    }

    public void fullAddressFrame(){
        toMainFrame();
        switchTo().frame( $x("//iframe[@title = 'Повна адреса клієнта']" ));
    }
    public void tabFrame(String path){
        kContentFrame();
        switchTo().frame( path );
    }
}
