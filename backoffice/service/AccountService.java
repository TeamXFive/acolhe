package backoffice.service;

import backoffice.model.User;

import java.io.Console;
import java.util.Scanner;

public class AccountService {

    private static User currentUser; // Armazenar o usuário logado
    private Scanner scanner = new Scanner(System.in);
    
    public void createAccount () {
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
        currentUser = new User(0, newUserName, "", ""); // ID 0, telefone e documento vazios por enquanto
        
        createLogin(currentUser, newUserPassword);
    }
    
    public void createLogin(User currentUser, String newUserPassword) {
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
    }

    // Método auxiliar para ler a senha oculta
    private String readPassword(String prompt) {
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
}
