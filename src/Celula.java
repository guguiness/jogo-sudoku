import java.util.Objects;

public class Celula {
    private Integer valor;
    private boolean fixo;
    private boolean conflito;

    public Celula(Integer valor, boolean fixo, boolean conflito) {
        this.valor = valor;
        this.fixo = fixo;
        this.conflito = conflito;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
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
        return fixo == celula.fixo && conflito == celula.conflito && Objects.equals(valor, celula.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, fixo, conflito);
    }

    @Override
    public String toString() {
        return "Celula{" +
                "valor=" + valor +
                ", fixo=" + fixo +
                ", conflito=" + conflito +
                '}';
    }
}
