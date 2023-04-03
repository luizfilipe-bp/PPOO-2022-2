package dadosJogo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import series.SerieDados;
public class Controle {
    private List<SerieDados> dadosJogo;

    public Controle(){
        dadosJogo = new ArrayList<>();
        
        int diaInicial = 3;
        int diaFinal = 7;
        
        SerieDadosJogo totalDeJogadores = new SerieDadosJogo("Total de Jogadores logados", diaInicial, diaFinal);
        totalDeJogadores.adicionarDado(3, 100);
        totalDeJogadores.adicionarDado(4, 120);
        totalDeJogadores.adicionarDado(5, 70);
        totalDeJogadores.adicionarDado(6, 280);
        totalDeJogadores.adicionarDado(7, 250);
        dadosJogo.add(totalDeJogadores);

        SerieDadosJogo totalHoras = new SerieDadosJogo("Total de horas gastas no dia", diaInicial, diaFinal);
        totalHoras.adicionarDado(3, 250);
        totalHoras.adicionarDado(4, 300);
        totalHoras.adicionarDado(5, 190);
        totalHoras.adicionarDado(6, 500);
        totalHoras.adicionarDado(7, 370);
        dadosJogo.add(totalHoras);
    }

    public List<SerieDados> getSeriesDados(){
        return Collections.unmodifiableList(dadosJogo);
    }
}
