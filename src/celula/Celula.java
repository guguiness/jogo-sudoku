package celula;

import java.util.Objects;

public class Celula {
    private Integer valor;
    private Integer posicaoLinha;
    private Integer posicaoColuna;
    private TipoCelula tipo;
    private boolean conflito;

    public Celula(Integer valor, Integer posicaoLinha, Integer posicaoColuna, TipoCelula tipo) {
        this.valor = valor;
        this.posicaoLinha = posicaoLinha;
        this.posicaoColuna = posicaoColuna;
        this.tipo = tipo;
    }

    public Celula(Integer valor, Integer posicaoLinha, Integer posicaoColuna, TipoCelula tipo, boolean conflito) {
        this.valor = valor;
        this.posicaoLinha = posicaoLinha;
        this.posicaoColuna = posicaoColuna;
        this.tipo = tipo;
        this.conflito = conflito;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getPosicaoLinha() {
        return posicaoLinha;
    }

    public void setPosicaoLinha(Integer posicaoLinha) {
        this.posicaoLinha = posicaoLinha;
    }

    public Integer getPosicaoColuna() {
        return posicaoColuna;
    }

    public void setPosicaoColuna(Integer posicaoColuna) {
        this.posicaoColuna = posicaoColuna;
    }

    public TipoCelula getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelula tipo) {
        this.tipo = tipo;
    }

    public boolean isConflito() {
        return conflito;
    }

    public void setConflito(boolean conflito) {
        this.conflito = conflito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celula celula = (Celula) o;
        return conflito == celula.conflito && Objects.equals(valor, celula.valor) && Objects.equals(posicaoLinha, celula.posicaoLinha) && Objects.equals(posicaoColuna, celula.posicaoColuna) && tipo == celula.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, posicaoLinha, posicaoColuna, tipo, conflito);
    }

    @Override
    public String toString() {
        return "Celula{" +
                "valor=" + valor +
                ", posicaoLinha=" + posicaoLinha +
                ", posicaoColuna=" + posicaoColuna +
                ", tipo=" + tipo +
                ", conflito=" + conflito +
                '}';
    }
}
