import java.util.Comparator;

public class CompararPorLambda implements Comparator<Turnos> {
    @Override
    public int compare(Turnos t1, Turnos t2) {
        return Comparator
                .comparingInt((Turnos t) -> t.getEdad() >= 60 ? 1 : -1)
                .thenComparingInt(Turnos::getEdad).reversed()
                .thenComparing(Turnos::isClienteGrande)
                .thenComparingInt(Turnos::getSecuencia)
                .compare(t1, t2);
    }
}