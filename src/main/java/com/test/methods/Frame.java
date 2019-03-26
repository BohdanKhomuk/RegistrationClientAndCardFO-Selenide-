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

    public void toTab0FrameAcc(){
        todefCont();
        //toMainFrame();
        switchTo().frame( $("#Tab0"));
    }

    public void toTab1FrameAcc(){
        todefCont();
        //toMainFrame();
        switchTo().frame($("#Tab1"));
    }

    public void toTab2FrameAcc(){
        todefCont();
        //toMainFrame();
        switchTo().frame($("#Tab2"));
    }

    public void toTab3Frame(){
        todefCont();
        toMainFrame();
        switchTo().frame($("#Tab3"));
    }

    public void toTab3FrameAcc(){
        todefCont();
        //toMainFrame();
        switchTo().frame($("#Tab3"));
    }


    public void kContentFrame(){
        todefCont();
        toMainFrame();
        switchTo().frame($(".k-content-frame"));
    }

    public void fullAddressFrame(){
        todefCont();
        toMainFrame();
        switchTo().frame( $x("//iframe[@title = 'Повна адреса клієнта']" ));
    }
    public void tabFrame(String path){
        todefCont();
        toMainFrame();
        kContentFrame();
        switchTo().frame( path );
    }
}
