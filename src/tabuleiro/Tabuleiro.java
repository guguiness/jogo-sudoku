package tabuleiro;

import celula.Celula;
import celula.TipoCelula;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tabuleiro {
    private Celula[][] celulas;
    private Estado estado;

    // Formato do estado inicial: posiçãoLinha,posiçãoColuna,valor;...
    public Tabuleiro(String estadoInicial) {
        Celula[][] celulas = new Celula[9][9];
        String[] linhas = estadoInicial.split(";");

        for(Celula[] linha : celulas) {
            Arrays.fill(
                    linha,
                    new Celula(0, TipoCelula.VAZIO, false)
            );
        }

        for(String celula : linhas) {
            int posicaoLinha = 0;
            int posicaoColuna = 1;
            int valor = 2;

            // Representação da célula no formato: [posicaoLinha, posicaoColuna, valor]
            List<Integer> celulaDecomposta = Arrays.stream(celula.split(","))
                    .map(Integer::parseInt)
                    .toList();

            Celula novaCelulaFixa = new Celula(celulaDecomposta.get(valor), TipoCelula.FIXO, false);

            celulas[celulaDecomposta.get(posicaoLinha)][celulaDecomposta.get(posicaoColuna)] = novaCelulaFixa;
        }

        this.celulas = celulas;
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public void setCelulas(Celula[][] celulas) {
        this.celulas = celulas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tabuleiro tabuleiro = (Tabuleiro) o;
        return Arrays.equals(celulas, tabuleiro.celulas) && estado == tabuleiro.estado;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(estado);
        result = 31 * result + Arrays.hashCode(celulas);
        return result;
    }

    @Override
    public String toString() {
        return "tabuleiro.Tabuleiro{" +
                "celulas=" + Arrays.toString(celulas) +
                ", estado=" + estado +
                '}';
    }
}
