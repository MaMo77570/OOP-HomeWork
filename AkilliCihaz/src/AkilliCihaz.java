public class AkilliCihaz  {

    private IEyleyici eyleyici;                                 // interface  IEyleyici olarak tanmladim
    private ISicaklikAlgilayici sicaklikAlgilayici;             // interface  sicaklikAlgilayici olarak tanmladim
    private IAgArayuzu agArayuzu;                              //interface  IAgArayuzu olarak tanmladim
    private Veritabani veritaban;                               //iVeritabani tanmladim
    private Publisher p;                                       // Publisher'da arrayList olusturdum

    private static final String SOGUTUCU_AC = "1";           //  birinci islem SOGUTUCU_AC
    private static final String SOGUTUCU_KAPAT = "2";        // ikinci islem  SOGUTUCU_KAPAT
    private static final String SICAKLIK_GOTUNTULE = "3";   // ucuncu islem SICAKLIK_GOTUNTULE
    private static final String CIKIS = "4";               // dorduncu islem  CIKIS

    private static AkilliCihaz instance;       // yeniden  AkilliCihaz donuyor

    public static synchronized AkilliCihaz getInstance(){
        if(instance==null)
            instance = new AkilliCihaz();
        return instance;
    }

    private AkilliCihaz(){
        veritaban = new Veritabani();
        eyleyici =new Eyleyici();
        sicaklikAlgilayici =new SicaklikAlgilayici();
        agArayuzu= new AgArayuzu(eyleyici , sicaklikAlgilayici);
        p = new Publisher();
    }

    public void basla(){
        agArayuzu.mesajYazdir("_______________Welcome____________");
        User kullanici ;
        do {
            agArayuzu.mesajYazdir("Enter Your userName : ");
            String userName = agArayuzu.veriAl();
            agArayuzu.mesajYazdir("Enter Your Password         : ");
            String password = agArayuzu.veriAl();
            kullanici = new User(userName, password);


            if (kullanici.isKontrol()) {
                agArayuzu.mesajYazdir("Your Access is successfully ... ");
            }
            else {
                agArayuzu.mesajYazdir("Your userName or passwoerd is not true ... please try again");
            }
        }while (!kullanici.isKontrol());

        p.attach(kullanici);

        islemSec();

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void islemSec(){
        String secim;
        do {
            secim = anaMenuGoster();

            switch (secim){
                case SOGUTUCU_AC :
                    p.notify(eyleyici.SogutucuAc());
//                    agArayuzu.mesajYazdir(eyleyici.SogutucuAc());
                    break;
                case SOGUTUCU_KAPAT:
                    p.notify(eyleyici.SogutucuKapat());
//                    agArayuzu.mesajYazdir(eyleyici.SogutucuKapat());
                    break;
                case SICAKLIK_GOTUNTULE:
                    agArayuzu.SicaklikGonder(sicaklikAlgilayici.sicaklikGonder());
                    break;
                case CIKIS:
                    agArayuzu.mesajYazdir("Your are siging out ....");
                    agArayuzu.mesajYazdir(">>> Good By <<< " +
                                  ">>> Tesekkur Edırız Celal Hocam<<<"   );
                    break;
                default:
                    agArayuzu.mesajYazdir("Your choising is not true , please choose again ...");
                    break;
            }
        }while(!secim.equals(CIKIS));
    }

    private String anaMenuGoster(){
        agArayuzu.mesajYazdir("<><><>><><><><><><><><><><><><><><><><>");
        agArayuzu.mesajYazdir(" *****************The main Menu *****************");
        agArayuzu.mesajYazdir("1. Open Cooler");
        agArayuzu.mesajYazdir("2. Close Cooler");
        agArayuzu.mesajYazdir("3. show temperature");
        agArayuzu.mesajYazdir("4. Sign out ");
        agArayuzu.mesajYazdir("Please choose one option : ");
        return agArayuzu.veriAl();
    }

}
