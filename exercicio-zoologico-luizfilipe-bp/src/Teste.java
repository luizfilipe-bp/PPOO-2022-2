public class Teste {
    
    public void main() {
        Animal animal = new Ema("Eminha", "voa mal");
        exibirDescricaoCompleta(animal);

    }
    public void exibirDescricaoCompleta(Animal animal) {
        System.out.println(animal.getDescricaoLonga());
    }
}
