package backoffice.service;

import backoffice.model.Event;

import java.util.List;
import java.util.Scanner;

public class EventService {

    private static Scanner scanner = new Scanner(System.in);

    public void listarEventos (List<Event> events) {        
        while (true) {
            System.out.println("\nEventos Críticos:");
            
            if (events.isEmpty()) {
                System.out.println("Nenhum evento crítico cadastrado.");
                
            } else {
                for (int i = 0; i < events.size(); i++) {
                    System.out.println((i + 1) + ". " + events.get(i).getName() + " - " + events.get(i).getLocation());
                }
            }
            
            System.out.println((events.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals(String.valueOf(events.size() + 1))) {
                return;
                
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
    
    public static void mockData(List<Event> events) {
        events.add(new Event(1, "Enchente", "Climático", "2025-05-01", "RS", "Enchentes severas no RS", false));
        events.add(new Event(2, "Deslizamento", "Climático", "2025-05-02", "SC", "Deslizamento na serra catarinense", false));
        events.add(new Event(3, "Tempestade", "Climático", "2025-05-03", "PR", "Tempestade com ventos fortes no PR", false));
    }
}
