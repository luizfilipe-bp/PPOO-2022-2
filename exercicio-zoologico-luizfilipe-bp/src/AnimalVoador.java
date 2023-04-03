public class AnimalVoador extends Animal {
    //Atributos
    private String qualidadeVoo;

    //Construtor
    public AnimalVoador(String nome, String especie, int quantidadePatas, String somCaracteristico, String qualidadeVoo) {
        super(nome, especie, quantidadePatas, somCaracteristico);
        this.qualidadeVoo = qualidadeVoo;
    }
    //Métodos
    //Retorna a qualidade do voo
    public String getQualidadeVoo(){
        return qualidadeVoo;
    }

    //O método sobreescreve o método da superclasse
    @Override
    public String getDescricaoLonga(){
        String texto = super.getDescricaoLonga() + " e " + getQualidadeVoo();
        return texto;
    }
}
