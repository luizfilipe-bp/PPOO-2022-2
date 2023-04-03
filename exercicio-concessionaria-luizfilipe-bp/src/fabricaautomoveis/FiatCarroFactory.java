package fabricaautomoveis;

import fabricaautomoveis.carros.Argo;
import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Strada;
import fabricaautomoveis.carros.Toro;

public class FiatCarroFactory implements CarroFactory{
    private Marca marca;
    public FiatCarroFactory() {
        this.marca = Marca.FIAT;
    }
    
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        if (categoria == Categoria.POPULAR) {
            return new Argo(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            return new Strada(cor);
        }
        else if (categoria == Categoria.LUXO) {
            return new Toro(cor);
        }
        return null;
    }
    @Override
    public Marca getMarca() {
        return marca;
    }
    
}
