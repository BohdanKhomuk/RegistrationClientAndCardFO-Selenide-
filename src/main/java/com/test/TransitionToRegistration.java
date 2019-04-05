package com.test;

import com.test.methods.Frame;
import com.test.methods.ReadingFromFile;
import com.test.methods.WritingToFile;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TransitionToRegistration {

    private Frame frame = new Frame ();
    private static LoginPage loginPage = new LoginPage();


    public void clickTaxpayerDetalisBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab1"));
        $("#bTab1").shouldBe(visible).click ();
    }

    public void clickEconomicNormsBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab2"));
        $("#bTab2").shouldBe(visible).click ();
    }

    public void clickClientDetailBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab3"));
        $("#bTab3").shouldBe(visible).click ();
    }

    public void clickAdditionalInformationBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab4"));
        $("#bTab4").shouldBe(visible).click ();
    }

    public void clickAdditionalDetailsBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab5"));
        $("#bTab5").shouldBe(visible).click ();
    }

    public void clickConnectedPeopleBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab6"));
        $("#bTab6").shouldBe(visible).click ();
    }

    public void clickClientSegmentsBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab7"));
        $("#bTab7").shouldBe(visible).click ();
    }

    public void clickCDOBtn(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bTab8"));
        $("#bTab8").shouldBe(visible).click ();
    }

    private void clickSearchRowNum(){
        String searchRow = String.format( "//*[contains(text(),'%s')]", ReadingFromFile.read( "ClientRNK.txt" ));
        $x( searchRow ).click();
    }

    private String getInfoText(){
        return  $x("//div[@id='barsUiAlertDialog']/table/tbody/tr/td[2]").getText();
    }


    public void goingToRegister(String newrnk){
        frame.toMainFrame();
        $("#registerCustBtn").shouldBe(visible).click ();
        $x("//div[@class = 'k-window-content k-content']/div/div/div[2]/button").shouldBe(visible).click ();
        $x("//div[@class = 'k-window-content k-content']/div//input[@class ='k-textbox ng-pristine ng-invalid ng-invalid-required']").shouldBe(visible).setValue(newrnk);
        $x("//div[@class = 'k-window-content k-content']/div//button[@class = 'btn btn btn-primary']").shouldBe(visible).click ();

        if ((ReadingFromFile.read ( "Polygon.txt" ).equals ( "DB MMFOM" ))||(ReadingFromFile.read ( "Polygon.txt" ).equals  ( "DB OBIBANM" )) ) {
            $x ( "//button[@class = 'delete-confirm k-button k-primary']" ).shouldBe ( visible ).click ( );
        }

        $x("//button[@class = 'k-button']").shouldBe(visible).click ();
    }

    public void confirmationReg(){
        frame.kContentFrame();
        executeJavaScript("arguments[0].scrollIntoView();", $("#bt_reg"));
        $("#bt_reg").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        if (getInfoText().contains("Помилки")) {
            System.out.println((char) 27 + "[34mНе можна створити клієнта під бранчем '/' - " + (char) 27 + "[0m" + getInfoText());
        }
        String t1 = getInfoText().replace("Клієнта РНК=", "");
        String t2 = t1.replace(" успішно збережено", "");
        System.out.println((char) 27 + "[34mРНК Клієнта - " + (char) 27 + "[0m" + t2);
        WritingToFile.Filewriting( "ClientRNK.txt", t2);
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }

    public void findCard(String rnk){
        frame.toMainFrame();
        $x("//th[@data-field='Id']/a[1]/span").shouldBe(visible).click ();
        $x("//input[@class='k-formatted-value k-input']").shouldBe(visible).setValue(rnk);
        $x("//button[text() = 'фільтрувати']").shouldBe(visible).click ();
        $x("//th[@data-field='Id']/a[1]/span").shouldBe(visible).click ();
        $x("//button[text() = 'фільтрувати']").shouldBe(visible).click ();
}

    public void openClient(String rnk){
        this.findCard( rnk );
        this.clickSearchRowNum();
    }

    public void closeClient(String rnk){
        this.findCard( rnk );
        $x("//span[@class = 'ng-binding']").shouldBe(visible).click ();
        $("#closeCustBtn").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }

    public void openCustomerAccounts(String rnk){
        this.findCard( rnk );
        $x("//span[@class = 'ng-binding']").shouldBe(visible).click ();
        //executeJavaScript("arguments[0].scrollIntoView();", $("#openCustAccsBt"));
        $("#openCustAccsBtn").shouldBe(visible).click ();
    }

    public String checkClose(){
        return $x(("//td[@colspan]")).getText ();
    }
}
