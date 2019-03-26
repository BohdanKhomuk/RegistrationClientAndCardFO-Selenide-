package com.test.registrationClientFO;

import com.test.methods.Frame;
import com.test.methods.Gender;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ClientDetails {

    private Frame frame = new Frame ();
    private Gender gender = new Gender();

    private void pressClientSex(){
        String fileName = String.format( "//select[@id = 'ddl_SEX']/option[@value = '%s']", gender.enterGenderNum () );
        $x(fileName ).click();
    }

    private void enterPdate(String pdate){
        $("#ed_PDATE").shouldBe(visible).click ();
        $("#ed_PDATE").shouldBe(visible).sendKeys( pdate );
    }

    private void enterDATE_PHOTO(String datePhoto){
        $("#ed_DATE_PHOTO").shouldBe(visible).click ();
        $("#ed_DATE_PHOTO").shouldBe(visible).sendKeys( datePhoto );
    }

    private void enterBDay(String bDay){
        $("#ed_BDAY").shouldBe(visible).click ();
        $("#ed_BDAY").shouldBe(visible).sendKeys( bDay );
    }

    public String getHeadingText(){
        frame.tabFrame( "Tab3" );
        return $x("//*[@id = 'tblMain']/tbody/tr[1]/td/label").getText();
    }

    public void correctClientDetail(String bPlace, String telW){
        frame.tabFrame( "Tab3" );
        $("#ed_BPLACE").shouldBe(visible).setValue ( bPlace );
        $("#ed_TELW").shouldBe(visible).setValue ( telW );
    }

    public void enterDocumentDetails(String organ, String ser, String numDoc, String passpDate, String datePhoto, String birthday){
        frame.tabFrame( "Tab3" );
        $("#ddl_PASSP").shouldBe(visible).click ();
        $x("//select[@id = 'ddl_PASSP']/option[@value = '1']").shouldBe(visible).click ();
        $("#ed_ORGAN").shouldBe(visible).setValue ( organ );
        $("#ed_SER").shouldBe(visible).setValue ( ser );
        $("#ed_NUMDOC").shouldBe(visible).setValue ( numDoc );
        $("#ddl_SEX").shouldBe(visible).click ();
        this.enterPdate( passpDate );
        this.enterDATE_PHOTO( datePhoto );
        this.enterBDay( birthday );
        this.pressClientSex();
    }

    public void enterNumberPhone(String tel){
        $("#ed_TELM_CODE").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//div[@title = '92']").shouldBe(visible).doubleClick ();
        frame.tabFrame( "Tab3" );
        $("#ed_TELM").shouldBe(visible).setValue ( tel );
        $("#ed_TELD_CODE").shouldBe(visible).click ();
        $("#ed_TELD_CODE").shouldBe(visible).click ();
        frame.kContentFrame();
        $x("//td[@role = 'gridcell']/div[@title]").shouldBe(visible).doubleClick ();
        frame.tabFrame( "Tab3" );
        $("#ed_TELD").shouldBe(visible).setValue ( tel );
    }
}
