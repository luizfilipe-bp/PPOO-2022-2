package fabricaautomoveis;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Gol;
import fabricaautomoveis.carros.Jetta;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Saveiro;

public class VWCarroFactory implements CarroFactory {
    private Marca marca;
    public VWCarroFactory() {
        this.marca = Marca.VW;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        if (categoria == Categoria.POPULAR) {
            return new Gol(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            return new Saveiro(cor);
        }else if (categoria == Categoria.LUXO) {
            return new Jetta(cor);
        }
        return null;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }
    
}
