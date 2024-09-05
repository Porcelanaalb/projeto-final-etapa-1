package projeto1;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Tarefa {
    String descricao;
    boolean concluida;

    Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    void marcarComoConcluida() {
        this.concluida = true;
    }

    public String toString() {
        return (concluida ? "[Concluída] " : "[Pendente] ") + descricao;
    }
}
public class GerenciadorDeTarefas {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        while (true) {
            try {
                System.out.println("""
                        
                        Menu:\s
                        [1] Adicionar um item:
                        [2] Concluir um item:
                        [3] Ver lista:
                        [4] Remover da Lista:
                        [0] Finalizar lista.
                        Escolha uma opção:""");
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        String descricao;
                        do {
                            System.out.println("Adicione a nova tarefa (não pode ser vazia):");
                            descricao = scan.nextLine().trim();
                            if (descricao.isEmpty()) {
                                System.out.println("A descrição da tarefa não pode ser vazia. Tente novamente.");
                            }
                        } while (descricao.isEmpty());

                        tarefas.add(new Tarefa(descricao));
                        System.out.println("Tarefa adicionada!");
                        break;

                    case 2:

                        System.out.println("\nLista de Tarefas:");
                        for (int t = 0; t < tarefas.size(); t++) {
                            System.out.println((t + 1) + ". " + tarefas.get(t));
                        }

                        if (tarefas.isEmpty()) {
                            System.out.println("Nenhuma tarefa para concluir.");
                        } else {
                            System.out.print("Digite o número da tarefa a ser marcada como concluída: ");
                            int numeroTarefa1 = scan.nextInt();
                            scan.nextLine();

                            if (numeroTarefa1 > 0 && numeroTarefa1 <= tarefas.size()) {
                                Tarefa tarefa = tarefas.get(numeroTarefa1 - 1);
                                tarefa.marcarComoConcluida();
                                System.out.println("Tarefa marcada como concluída!");
                            } else {
                                System.out.println("Número de tarefa inválido.");
                            }
                        }
                        break;

                    case 3:
                        if (tarefas.isEmpty()) {
                            System.out.println("\nLista de Tarefas está vazia.");
                        } else {
                            System.out.println("\nLista de Tarefas:");
                            for (int t = 0; t < tarefas.size(); t++) {
                                System.out.println((t + 1) + ". " + tarefas.get(t));
                            }
                        }
                        break;

                    case 4:
                        System.out.println("\nLista de Tarefas:");
                        for (int t = 0; t < tarefas.size(); t++) {
                            System.out.println((t + 1) + ". " + tarefas.get(t));
                        }

                        if (tarefas.isEmpty()) {
                            System.out.println("Nenhuma tarefa para remover.");
                        } else {
                            System.out.print("Escolha o número da tarefa a ser removida: ");
                            int numeroRemover = scan.nextInt();
                            scan.nextLine();

                            if (numeroRemover > 0 && numeroRemover <= tarefas.size()) {
                                Tarefa removida = tarefas.remove(numeroRemover - 1);
                                System.out.println("Tarefa \"" + removida.descricao + "\" removida!");
                            } else {
                                System.out.println("Número inválido.");
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Saindo do programa...");
                        scan.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scan.nextLine();
            }
        }
    }
}