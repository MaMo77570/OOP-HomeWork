public class User implements IObserver {
    private String UserName;
    private String Password;
    private boolean Kontrol;
    private Veritabani veritabani;

    User(String UserName , String Password){
        this.UserName = UserName;
        this.Password = Password;
        this.Kontrol = Login(this.UserName,this.Password);
    }

    private boolean Login(String UserName , String Password){                   //burada viritabani knotrol ediyour
        Boolean kontrol =true;
        Veritabani data = new Veritabani();
        kontrol = data.login(UserName,Password);
        return kontrol;
    }

    public boolean isKontrol() {                // kontrol ediyor  eger dogor ise ekranda yazdir
        return Kontrol;
    }

    @Override
    public void update(String mesaj) {
        System.out.println(mesaj);
    }

}
