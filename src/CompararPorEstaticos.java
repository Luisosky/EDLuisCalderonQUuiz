import java.util.Comparator;

public class CompararPorEstaticos implements Comparator<Turnos> {
    @Override
    public int compare(Turnos t1, Turnos t2) {
        return Comparator
                .comparingInt(CompararPorEstaticos::prioridadEdad)
                .thenComparingInt(Turnos::getEdad).reversed()
                .thenComparing(CompararPorEstaticos::prioridadGenero)
                .thenComparing(CompararPorEstaticos::prioridadEmbarazo)
                .thenComparing(CompararPorEstaticos::prioridadClienteGrande)
                .thenComparingInt(Turnos::getSecuencia)
                .compare(t1, t2);
    }

    private static int prioridadEdad(Turnos t) {
        return t.getEdad() >= 60 ? 1 : -1;
    }

    private static int prioridadGenero(Turnos t) {
        return t.getSexo() == 'F' ? 1 : -1;
    }

    private static int prioridadEmbarazo(Turnos t) {
        return t.isEmbarazada() ? 1 : -1;
    }

    private static int prioridadClienteGrande(Turnos t) {
        return t.isClienteGrande() ? 1 : -1;
    }
}