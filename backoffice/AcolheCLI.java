package backoffice;

import backoffice.controller.*;
import backoffice.model.Event;
import backoffice.model.Professional;
import backoffice.model.Session;
import backoffice.service.EventService;
import backoffice.service.ProfessionalService;
import backoffice.service.SessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcolheCLI {

    private static Scanner scanner = new Scanner(System.in); 
    private static List<Event> events = new ArrayList<>();
    private static List<Professional> professionals = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    
    private static final AccountController oAccountController = new AccountController();
    private static final AddressController oAddressController = new AddressController();
    private static final EventController oEventController = new EventController();
    private static final ProfessionalController oProfessionalController = new ProfessionalController();
    private static final SessionController oSessionController = new SessionController();

    public static void main(String[] args) {
        seedData();
        
        oAccountController.createAccount();
        
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenu Sistema Acolhe");
            System.out.println("1. Listar eventos críticos");
            System.out.println("2. Listar sessões agendadas");
            System.out.println("3. Gerenciar profissionais");
            System.out.println("4. Disparo de SMS");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    oEventController.listarEventos(events);
                    break;
                    
                case "2":
                    oSessionController.listarSessoes(sessions);
                    break;
                    
                case "3":
                    oProfessionalController.gerenciarProfissionais(professionals);
                    break;
                    
                case "4":
                    disparoSMS();
                    break;
                    
                case "5":
                    System.out.println("Encerrando o sistema. Até logo!");
                    System.exit(0);
                    
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void disparoSMS() {
        while (true) {
            System.out.println("\nSelecione o evento para disparo do SMS Broadcast:");
            
            if (events.isEmpty()) {
                System.out.println("Nenhum evento disponível para disparo de SMS.");
                
            } else {
                for (int i = 0; i < events.size(); i++) {
                    Event event = events.get(i);
                    String smsStatus = event.isSmsSent() ? "SMS enviado" : "SMS não enviado";
                    System.out.println((i + 1) + ". " + event.getName() + " - " + event.getLocation() + " (" + smsStatus + ")");
                }
            }
            
            System.out.println((events.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            try {
                int escolha = Integer.parseInt(opcao);
                
                if (escolha >= 1 && escolha <= events.size()) {
                    Event selectedEvent = events.get(escolha - 1);
                    
                    if (selectedEvent.isSmsSent()) {
                        System.out.println("SMS já foi enviado.");
                        
                    } else {
                        System.out.println("SMS enviado com sucesso para a região de " + selectedEvent.getLocation() + ".");
                        selectedEvent.setSmsSent(true);
                    }
                    
                    System.out.println("1. Voltar");
                    scanner.nextLine();
                    
                    return;
                    
                } else if (escolha == events.size() + 1) {
                    return;
                    
                } else {
                    System.out.println("Opção inválida.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void seedData() {
        // Eventos
        EventService.mockData(events);

        // Profissionais (mockup data)
        ProfessionalService.mockData(professionals);

        // Sessões
        SessionService.mockData(sessions, professionals, events);
    }
}