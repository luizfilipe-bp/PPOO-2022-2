public class Conta {
    //Atributos
    private double saldo;
    private Cliente cliente;
    private int nroConta;
    private static int ultimoNroConta = 100;
    private static double rendimento = 0.037;
    //Limite de saldo negativo
    private double limite;

    //Construtores
    public Conta(double limite, Cliente cliente) {
        this.limite = limite;
        this.cliente = cliente;
        saldo = 0;
        ultimoNroConta++;
        nroConta = ultimoNroConta;
    }
    public Conta(double limite, Cliente cliente, double saldo) {
        this(limite, cliente);
        this.saldo = saldo;
    }

    //Métodos
    public void depositar(double valorDepositado) {
        saldo += valorDepositado;
    }
    public boolean sacar(double valorSacado) {
        if((saldo - valorSacado) >= limite){
            saldo -= valorSacado;
            return true;
        }else{
            return false;
        }
    }

    public boolean transferir(double valorRecebido, Conta contaDestino){
        if(this.sacar(valorRecebido)){
            contaDestino.depositar(valorRecebido);
            return true;
        }else{
            return false;
        }
    }

    public void render(){
        saldo = saldo + (saldo * rendimento);
    }

    public static void alterarRendimento(double novoRendimento){
        rendimento = novoRendimento;
    }

    public String getNomeCliente(){
        return cliente.getNome();
    }
    public int getNroConta(){
        return nroConta;
    }
    public double getSaldo() {
        return saldo;
    }
}
