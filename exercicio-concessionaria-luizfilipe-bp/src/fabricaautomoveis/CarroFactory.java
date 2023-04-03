package fabricaautomoveis;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public interface CarroFactory {
    Carro criarCarro(Categoria categoria, String cor);
    Marca getMarca();
}
