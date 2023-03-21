public class App {
    public static void main(String[] args) throws Exception {
        Converter conv = new Converter();
        int active = 0;
        do{
            conv.menu();
            active = conv.closeMenu();
        }while(active >= 0);
    }
}
