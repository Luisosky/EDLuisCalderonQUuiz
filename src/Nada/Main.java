package Nada;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CrearTurnos ct = new CrearTurnos();
        PriorityQueue<Turnos> turnosVuelosInter = ct.obtenerTurnosVuelosInter();
        PriorityQueue<Turnos> turnosVuelosNac = ct.obtenerTurnosVuelosNacio();
        turnosVuelosNac.stream().sorted().forEach(System.out::println);




        Set<Turnos> turnos = imprimirTurnos(turnosVuelosInter, turnosVuelosNac);
        LinkedList<Turnos> turnosList = imprimirTurnosDespachados(turnos);
        System.out.println("Turnos no despachados:");
        turnosList.forEach(System.out::println);
        System.out.println("Turnos despachados por las puntas:");
        Turnos[] turnosArray = atenderTurnosPorLasPuntas(turnosList);
        for (Turnos t : turnosArray) {
            System.out.println(t);
        }
    }

    public static Set<Turnos> imprimirTurnos(PriorityQueue<Turnos> turnosVuelosInter, PriorityQueue<Turnos> turnosVuelosNac) {
        Set<Turnos> turnos = new HashSet<>(turnosVuelosNac);
        turnos.addAll(turnosVuelosInter);
        Iterator<Turnos> it = turnos.iterator();
        while (it.hasNext()) {
            Turnos t = it.next();
            System.out.println(t);
        }
        return turnos;
    }

    public static LinkedList<Turnos> imprimirTurnosDespachados(Set<Turnos> turnos) {
        LinkedList<Turnos> turnosList = new LinkedList<>(turnos);
        ListIterator<Turnos> it = turnosList.listIterator();
        System.out.println("Turnos despachados:");
        while (it.hasNext()) {
            Turnos t = it.next();
            if (t.isDespachado()) {
                System.out.println(t);
                it.remove();
            }
        }
        return turnosList;
    }

    public static Turnos[] atenderTurnosPorLasPuntas(LinkedList<Turnos> turnos) {
        Turnos[] turnosArray = new Turnos[2];
        Turnos t1 = turnos.pollFirst();
        t1.setDespachado(true);
        Turnos t2 = turnos.pollLast();
        t2.setDespachado(true);
        turnosArray[0] = t1;
        turnosArray[1] = t2;
        return turnosArray;
    }


}
