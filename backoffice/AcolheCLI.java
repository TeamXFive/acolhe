package backoffice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console; // Importar Console para leitura de senha oculta

public class AcolheCLI {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Event> events = new ArrayList<>();
    private static List<Professional> professionals = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static User currentUser; // Armazenar o usuário logado

    public static void main(String[] args) {
        seedData();
        createAccountAndLogin();
    }

    private static void createAccountAndLogin() {
        System.out.println("Bem vindo ao sistema Acolhe! Crie seu usuário");

        String newUserName;
        while (true) {
            System.out.print("Entre com seu nome e sobrenome: ");
            newUserName = scanner.nextLine();
            if (newUserName.matches("^[a-zA-Z\\s]+$")) { // Aceita apenas letras e espaços
                break;
            } else {
                System.out.println("Nome inválido. Por favor, use apenas letras e espaços.");
            }
        }

        String newUserPassword = readPassword("Entre com sua senha numérica de 6 dígitos: "); // Usar readPassword

        // Criar um usuário temporário para simular o registro
        currentUser = new User(0, newUserName, "", "", ""); // ID 0, telefone e documento vazios por enquanto

        System.out.println("\nEntre com seu login");
        String loginName;
        String loginPassword;

        while (true) {
            System.out.print("Nome: ");
            loginName = scanner.nextLine();
            loginPassword = readPassword("Senha: "); // Usar readPassword

            if (loginName.equals(currentUser.getFullName()) && loginPassword.equals(newUserPassword)) {
                System.out.println("Login bem-sucedido!");
                break;
            } else {
                System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
            }
        }
        menu();
    }

    // Método auxiliar para ler a senha oculta
    private static String readPassword(String prompt) {
        Console console = System.console();
        if (console != null) {
            char[] passwordChars = console.readPassword(prompt);
            String password = new String(passwordChars);
            if (password.matches("^\\d{6}$")) {
                return password;
            } else {
                System.out.println("Senha inválida. Por favor, insira uma senha numérica de 6 dígitos.");
                return readPassword(prompt); // Tentar novamente
            }
        } else {
            // Fallback para ambientes sem Console (IDEs como Eclipse/IntelliJ geralmente não têm)
            System.out.print(prompt + " (A senha será visível no terminal): ");
            String password = scanner.nextLine();
            if (password.matches("^\\d{6}$")) {
                return password;
            } else {
                System.out.println("Senha inválida. Por favor, insira uma senha numérica de 6 dígitos.");
                return readPassword(prompt); // Tentar novamente
            }
        }
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
                    listarEventos();
                    break;
                case "2":
                    listarSessoes();
                    break;
                case "3":
                    gerenciarProfissionais();
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

    private static void listarSessoes() {
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

    private static void gerenciarProfissionais() {
        while (true) {
            System.out.println("\nGerenciar Profissionais:");
            System.out.println("1. Cadastrar Profissional");
            if (professionals.isEmpty()) {
                System.out.println("Nenhum profissional cadastrado.");
            } else {
                for (int i = 0; i < professionals.size(); i++) {
                    Professional p = professionals.get(i);
                    System.out.println((i + 2) + ". " + p.getFullName() + " (" + p.getSpecialization() + ")");
                }
            }
            System.out.println((professionals.size() + 2) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            try {
                int escolha = Integer.parseInt(opcao);
                if (escolha == 1) {
                    cadastrarProfissional();
                } else if (escolha >= 2 && escolha <= professionals.size() + 1) {
                    gerenciarProfissionalDetalhes(professionals.get(escolha - 2));
                } else if (escolha == professionals.size() + 2) {
                    return;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarProfissional() {
        System.out.println("\nCadastrar Novo Profissional:");
        System.out.print("Nome Completo: ");
        String fullName = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();
        System.out.print("Especialização: ");
        String specialization = scanner.nextLine();
        System.out.print("Número de Licença: ");
        String licenseNumber = scanner.nextLine();

        // O status e activity agora são definidos automaticamente
        String status = "AVAILABLE";
        boolean activity = true;

        int newId = professionals.isEmpty() ? 1 : professionals.get(professionals.size() - 1).getProfessionalId() + 1;
        Professional newProfessional = new Professional(newId, fullName, phone, specialization, licenseNumber, status, activity);
        professionals.add(newProfessional);
        System.out.println("Profissional cadastrado com sucesso com status 'AVAILABLE' e ativo!");
    }

    private static void gerenciarProfissionalDetalhes(Professional professional) {
        while (true) {
            System.out.println("\nProfissional Selecionado: " + professional.getFullName());
            System.out.println("1. Excluir profissional");
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    excluirProfissional(professional);
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void excluirProfissional(Professional professional) {
        professionals.remove(professional);
        System.out.println("Profissional " + professional.getFullName() + " excluído com sucesso.");
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
        events.add(new Event(1, "Enchente", "Climático", "2025-05-01", "RS", "Enchentes severas no RS", false));
        events.add(new Event(2, "Deslizamento", "Climático", "2025-05-02", "SC", "Deslizamento na serra catarinense", false));
        events.add(new Event(3, "Tempestade", "Climático", "2025-05-03", "PR", "Tempestade com ventos fortes no PR", false));

        // Profissionais (mockup data)
        // Usando o construtor mais completo e definindo status e activity padrão
        professionals.add(new Professional(1, "Ana Silva", "11911112222", "Psicóloga", "12345BR", "AVAILABLE", true));
        professionals.add(new Professional(2, "Carlos Souza", "11933334444", "Psicólogo", "67890BR", "AVAILABLE", true));
        professionals.add(new Professional(3, "Mariana Lima", "11955556666", "Assistente Social", "11223BR", "AVAILABLE", true));

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