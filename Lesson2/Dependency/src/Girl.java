public class Girl {
    public String name;
    IOutfit outfit;

    public Girl(String name, IOutfit outfit) {
        this.name = name;
        this.outfit = outfit;
    }

    public  void setOutfit( IOutfit outfit){
        this.outfit = outfit;
    }

    public void showOutfit(){
        System.out.println("Cô gái: "+name);
        outfit.wear();
    }
}
