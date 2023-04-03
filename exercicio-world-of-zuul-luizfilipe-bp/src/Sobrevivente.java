import java.util.HashMap;

public class Sobrevivente {
    //Atributos
    private String nome;
    private HashMap<String, Item> mochila;

    //Construtor
    public Sobrevivente(String nome) {
        this.nome = nome;
        mochila = new HashMap<>();
    }
    //Métodos
    public String getNome() {
        return nome;
    }
    
    public void adicionarItem(Item item) {
        mochila.put(item.getNome(), item);
    }

    public Item removerItem(String nomeItem) {
        Item itemRemovido = mochila.get(nomeItem);
        mochila.remove(nomeItem);
        return itemRemovido;
    }

    public String getItens() {
        String texto = "";
        if(mochila.size() == 0){
            texto = "A mochila está vazia. ";
        }else{  
            texto = "Itens na mochila: ";          
            for(Item item: mochila.values()) {
                texto = texto + item.getNome() + ' ';
            }
        }
        return texto;
    }
}
