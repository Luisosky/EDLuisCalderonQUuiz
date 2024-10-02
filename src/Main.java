import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Turnos> turnosList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            turnosList.add(new Turnos(
                    (int) (Math.random() * 100), // edad
                    Math.random() > 0.5 ? 'M' : 'F', // sexo
                    Math.random() > 0.8, // embarazada
                    Math.random() > 0.5, // clienteGrande
                    i, // secuencia
                    UUID.randomUUID().toString() // identificador único
            ));
        }

        // ArrayList
        ArrayList<Turnos> arrayList = new ArrayList<>(turnosList);
        System.out.println("ArrayList:");
        arrayList.forEach(System.out::println);

        // Collections
        Collections.sort(arrayList);
        System.out.println("\nArrayList ordenado por orden natural:");
        arrayList.forEach(System.out::println);

        //CompararPorComparator
        Collections.sort(arrayList, new CompararPorComparator());
        System.out.println("\nArrayList ordenado por CompararPorComparator:");
        arrayList.forEach(System.out::println);

        // PriorityQueue
        PriorityQueue<Turnos> priorityQueue = new PriorityQueue<>(new CompararPorLambda());
        priorityQueue.addAll(turnosList.subList(0, 7));
        System.out.println("\nPriorityQueue con CompararPorLambda:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        // SortedSet
        SortedSet<Turnos> sortedSet1 = new TreeSet<>(new CompararPorEstaticos());
        sortedSet1.addAll(turnosList.subList(7, 14));
        System.out.println("\nSortedSet con CompararPorEstaticos:");
        sortedSet1.forEach(System.out::println);


        // Cache
        Cache cache = new Cache();
        for (Turnos turno : turnosList) {
            cache.addTurno(turno);
            cache.addPersona(new Persona(turno.getSecuencia(), "Persona " + turno.getSecuencia()));
        }

        System.out.println("\nCache de personas atendidas:");
        cache.getPersonasAtendidas().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nCache de turnos despachados:");
        cache.getTurnosDespachados().forEach((k, v) -> System.out.println(k + ": " + v));

        //Crud
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el identificador del turno: ");
        String identificador = scanner.nextLine();

        Turnos turnoBuscado = cache.getTurnoById(identificador);
        Persona personaBuscada = cache.getPersonaByTurnoId(identificador);

        System.out.println("\nTurno buscado por identificador:");
        System.out.println(turnoBuscado);

        System.out.println("\nPersona asociada al turno:");
        System.out.println(personaBuscada);
    }
}