package simuladordado;

import java.util.Random;

public class Dado {

    private int tamanho;

    public Dado(int tamanho) {
        this.tamanho = tamanho;
    }

    public Integer rolar() {
        Random rand = new Random();
        return rand.nextInt(tamanho) + 1;
    }
}