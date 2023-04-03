package fabricaautomoveis.carros;

public enum Marca {
    VW(1), FIAT(2), CHEVROLET(3);

    private int id;
    private Marca(int id) {
        this.id = id;
    }

    public static Marca peloID(int id) {
        for (Marca marca : Marca.values()) {
            if (marca.id == id) {
                return marca;
            }
        }
        throw new RuntimeException("Não existe marca de id " + id);
    }
}
