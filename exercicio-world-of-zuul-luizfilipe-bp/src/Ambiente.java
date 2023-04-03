/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
import java.util.HashMap;

public class Ambiente  {
    // descrição do ambiente
    private String descricao;
    //HashMap de saidas do ambiente
    private HashMap<String, Ambiente> saidas;
    //Item que está no ambiente
    private Item item;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao)  {
        this.descricao = descricao;
        saidas = new HashMap<>();
        this.item = null;
    }

    public Ambiente(String descricao, Item item)  {
        this.descricao = descricao;
        saidas = new HashMap<>();
        this.item = item;
    }

    /**
     * Define as saídas do ambiente. Cada direção ou leva a um outro ambiente ou é null 
     * (indicando que não tem nenhuma saída para lá).
     * @param norte A saída norte.
     * @param leste A saída leste.
     * @param sul A saída sul.
     * @param oeste A saída oeste.
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente)  {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        String texto = "Voce está " + descricao + "\n" + "Saidas: ";
        for(String direcao : saidas.keySet()){
            texto = texto + direcao + " ";
        }
        return texto;
    }

    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    private String getDescricaoItem(){
        if(possuiItem()) {
            return "Você encontrou " + item.getDescricao();
        }else{
            return "O ambiente está vazio";
        }
    }
    public String getDescricaoLonga() {
        return getDescricao() + "\n" + getDescricaoItem();
    }

    public boolean possuiItem() {
        return item != null;
    }

    public Item pegarItem() {
        Item itemJogador;
        if(possuiItem()){
            itemJogador = item;
            item = null;
        }else{
            itemJogador = null;
        }
        return itemJogador;
    }

    public String getNomeItem() {
        if(possuiItem()){
            return item.getNome();
        }else{
            return null;
        }
    }
}
