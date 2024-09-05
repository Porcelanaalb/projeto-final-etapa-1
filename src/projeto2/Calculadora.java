package projeto2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("""
                        
                        Calculadora de números inteiros\s
                        [1] Adição:
                        [2] Subtração:
                        [3] Multiplicação:
                        [4] Divisão:
                        [5] Módulo:
                        [6] Sair
                        Escolha uma opção:""");
            int opcao;
            try {
                opcao = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número de 1 a 6.");
                scan.nextLine();
                continue;
            }
            if (opcao == 6) {
                System.out.println("Saindo da calculadora...");
               System.exit(1);
               scan.close();
                break;
            }
            System.out.print("Digite o primeiro número: ");
            int num1;
            try {
                num1 = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scan.nextLine();
                continue;
            }
            System.out.print("Digite o segundo número: ");
            int num2;
            try {
                num2 = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scan.nextLine();
                continue;
            }
            switch (opcao) {
                case 1: // Adição
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2: // Subtração
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3: // Multiplicação
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4: // Divisão
                    if (num2 == 0) {
                        System.out.println("Erro: Divisão por zero não é permitida.");
                    } else {
                        System.out.println("Resultado: " + (num1 / num2));
                    }
                    break;
                case 5: // Módulo
                    if (num2 == 0) {
                        System.out.println("Erro: Módulo por zero não é permitido.");
                    } else {
                        System.out.println("Resultado: " + (num1 % num2));
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção de 1 a 6.");
            }
        }
    }
}