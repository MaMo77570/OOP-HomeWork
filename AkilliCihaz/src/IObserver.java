public interface IObserver {
    public void update(String m);          // IObserver Publisher'den guncelleniyor
    public boolean isKontrol();
}
