package backoffice.service;

import backoffice.model.Professional;

import java.util.List;
import java.util.Scanner;

public class ProfessionalService {

    private Scanner scanner = new Scanner(System.in);

    public void gerenciarProfissionais (List<Professional> professionals) {
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
                    cadastrarProfissional(professionals);
                    
                } else if (escolha >= 2 && escolha <= professionals.size() + 1) {
                    gerenciarProfissionalDetalhes(professionals, professionals.get(escolha - 2));
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

    private void cadastrarProfissional(List<Professional> professionals) {
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

    private void gerenciarProfissionalDetalhes(List<Professional> professionals, Professional professional) {
        while (true) {
            System.out.println("\nProfissional Selecionado: " + professional.getFullName());
            System.out.println("1. Excluir profissional");
            System.out.println("2. Voltar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    excluirProfissional(professionals, professional);
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void excluirProfissional(List<Professional> professionals, Professional professional) {
        professionals.remove(professional);
        System.out.println("Profissional " + professional.getFullName() + " excluído com sucesso.");
    }
    
    public static void mockData(List<Professional> professionals) {
        professionals.add(new Professional(1, "Ana Silva", "11911112222", "Psicóloga", "12345BR", "AVAILABLE", true));
        professionals.add(new Professional(2, "Carlos Souza", "11933334444", "Psicólogo", "67890BR", "AVAILABLE", true));
        professionals.add(new Professional(3, "Mariana Lima", "11955556666", "Assistente Social", "11223BR", "AVAILABLE", true));
    }
}
