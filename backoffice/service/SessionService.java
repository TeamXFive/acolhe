package backoffice.service;

import backoffice.model.Event;
import backoffice.model.Professional;
import backoffice.model.Session;
import backoffice.model.User;

import java.util.List;
import java.util.Scanner;

public class SessionService {

    private Scanner scanner = new Scanner(System.in);

    public void listarSessoes (List<Session> sessions) {
        while (true) {
            System.out.println("\nSessões Agendadas:");
            
            if (sessions.isEmpty()) {
                System.out.println("Nenhuma sessão agendada.");
                
            } else {
                for (int i = 0; i < sessions.size(); i++) {
                    Session s = sessions.get(i);
                    System.out.println((i + 1) + ". " + s.getDatetime() + " - " + s.getUser().getFullName().split(" ")[0]);
                }
            }
            
            System.out.println((sessions.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals(String.valueOf(sessions.size() + 1))) {
                return;
                
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
    
    public static void mockData (List<Session> sessions, List<Professional> professionals, List<Event> events) {
        User u1 = new User(1, "Lucas Andrade", "11999999999", "123456789");
        User u2 = new User(2, "Juliana Pereira", "11988888888", "987654321");
        User u3 = new User(3, "Ricardo Silva", "11977777777", "456789123");
        User u4 = new User(4, "Fernanda Costa", "11966666666", "321654987");
        User u5 = new User(5, "Gabriel Santos", "11955555555", "654987321");
        
        sessions.add(new Session(1, "2025-06-01 10:00", "SCHEDULED", "WEB", "link.com/1", "tel:+5511999999999", u1, professionals.get(0), events.get(0)));
        sessions.add(new Session(2, "2025-06-02 14:00", "SCHEDULED", "PHONE", "link.com/2", "tel:+5511988888888", u2, professionals.get(1), events.get(1)));
        sessions.add(new Session(3, "2025-06-03 16:00", "SCHEDULED", "WEB", "link.com/3", "tel:+5511977777777", u3, professionals.get(2), events.get(2)));
        sessions.add(new Session(4, "2025-06-04 09:00", "SCHEDULED", "PHONE", "link.com/4", "tel:+5511966666666", u4, professionals.get(0), events.get(0)));
        sessions.add(new Session(5, "2025-06-05 11:00", "SCHEDULED", "WEB", "link.com/5", "tel:+5511955555555", u5, professionals.get(1), events.get(1)));
    }
}
