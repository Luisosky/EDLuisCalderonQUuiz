import java.util.Comparator;

public class CompararPorComparator implements Comparator<Turnos> {
    @Override
    public int compare(Turnos t1, Turnos t2) {
        if (t1.getEdad() >= 60 && t2.getEdad() < 60) {
            return -1;
        } else if (t1.getEdad() < 60 && t2.getEdad() >= 60) {
            return 1;
        } else if (t1.getEdad() == t2.getEdad()) {
            if (t1.getSexo() != t2.getSexo()) {
                return t1.getSexo() == 'F' ? -1 : 1;
            }
            return Integer.compare(t1.getSecuencia(), t2.getSecuencia());
        }
        return Integer.compare(t2.getEdad(), t1.getEdad()); // Descending order for age
    }
}