import java.util.HashMap;
public class Zoologico {
    private HashMap<String, Animal> animal;
    //Construtor
    public Zoologico(){
        animal = new HashMap<>();
    }
    //Métodos para adicionar um novo animal
    public void adicionarEma(String nome, String qualidadeVoo) {
        this.animal.put(nome, new Ema(nome, qualidadeVoo));
    }
    public void adicionarLeao(String nome, String corDoPelo) {
        this.animal.put(nome, new Leao(nome, corDoPelo));
    }
    public void adicionarGorila(String nome, String corDoPelo) {
        this.animal.put(nome, new Gorila(nome, corDoPelo));
    }
    public void adicionarArara(String nome, String qualidadeVoo) {
        this.animal.put(nome,  new Arara(nome, qualidadeVoo));
    }

    //Retorna a descrição de um unico animal a partir de seu nome
    public String getDescricaoLongaAnimal(String nome) {
        if(animal.get(nome) != null){
            return animal.get(nome).getDescricaoLonga();  
        }

        return "Não foi encontrado um animal com esse nome";
    }
    //Retorna uma string com a descrição resumida de todos os animais
    public String getDescricaoResumidaTodos() {
        String texto = "";
        for(String nomeAnimal: animal.keySet()){
            texto += animal.get(nomeAnimal).getDescricaoResumida() + "\n";
        }
        return texto;
    }
    //Retorna uma string com a descricao completa de todos os animais
    public String getDescricaoLongaTodos() {
        String texto = "";
        for(String nomeAnimal: animal.keySet()){
            texto += animal.get(nomeAnimal).getDescricaoLonga() + "\n";
        }
        return texto;
    }
}
