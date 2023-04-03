/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

import java.util.Scanner;
public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    private Scanner entrada;  
    private Sobrevivente sobrevivente;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
        entrada = new Scanner(System.in);
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente sala, cozinha, deposito, jardim, banheiro, quarto;
      
        // cria os ambientes
        sala = new Ambiente("na sala e procura algo para se defender. ");
        cozinha = new Ambiente("na cozinha. ");
        jardim = new Ambiente("no jardim da casa. ");
        quarto = new Ambiente("no quarto de casal. ");
        
        Item itemDeposito = new Item("Pistola", "uma Pistola, ela parece estar com munição. ");
        deposito = new Ambiente("no deposito da cozinha. ", itemDeposito);
        Item itemBanheiro = new Item("Lanterna", "uma Lanterna, não é algo util contra os zumbis. ");
        banheiro = new Ambiente("no banheiro. ", itemBanheiro);

        sala.ajustarSaidas("norte", jardim);
        sala.ajustarSaidas("leste", cozinha);
        sala.ajustarSaidas("sul", quarto);
        cozinha.ajustarSaidas("sul", deposito);
        cozinha.ajustarSaidas("oeste", sala);
        deposito.ajustarSaidas("norte", cozinha);
        jardim.ajustarSaidas("sul", sala);
        banheiro.ajustarSaidas("leste", quarto);
        quarto.ajustarSaidas("norte", sala);
        quarto.ajustarSaidas("oeste", banheiro);
        
        ambienteAtual = sala;  // o jogo comeca na sala
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        System.out.print("Digite seu nome: ");
        String nomeJogador = entrada.nextLine();
        sobrevivente = new Sobrevivente(nomeJogador);
    
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao World full of Zombies!");
        System.out.println("World full of Zombies é um novo jogo de aventura, você está em um mundo cheio de zumbis");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
    
        imprimirLocalizacaoAtual();
    }

    private void imprimirLocalizacaoAtual() {
        System.out.print(ambienteAtual.getDescricao());
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if(palavraDeComando.equals("observar")) {
            observar();
        }
        else if(palavraDeComando.equals("pegar")) {
            pegar(comando);
        }
        else if(palavraDeComando.equals("inventario")) {
            inventario();
        }
        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce entra em uma casa abandonada");
        System.out.println("para fugir dos zumbis.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println(analisador.getComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            imprimirLocalizacaoAtual();
        }
    }

    private void observar(){
        System.out.println(ambienteAtual.getDescricaoLonga());
    }

//Permite que o sobrevivente pegue um item do ambiente
    private void pegar(Comando comando) {
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();
        //se existe o item no ambiente ele é coletado
        if(ambienteAtual.possuiItem() && (ambienteAtual.getNomeItem().equals(nomeItem))){
            sobrevivente.adicionarItem(ambienteAtual.pegarItem());
            System.out.println("Você coletou o item");
            
        }else{
            System.out.println("Não existe esse item no ambiente. ");
        }
    }
//Mostra os itens no inventario do sobrevivente
    private void inventario() {
        System.out.println(sobrevivente.getItens());
    }
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }
}
