package fabricaautomoveis;

import fabricaautomoveis.carros.Camaro;
import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Montana;
import fabricaautomoveis.carros.Onix;

public class ChevroletCarroFactory implements CarroFactory{
    private Marca marca;
    public ChevroletCarroFactory(){
        this.marca = Marca.CHEVROLET;
    }
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        if (categoria == Categoria.POPULAR) {
            return new Onix(cor);
        }else if(categoria == Categoria.PICKUP) {
            return new Montana(cor);
        }else if(categoria == Categoria.LUXO) {
            return new Camaro(cor);
        }
        return null;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }
    
}
