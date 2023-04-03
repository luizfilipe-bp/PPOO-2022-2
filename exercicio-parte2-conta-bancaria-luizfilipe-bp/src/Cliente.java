public class Cliente {
    //Atributos
    private String cpf;
    private String nome;

    //Construtor
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    //Métodos
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
}
