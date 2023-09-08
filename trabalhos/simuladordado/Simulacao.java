package simuladordado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

public class Simulacao {

    public static void main(String[] args) {

        final List<Integer> tamanhos = new ArrayList<Integer>(
                Arrays.asList(10, 100, 1000, 10000, 100000, 1000000));

        List<Cenario> cenarios = new ArrayList<Cenario>(6);

        // inicializa os cenários

        for (Integer tamanhoAmostra : tamanhos) {
            cenarios.add(new Cenario(6, tamanhoAmostra));
        }

        // simula

        for (Cenario cenario : cenarios)
            cenario.simular();

        // exibe

        try {
            
            FileWriter file = new FileWriter("resultados.txt");
            PrintWriter printer = new PrintWriter(file);

            for (int i = 0; i < cenarios.size(); i++) {

                printer.printf("Cenário %d - %d vezes\n", (i + 1), tamanhos.get(i));
                printer.print(cenarios.get(i).getResults());

            }

            file.close();

        } catch (IOException e) {

            System.out.println("exceção de IO");

        }

    }

}
