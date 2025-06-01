package backoffice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcolheCLI {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Event> events = new ArrayList<>();
    private static List<Professional> professionals = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();

    public static void main(String[] args) {
        seedData();
        login();
    }

    private static void login() {
        System.out.println("Bem-vindo ao Sistema Acolhe! Entre com seu login:");
        System.out.print("Nome: ");
        scanner.nextLine(); // Entrada de nome (não é validada)
        System.out.print("Senha: ");
        scanner.nextLine(); // Entrada de senha (não é validada)

        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenu Sistema Acolhe");
            System.out.println("1. Listar eventos críticos");
            System.out.println("2. Listar sessões agendadas");
            System.out.println("3. Listar profissionais");
            System.out.println("4. Disparo de SMS");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    listarEventos();
                    break;
                case "2":
                    listarSessoes();
                    break;
                case "3":
                    listarProfissionais();
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

    private static void listarEventos() {
        while (true) {
            System.out.println("\nEventos Críticos:");
            for (int i = 0; i < events.size(); i++) {
                System.out.println((i + 1) + ". " + events.get(i).getName() + " - " + events.get(i).getLocation());
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

    private static void listarSessoes() {
        while (true) {
            System.out.println("\nSessões Agendadas:");
            for (int i = 0; i < sessions.size(); i++) {
                Session s = sessions.get(i);
                System.out.println((i + 1) + ". " + s.getDatetime() + " - " + s.getUser().getFullName().split(" ")[1]);
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

    private static void listarProfissionais() {
        while (true) {
            System.out.println("\nProfissionais Disponíveis:");
            for (int i = 0; i < professionals.size(); i++) {
                Professional p = professionals.get(i);
                System.out.println((i + 1) + ". " + p.getFullName());
            }
            System.out.println((professionals.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals(String.valueOf(professionals.size() + 1))) {
                return;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void disparoSMS() {
        while (true) {
            System.out.println("\nSelecione o evento para disparo do SMS Broadcast:");
            for (int i = 0; i < events.size(); i++) {
                System.out.println((i + 1) + ". " + events.get(i).getName() + " - " + events.get(i).getLocation());
            }
            System.out.println((events.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            try {
                int escolha = Integer.parseInt(opcao);
                if (escolha >= 1 && escolha <= events.size()) {
                    System.out.println("SMS enviado para a região de " + events.get(escolha - 1).getLocation() + ".");
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
        events.add(new Event(1, "Enchente", "Climático", "2025-05-01", "RS", "Enchentes severas no RS"));
        events.add(new Event(2, "Deslizamento", "Climático", "2025-05-02", "SC", "Deslizamento na serra catarinense"));
        events.add(new Event(3, "Tempestade", "Climático", "2025-05-03", "PR", "Tempestade com ventos fortes no PR"));

        // Profissionais
        professionals.add(new Professional(1, "Ana Silva", "Psicóloga", true));
        professionals.add(new Professional(2, "Carlos Souza", "Psicólogo", true));
        professionals.add(new Professional(3, "Mariana Lima", "Assistente Social", true));

        // Usuários
        User u1 = new User(1, "Lucas Andrade", "11999999999", "123456789", "ACTIVE");
        User u2 = new User(2, "Juliana Pereira", "11988888888", "987654321", "ACTIVE");
        User u3 = new User(3, "Ricardo Silva", "11977777777", "456789123", "ACTIVE");
        User u4 = new User(4, "Fernanda Costa", "11966666666", "321654987", "ACTIVE");
        User u5 = new User(5, "Gabriel Santos", "11955555555", "654987321", "ACTIVE");

        // Sessões
        sessions.add(new Session(1, "2025-06-01 10:00", "SCHEDULED", "WEB", "link.com/1", "tel:+5511999999999", u1, professionals.get(0), events.get(0)));
        sessions.add(new Session(2, "2025-06-02 14:00", "SCHEDULED", "PHONE", "link.com/2", "tel:+5511988888888", u2, professionals.get(1), events.get(1)));
        sessions.add(new Session(3, "2025-06-03 16:00", "SCHEDULED", "WEB", "link.com/3", "tel:+5511977777777", u3, professionals.get(2), events.get(2)));
        sessions.add(new Session(4, "2025-06-04 09:00", "SCHEDULED", "PHONE", "link.com/4", "tel:+5511966666666", u4, professionals.get(0), events.get(0)));
        sessions.add(new Session(5, "2025-06-05 11:00", "SCHEDULED", "WEB", "link.com/5", "tel:+5511955555555", u5, professionals.get(1), events.get(1)));
    }
}
