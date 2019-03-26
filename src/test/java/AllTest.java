import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.test.LoginPage;
import com.test.MainPage;
import com.test.TransitionToRegistration;
import com.test.methods.ConfigProperties;
import com.test.methods.Gender;
import com.test.methods.RandomWordsAndNumber;
import com.test.methods.ReadingFromFile;
import com.test.registrationCardFO.CustomerAccounts;
import com.test.registrationClientFO.*;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.test.LoginPage.getPolygon;


@Listeners({TextReport.class, ScreenShooter.class})

public class AllTest {

    private static LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage ( );
    private TransitionToRegistration transitionToReg = new TransitionToRegistration ();
    private BasicDetails basicDetails = new BasicDetails ();
    private ClientDetails clientDetails = new ClientDetails ();
    private AdditionalInformation addInformation = new AdditionalInformation ();
    private AdditionalDetails addDetails = new AdditionalDetails ();
    private CustomerAccounts customerAccounts = new CustomerAccounts ();
    private TaxpayerDetails taxpayerDetails = new TaxpayerDetails ();
    private EconomicNorms economicNorms = new EconomicNorms ();
    private ConnectedPeople connectedPeople = new ConnectedPeople ();
    private ClientSegments clientSegments = new ClientSegments ();
    private CDO cdo = new CDO ();

    private Gender gender = new Gender ();
    private RandomWordsAndNumber random = new RandomWordsAndNumber();

    @BeforeMethod
        public void testReport() {
        TextReport.onSucceededTest = true;
        TextReport.onFailedTest = true;
    }

