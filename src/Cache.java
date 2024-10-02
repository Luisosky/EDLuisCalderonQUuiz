import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Integer, Persona> personasAtendidas = new HashMap<>();
    private Map<String, Turnos> turnosDespachados = new HashMap<>();

    public void addPersona(Persona persona) {
        personasAtendidas.put(persona.getCedula(), persona);
    }

    public void addTurno(Turnos turno) {
        turnosDespachados.put(turno.getIdentificador(), turno);
    }

    public Map<Integer, Persona> getPersonasAtendidas() {
        return personasAtendidas;
    }

    public Map<String, Turnos> getTurnosDespachados() {
        return turnosDespachados;
    }

    public Turnos getTurnoById(String identificador) {
        return turnosDespachados.get(identificador);
    }

    public Persona getPersonaByTurnoId(String identificador) {
        Turnos turno = turnosDespachados.get(identificador);
        if (turno != null) {
            return personasAtendidas.get(turno.getSecuencia());
        }
        return null;
    }
}