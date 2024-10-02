package Nada;

public class Turnos implements Comparable<Turnos> {

    @Override
    public int compareTo(Turnos o) {
        return Integer.compare(this.Secuencia, o.Secuencia);
    }

    private int Secuencia;
    private boolean despachado;

    public Turnos(int Secuencia, boolean despachado) {
        this.Secuencia = Secuencia;
        this.despachado = despachado;
    }

    public int getSecuencia() {
        return Secuencia;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "Secuencia=" + Secuencia +
                ", despachado=" + despachado +
                '}';
    }
}
