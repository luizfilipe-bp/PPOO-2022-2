public class Animal {
    //Atributos
    private String nome;
    private String especie;
    private int quantidadePatas;
    private String somCaracteristico;

    //Construtor
    public Animal(String nome, String especie, int quantidadePatas, String somCaracteristico) {
        this.nome = nome;
        this.especie = especie;
        this.quantidadePatas = quantidadePatas;
        this.somCaracteristico = somCaracteristico;
    }

    //Métodos
    public String getNome(){
        return nome;
    }    
    public String getEspecie(){
        return especie;
    }
    public int getQuantidadePatas(){
        return quantidadePatas;
    }
    public String getSomCaracteristico(){
        return somCaracteristico;
    }

    public String getDescricaoLonga(){
        String texto = getDescricaoResumida() + " que faz " + somCaracteristico; 
        return texto;
    }
    public String getDescricaoResumida(){
        String texto = nome + " é um(a) " + especie;
        return texto;
    }


}
