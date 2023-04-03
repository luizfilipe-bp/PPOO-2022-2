package dadosJogo;

import java.util.HashMap;
import series.SerieDados;

public class SerieDadosJogo implements SerieDados {
    private String identificacaoSerie;
    private int diaInicial;
    private int diaFinal;
    private HashMap<Integer, Integer> dados;

    public SerieDadosJogo(String identificacaoSerie, int diaInicial, int diaFinal){
        this.identificacaoSerie = identificacaoSerie;
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        dados = new HashMap<>();
    }
    @Override
    public String obterIdentificacaoSerie() {
        return identificacaoSerie;
    }

    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }

    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    @Override
    public int obterDado(int dia) {
        if(dia >= diaInicial && dia <= diaFinal){
            return dados.get(dia);
        }else{
            return -1;
        }
    }

    public boolean adicionarDado(int dia, int dado) {
        if(dia >= diaInicial && dia <= diaFinal){
            dados.put(dia, dado);
            return true;
        }
        return false;
    }

    
    
}
