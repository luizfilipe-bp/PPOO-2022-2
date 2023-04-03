public class Item {
    private String nome;
    private String descricao;
    
    //Construtor

    public Item(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

}
