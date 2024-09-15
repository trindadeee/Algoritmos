import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        SequentialList list = new SequentialList(1);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro (pelo índice)");
            System.out.println("3. Mostrar lista de livros");
            System.out.println("4. Ordenar lista por título e autor");
            System.out.println("5. Buscar livro pelo título");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do autor: ");
                    String author = scanner.nextLine();

                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();

                    LocalDateTime creationDate = LocalDateTime.now();
                    System.out.print("Digite o ano de lançamento (yyyy): ");
                    int year = scanner.nextInt();
                    System.out.print("Digite o mês de lançamento (mm): ");
                    int month = scanner.nextInt();
                    System.out.print("Digite o dia de lançamento (dd): ");
                    int day = scanner.nextInt();
                    LocalDateTime yearOfRelease = LocalDateTime.of(year, month, day, 0, 0);

                    Book livro = new Book(author, title, creationDate, yearOfRelease);
                    list.adicionar(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o índice do livro a ser removido: ");
                    int index = scanner.nextInt();
                    list.remover(index);
                    System.out.println("Livro removido com sucesso!");
                    break;

                case 3:
                    System.out.println("Lista de livros:");
                    list.mostrarLista();
                    break;

                case 4:
                    System.out.println("Ordenando a lista por título e autor...");
                    list.ordenarPorTituloEAutor();
                    System.out.println("Lista ordenada com sucesso!");
                    break;

                case 5:
                    System.out.print("Digite o título do livro a ser buscado: ");
                    String titulo = scanner.nextLine();
                    int indice = list.buscar(titulo);
                    if (indice != -1) {
                        System.out.println("Livro encontrado com sucesso!");
                        System.out.println(list.getLivro(indice));
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}