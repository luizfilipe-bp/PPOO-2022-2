import java.util.List;

import dadosJogo.Controle;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        Controle controle = new Controle();
        List<SerieDados> dados = controle.getSeriesDados();

        VisualizadorSeries visualizadorSeries = new VisualizadorSeries(dados);
        visualizadorSeries.exibir();
        //exibirDados(dados);
    }

    private void exibirDados(List<SerieDados> dados) {
        for(SerieDados dado: dados) {
            System.out.println("Dados da serie " + dado.obterIdentificacaoSerie());
            int diaFinal = dado.obterDiaFinal();
            for(int dia = dado.obterDiaInicial(); dia <= diaFinal; dia++){
                System.out.println("Dia "+ dia + ": " + dado.obterDado(dia));
            }
            System.out.println();
        }
    }
}