    @BeforeClass
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide ().screenshots(true).savePageSource(false));
        timeout = 20000;
        browser = "ie";
        startMaximized = true;
        InternetExplorerDriverManager.getInstance( DriverManagerType.IEXPLORER).arch32().setup();
        open("/");
        loginPage.enterInMainPage ( ConfigProperties.getTestProperty ( "login" ), ConfigProperties.getTestProperty ( "password" ) );

    }

    @Test(priority = 1)
    public void createClientCard() throws Exception {
        mainPage.enterFunction ( "Реєстрація Клієнтів і Рахунків" + "\n" );
        transitionToReg.goingToRegister ( RandomWordsAndNumber.randomNumber ( 10, 99999 ) );
        //      Basic details
        System.out.println((char) 27 + "[33mРеєстрація клієнта(ФО): Основні реквізити" + (char) 27 + "[0m");
        basicDetails.enterFIO( gender.Surname(), gender.Name(), gender.Patronymic() );
        // Clien adress
        basicDetails.enterAddress( RandomWordsAndNumber.randomNumber( 100000, 999999  ), "Київська обл.", "Обухівський район", "Обухівв", "Варвари", "54");
        // IPN
        basicDetails.enterOKPO( "0000000000" );

        System.out.println((char) 27 + "[33mРеєстрація клієнта(ФО): Реквізити клієнта" + (char) 27 + "[0m");
        transitionToReg.clickClientDetailBtn();
        clientDetails.enterDocumentDetails("Овручським районним управлінням",  random.randomStringBig( 2 ), RandomWordsAndNumber.randomNumber( 100000, 999999 ), "10102010", "05022018", "10101992" );
        clientDetails.enterNumberPhone( RandomWordsAndNumber.intRandomNumber( 999999999 ) );

//      Additional information
        System.out.println((char) 27 + "[33mРеєстрація клієнта(ФО): Дод. інформація" + (char) 27 + "[0m");
        transitionToReg.clickAdditionalInformationBtn();
        addInformation.fillingISP();

//         Additional details
        System.out.println((char) 27 + "[33mРеєстрація клієнта(ФО): Дод. реквізити" + (char) 27 + "[0m");
        transitionToReg.clickAdditionalDetailsBtn();
        addDetails.enterGeneral();
        addDetails.enterFinMon( "Українець", "05022017", "05032017", random.randomStringBig( 1 ) + random.randomStringLittle( 10 ),
                random.randomStringBig( 1 ) + random.randomStringLittle( 10 ) );
        addDetails.enterOther();

//      press the "Register" button
        transitionToReg.confirmationReg();
        System.out.println((char) 27 + "[32m[Passed]----------Тест завершено успішно!----------[Passed]" + (char) 27 + "[0m");
    }

    @Test(priority = 2) //enabled = false)
    public void customerAccountTest(){
        mainPage.enterFunction( "Реєстрація Клієнтів і Рахунків" + "\n" );
        System.out.println((char) 27 + "[33mСтворення рахунку клієнта(ФО)" + (char) 27 + "[0m");

        //Find client
        transitionToReg.openCustomerAccounts( ReadingFromFile.read( "ClientRNK.txt" ) );
        //Open customer accounts
        customerAccounts.createCustAcc( "2620", "1" );
        System.out.println((char) 27 + "[32m[Passed]----------Тест створення рахунку клієнта(ФО) завершено успішно!----------[Passed]" + (char) 27 + "[0m");

        System.out.println((char) 27 + "[33mРеєстрація рахунку клієнта(ФО)" + (char) 27 + "[0m");
        customerAccounts.editCustAcc( "213" );
        //Assert.assertEquals("  НБУ   ", customerAccounts.getTextBtnSPECPARAM());
        Assert.assertEquals("  Ощадбанк   ", customerAccounts.getTextBtnSPECPARAM_INT());
        Assert.assertEquals("  Депозити   ", customerAccounts.getTextBtnDPT());
        Assert.assertEquals("  БПК   ", customerAccounts.getTextBtnBPK());
        Assert.assertEquals(" ЦВК  ", customerAccounts.getTextBtnCVK());
        // Assert.assertEquals("  Інші   ", customerAccounts.getTextBtnOTHERS());
        customerAccounts.saveOptions();
        System.out.println((char) 27 + "[32m[Passed]----------Тест редагування рахунку клієнта(ФО) завершено успішно!----------[Passed]" + (char) 27 + "[0m");

        System.out.println((char) 27 + "[33mВидалення рахунку клієнта(ФО)" + (char) 27 + "[0m");
        //Assert.assertEquals( "213", customerAccounts.getTextNLSALT_1() );
        customerAccounts.closeCustAcc("2620");
        System.out.println((char) 27 + "[32m[Passed]----------Тест видалення рахунку клієнта(ФО) завершено успішно!----------[Passed]" + (char) 27 + "[0m");

    }

    @Test (priority = 3) //enabled = false)
    public void editingClientCard() {

        mainPage.enterFunction( "Реєстрація Клієнтів і Рахунків" + "\n" );
        System.out.println((char) 27 + "[33mРедагування карточки клієнта(ФО)" + (char) 27 + "[0m");
        transitionToReg.openClient( ReadingFromFile.read( "ClientRNK.txt" ) );

        basicDetails.enterSAB( RandomWordsAndNumber.intRandomNumber( 9999 ) );

        transitionToReg.clickTaxpayerDetalisBtn();
        Assert.assertEquals( "Заповнити реквізити платника податків", taxpayerDetails.getHeadingText() );

        transitionToReg.clickEconomicNormsBtn();
        economicNorms.correctDetails();

        transitionToReg.clickClientDetailBtn();
        Assert.assertEquals( "Заповнити Персональні реквізити",  clientDetails.getHeadingText() );
        clientDetails.correctClientDetail( random.randomStringBig( 12 ), RandomWordsAndNumber.intRandomNumber( 999999 ));

        transitionToReg.clickAdditionalInformationBtn();
        addInformation.correctDetail( random.randomStringLittle( 12 ), random.randomStringLittle( 12 ), RandomWordsAndNumber.intRandomNumber( 100 ), RandomWordsAndNumber.intRandomNumber( 100 ),
                RandomWordsAndNumber.intRandomNumber( 100 ), RandomWordsAndNumber.intRandomNumber( 100 ), RandomWordsAndNumber.intRandomNumber( 100 ), random.randomStringLittle( 23 ));

        transitionToReg.clickAdditionalDetailsBtn();
        Assert.assertEquals( "Загальні", addDetails.getGeneralText() );
        Assert.assertEquals( "Фін.мон.", addDetails.getFinMonText() );
        Assert.assertEquals( "БПК", addDetails.getBPKText() );
        Assert.assertEquals( "Санкції", addDetails.getSanctionsText() );
        Assert.assertEquals( "Інші", addDetails.getOtherText() );
        Assert.assertEquals( "Критерії ризику", addDetails.getRiskCriteriaText() );

        transitionToReg.clickConnectedPeopleBtn();
        if (getPolygon ( ).equals ( "DB RCMMFO" ) || getPolygon ( ).equals ( "DB MMFOM" ))
            Assert.assertEquals( "Пов`язані особи", connectedPeople.getHeadingText() );

        transitionToReg.clickClientSegmentsBtn();
        Assert.assertEquals( "Загальна інформація", clientSegments.getHeadingText() );

        transitionToReg.clickCDOBtn();
        //Assert.assertEquals( "Підключення користувачів до Систем Дистанційного Обслуговування (СДО)", cdo.getHeadingText() );

        transitionToReg.confirmationReg();
    }

    @Test(priority = 4) //enabled = false)
    public void closeClientCard(){
        mainPage.enterFunction( "Реєстрація Клієнтів і Рахунків" + "\n" );
        System.out.println((char) 27 + "[33mРеєстрація клієнта(ФО)" + (char)27 + "[0m");
        System.out.println((char) 27 + "[33mЗакриття карточки клієнта(ФО)" + (char) 27 + "[0m");
        transitionToReg.closeClient(ReadingFromFile.read( "ClientRNK.txt" ));
    }

    @AfterClass
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
