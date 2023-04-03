package corredores;

public class Corredor implements Competidor {
    private String nome;
    private int velocidade;
    private int distanciaPercorrida;
    private int distanciaDaCorrida;
    private boolean estahCorrendo;

    public Corredor(String nome, int velocidade){
        this.nome = nome;
        this.velocidade = velocidade;
        this.distanciaDaCorrida = 0;
        this.distanciaPercorrida = 0;
        this.estahCorrendo = false;   
    }
    @Override
    public void run() {
        estahCorrendo = true;
        while(distanciaPercorrida < distanciaDaCorrida) {
            distanciaPercorrida += 1;
            try {
                Thread.sleep(1000 / velocidade);
            } catch (InterruptedException e) {
                estahCorrendo = false;
                e.printStackTrace();
            }
        }
        estahCorrendo = false;
        
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return estahCorrendo;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        this.distanciaDaCorrida = distanciaDaCorrida;
        this.distanciaPercorrida = 0;
        this.estahCorrendo = false;
    }

}