public class App {
    public static void main(String[] args) {
        IOutfit tshirt = new Tshirt();
        IOutfit bikini = new Bikini();
        Girl normalGirl = new Girl("Normal",tshirt);
        Girl ngocTrinh = new Girl("Ngọc Trinh",bikini);
        normalGirl.showOutfit();
        ngocTrinh.showOutfit();
        ngocTrinh.setOutfit(tshirt);
        ngocTrinh.showOutfit();
    }
}
