import java.util.Scanner;


public class AgArayuzu implements IAgArayuzu{

    private IEyleyici eyletici ;               // IEyleyici tanmladim
    private ISicaklikAlgilayici algilayici;       //ISicaklikAlgilayici

    public AgArayuzu(IEyleyici eyletici ,ISicaklikAlgilayici algilayici ){
        this.eyletici = eyletici;
        this.algilayici = algilayici;
    }

    public void mesajYazdir(String mesaj) {            // sonra mesajYazdir ekrana gozukuyor
        System.out.println(mesaj);
    }

    public void SicaklikGonder(int mesaj){          // SicaklikGonder orani ekrana gozukuyor
        System.out.println(mesaj);
    }

    public String veriAl() {                        // data veriAl'den aliyor
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }



}
