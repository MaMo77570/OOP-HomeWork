public class Eyleyici implements IEyleyici{
    private String sogutucuDurumu ;

    Eyleyici(){
        sogutucuDurumu = "Closed";            //  sogutucu kaoaniyor
    }

    public void islemYap(){
            SogutucuAc();             //  sogutucu aciyoruz
            SogutucuKapat();
    }

    public String SogutucuAc(){
        if (sogutucuDurumu == "Closed"){
            durumuGuncelle("Open");
            return "Cooler Turns On ...\n Cooler Open ... " ;
        }
        else {
            return "Your Work have Done \n Cooler Already Open";
        }
    }

    public String SogutucuKapat(){
        if(sogutucuDurumu == "Open"){
            durumuGuncelle("Close");
            return "Cooler is closing ...\n Cooler is closed ... " ;
        }
        else {
            return "Your Work have Done \n Cooler Already closed";
        }
    }

    private void durumuGuncelle(String durum){
        this.sogutucuDurumu = durum;
    }

}
