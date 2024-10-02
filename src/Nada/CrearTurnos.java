package Nada;

import java.util.PriorityQueue;

public class CrearTurnos {

    public PriorityQueue<Turnos> obtenerTurnosVuelosNacio() {
        PriorityQueue<Turnos> turnos = new PriorityQueue<>();
        turnos.add(new Turnos(1, false));
        turnos.add(new Turnos(2, true));
        turnos.add(new Turnos(3, false));
        turnos.add(new Turnos(4, false));
        turnos.add(new Turnos(5, true));
        return turnos;
    }

    public PriorityQueue<Turnos> obtenerTurnosVuelosInter() {
        PriorityQueue<Turnos> turnosInter = new PriorityQueue<>();
        turnosInter.add(new Turnos(1, false));
        turnosInter.add(new Turnos(2, true));
        turnosInter.add(new Turnos(3, false));
        turnosInter.add(new Turnos(4, false));
        turnosInter.add(new Turnos(5, true));
        return turnosInter;
    }


}
