package simuladordado;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import java.lang.Math;
import java.util.Formatter;
import java.lang.StringBuilder;


public class Cenario {
    
    private int tamanhoAmostra;
    private int facesDado;
    private List<Integer> ocorrencias;
    private List<Integer> frequencias;

    // construtor

    public Cenario(int facesDado, int tamanhoAmostra) {
        this.facesDado = facesDado;
        this.tamanhoAmostra = tamanhoAmostra;
        this.ocorrencias = new ArrayList<Integer>(tamanhoAmostra);

        this.frequencias = new ArrayList<Integer>(facesDado);
        for (int i = 0; i < facesDado; i++)
            frequencias.add(0);
    }

    // execução de simulação

    public void simular() {

        Dado dado = new Dado(facesDado);

        for (int i = 0; i < tamanhoAmostra; i++)
            registrarRolagem(dado.rolar());
    }

    public String getResults() {

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);

        for (int i = 1; i <= 6; i++) 
            fm.format("%d: %.2f%%;\n", i, diferencaEmpirica(i)*100.0);

        sb.append("\n");

        return sb.toString();
    }

    // cálculos estatísticos do cenário

    public Integer getFrequencia(Integer valor) {
        return frequencias.get(valor - 1);
    }

    public Double getFrequenciaRelativa(Integer valor) {
        return getFrequencia(valor)/(tamanhoAmostra * 1.0);
    }

    public Double diferencaEmpirica(Integer valor) {

        Double freqProbabilistica = 1.0/facesDado;
        return getFrequenciaRelativa(valor) - freqProbabilistica;
    }

    // métodos de acesso

    public void registrarRolagem(Integer valor) {        

        ocorrencias.add(valor);
        frequencias.set(valor - 1, frequencias.get(valor - 1) + 1);
    }

    List<Integer> getOcorrencias() {
        return this.ocorrencias;
    }

    List<Integer> getFrequencias() {
        return this.frequencias;
    }
    
}