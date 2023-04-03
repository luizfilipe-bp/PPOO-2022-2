import java.util.Scanner;
import java.util.ArrayList;

public class CaixaEletronico {
    //Atributos
    private ArrayList<Conta> contas;
    private Scanner entrada;

    //Construtor
    public CaixaEletronico() {
        entrada = new Scanner(System.in);
        contas = new ArrayList<>();
    }
    //Métodos
    private void menu() {
        System.out.println("1. Criar Conta");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Transferência entre contas");
        System.out.println("6. Render saldo");
        System.out.println("7. Alterar rendimento");
        System.out.println("8. Listar todas as contas");
        System.out.println("9. Remover uma conta");
        System.out.println("10. Procurar conta pelo nome");
        System.out.println("11. Sair");
    }

    private void tratamentoOpcao(int opcao) {
        if(opcao == 1){
            criarConta();
        }else if(opcao == 2 && verificarConta()){
            consultarSaldo();
        }else if(opcao == 3 && verificarConta()){
            depositarValor();
        }else if(opcao == 4 && verificarConta()){
            sacarValor();
        }else if(opcao == 5 && verificarConta()){
            transferirValor();
        }else if(opcao == 6 && verificarConta()){  
            renderValor();
        }else if(opcao == 7){
            novoRendimento();
        }else if (opcao == 8 && verificarConta()){
            listarTodasContas();
        }else if(opcao == 9 && verificarConta()){
            removerConta();
        }else if(opcao == 10 && verificarConta()){
            procurarConta();
        }else if(opcao == 11){
            sair();
        }else{
            System.out.println("Digite uma opcao valida");
        }
    }
//Altera o rendimento da classe Conta
    private void novoRendimento(){
        System.out.print("Digite o novo valor de rendimento da conta: ");
        Conta.alterarRendimento(Double.parseDouble(entrada.nextLine()));
    }
//Transfere o valor entre duas contas 
    private void transferirValor(){
        System.out.print("Origem do valor. ");
        Conta contaOrigem = selecionarConta();

        if(contaOrigem != null){
            System.out.print("Destino do valor. ");
            Conta contaDestino = selecionarConta();

            if(contaDestino != null && !contaOrigem.equals(contaDestino)){
                System.out.print("Digite o valor que será retirado da conta: ");
                if(contaOrigem.transferir(Double.parseDouble(entrada.nextLine()), contaDestino)){
                    System.out.println("Valor transferido com sucesso. ");
                }else{
                    System.out.println("Não foi possível realizar a transferência. ");
                }

            }else if(contaOrigem.equals(contaDestino)){
                System.out.println("Não é possível realizar transferência de valores entre a mesma conta!");

            }else{
                System.out.println("Não foi possível realizar a transferência! ");
                
            }
        }else{
            System.out.println("Não foi possível realizar a transferência! ");
        }
    }

//Verifica se as contas já foram criadas
    private boolean verificarConta(){
        if(!contas.isEmpty()){
            return true;
        }else{
            System.out.println("Deve ser criado uma conta antes de realizar essa operação.");
            return false;
        }
    }
    private void menuCriarConta(){
        System.out.println("1. Criar conta com saldo zerado.");
        System.out.println("2. Criar conta com saldo inicial. ");
        System.out.print("Selecione uma opção: ");
    }
    private Cliente criarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = entrada.nextLine();
        return new Cliente(nomeCliente, cpfCliente);
    }
    private double definirLimite(){
        System.out.print("Digite o limite da conta: ");
        double limite = Double.parseDouble(entrada.nextLine());
        if(limite > 0){
            limite *= -1;
        }
        return limite;
    }

//Cria a conta a partir dos métodos criarCliente e definirLimite 
    private void criarConta(){
        Cliente cliente = criarCliente();
        double limite = definirLimite();

        int opcao;
        Conta contaCriada;
        do{
            menuCriarConta();
            opcao = Integer.parseInt(entrada.nextLine());
            if(opcao != 1 && opcao != 2){
                System.out.println("Digite uma opção válida!");
            }
        }while(opcao != 1 && opcao != 2);

        if(opcao == 1){
            contaCriada = new Conta(limite, cliente);

        }else{
            System.out.print("Digite o valor inicial do saldo: ");
            contaCriada = new Conta(limite, cliente, Double.parseDouble(entrada.nextLine()));
        }
        System.out.println("O numero da conta é: " + contaCriada.getNroConta());
        contas.add(contaCriada);
    }

//Seleciona qual conta irá sofrer alguma mudança
    private Conta selecionarConta(){
        System.out.print("Digite o número da conta: ");
        int nroConta = Integer.parseInt(entrada.nextLine());

        for(Conta conta: contas){
            if(conta.getNroConta() == nroConta){
                return conta;
            }
        }
        System.out.println("A conta correspondente ao número digitado não foi encontrada! ");
        return null;
    }

    private void consultarSaldo(){
        Conta contaSelecionada = selecionarConta();
        if(contaSelecionada != null){
            System.out.println("O saldo da conta do cliente " + contaSelecionada.getNomeCliente() +" é de: " + contaSelecionada.getSaldo());
        }
        
    }
    private void depositarValor(){
        Conta contaSelecionada = selecionarConta();
        if(contaSelecionada != null){
            System.out.print("Digite o valor que será depositado: ");
            contaSelecionada.depositar(Double.parseDouble(entrada.nextLine()));
            
            System.out.println("Valor depositado com sucesso.");
        }
    }
    private void sacarValor(){
        Conta contaSelecionada = selecionarConta();
        if(contaSelecionada != null){
            System.out.print("Digite o valor que será sacado: ");
            boolean saqueRealizado = contaSelecionada.sacar(Double.parseDouble(entrada.nextLine()));
            
            if(saqueRealizado){
                System.out.println("Valor sacado com sucesso.");
            }else{
                System.out.println("O valor do saque ultrapassou o limite da conta.");
            }
        }
    }

    private void renderValor(){
        Conta contaSelecionada = selecionarConta();
        if(contaSelecionada != null){
            contaSelecionada.render();
        }
    }

    private void listarTodasContas(){
        for(Conta conta: contas){
            System.out.println("Número da conta: " + conta.getNroConta() + "\t|\t" + "Nome do cliente: " + conta.getNomeCliente());
        }
    }

    private void removerConta(){
        Conta contaSelecionada = selecionarConta();
        if(contaSelecionada.getSaldo() == 0){
            contas.remove(contaSelecionada);
            System.out.println("Conta cancelada com sucesso. ");
        }else if(contaSelecionada.getSaldo() < 0){
            System.out.println("Não é possível cancelar contas que estão em débito. ");
        }else{
            System.out.println("Não é possível cancelar contas que possuem saldo. ");
        }
    }
//Procura contas que contém certa string
    private void procurarConta(){
        System.out.print("Digite o nome do cliente: ");
        String nomeProcurado = entrada.nextLine();
        System.out.println("Contas com nomes correspondentes.");
        for(Conta conta: contas){
            if(conta.getNomeCliente().contains(nomeProcurado)){
                System.out.println("Número da conta: " + conta.getNroConta() + "\t|\t" + "Nome do cliente: " + conta.getNomeCliente());
            }
        }
    }
    private void sair(){
        System.out.println("Saindo do programa.");
    }
    public void executar(){
        int opcao;
        do {
            menu();
            System.out.print("Selecione uma opcao: ");
            opcao = Integer.parseInt(entrada.nextLine());
            tratamentoOpcao(opcao);
            
        }while(opcao != 11);
        entrada.close();
    }
}
