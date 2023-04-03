public class AnimalComPelos extends Animal {
    //Atributos
    private String corDoPelo;

    //Construtor
    public AnimalComPelos(String nome, String especie, int quantidadePatas, String somCaracteristico, String corDoPelo) {
        super(nome, especie, quantidadePatas, somCaracteristico);
        this.corDoPelo = corDoPelo;
    }

    //Métodos
    //Retorna a cor do pelo
    public String getCorDoPelo(){
        return corDoPelo;
    }

    //O método sobreescreve o método da superclasse
    @Override
    public String getDescricaoLonga(){
        String texto = super.getDescricaoLonga() + " e tem pelo " + getCorDoPelo();
        return texto;
    }
    
}
