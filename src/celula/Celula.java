package celula;

import java.util.Objects;

public class Celula {
    private Integer valor;
    private TipoCelula tipo;
    private boolean conflito;

    public Celula(Integer valor, TipoCelula tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public Celula(Integer valor, TipoCelula tipo, boolean conflito) {
        this.valor = valor;
        this.tipo = tipo;
        this.conflito = conflito;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
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
        return tipo == celula.tipo && conflito == celula.conflito && Objects.equals(valor, celula.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, tipo, conflito);
    }

    @Override
    public String toString() {
        return "celula.Celula{" +
                "valor=" + valor +
                ", tipo=" + tipo +
                ", conflito=" + conflito +
                '}';
    }
}
