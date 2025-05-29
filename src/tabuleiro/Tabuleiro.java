package tabuleiro;

import celula.Celula;
import celula.TipoCelula;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tabuleiro {
    private Celula[][] celulas;
    private Estado estado;
    private final int TAM_LINHA = 9;
    private final int TAM_COLUNA = 9;

    // Formato do estado inicial: posiçãoLinha,posiçãoColuna,valor;...
    public Tabuleiro(String estadoInicial) {
        Celula[][] celulas = new Celula[TAM_LINHA][TAM_COLUNA];
        String[] celulasString = estadoInicial.split(";");

        // Tabuleiro vazio
        for(int i = 0; i < TAM_LINHA; i++) {
            for(int j = 0; j < TAM_COLUNA; j++) {
                celulas[i][j] = new Celula(0, i, j, TipoCelula.FIXO, false);
            }
        }

        for(String celula : celulasString) {
            int posicaoLinha = 0;
            int posicaoColuna = 1;
            int valor = 2;

            // Representação da célula no formato: [posicaoLinha, posicaoColuna, valor]
            List<Integer> celulaDecomposta = Arrays.stream(celula.split(","))
                    .map(Integer::parseInt)
                    .toList();

            Celula novaCelulaFixa = new Celula(
                    celulaDecomposta.get(valor),
                    celulaDecomposta.get(posicaoLinha),
                    celulaDecomposta.get(posicaoColuna),
                    TipoCelula.FIXO,
                    false);

            celulas[celulaDecomposta.get(posicaoLinha)][celulaDecomposta.get(posicaoColuna)] = novaCelulaFixa;
        }

        this.celulas = celulas;
    }

    public void visualizar() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(this.getCelulas()[i][j].getValor() + "\t");

                // Quadrante vertical
                if(j == 2 || j == 5)
                    System.out.print("|\t");
            }
            // Quadrante horizontal
            if(i == 2 || i == 5) {
                System.out.println();
                System.out.println("_\t_\t_\t \t_\t_\t_\t \t_\t_\t_\t");
            }
            System.out.println();
        }
    }

    public boolean inserirValor(int posicaoLinha, int posicaoColuna, Celula cel) {
        if(!celulas[posicaoLinha][posicaoColuna].getValor().equals(0)) {
            return false;
        }

        boolean isConflito = rastrearConflito(posicaoLinha, posicaoColuna, cel);
        cel.setConflito(isConflito);

        celulas[posicaoLinha][posicaoColuna] = cel;
        return true;
    }

    protected boolean rastrearConflito(int posicaoLinha, int posicaoColuna, Celula cel) {
        Integer novoValor = cel.getValor();

        for(int i = 0; i < TAM_LINHA; i++) {
            if(celulas[i][posicaoColuna].getValor().equals(novoValor))
                return true;
        }

        for(int i = 0; i < TAM_COLUNA; i++) {
            if(celulas[posicaoLinha][i].getValor().equals(novoValor))
                return true;
        }

        // Verificação no quadrante
        int linhaInicioQuadrante = (int) (posicaoLinha / 3) * 3;
        int colunaInicioQuadrante = (int) (posicaoColuna / 3) * 3;
        for(int i = 0; i < linhaInicioQuadrante + 2; i++) {
            for(int j = 0; j < colunaInicioQuadrante + 2; j++) {
                if(celulas[i][j].getValor().equals(novoValor))
                    return true;
            }
        }

        return false;       // Sem conflitos
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
