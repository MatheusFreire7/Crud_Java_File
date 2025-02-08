package src;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CRUDApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileRepository<Pessoa> repo = new FileRepository<>("pessoas.txt", new PessoaMapper());

        while (true) {
            System.out.println("\n1 - Criar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Atualizar Pessoa");
            System.out.println("4 - Deletar Pessoa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Erro: Opção inválida! Digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
                continue;
            }
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade;
                    try {
                        idade = scanner.nextInt();
                        if (idade < 0 || idade > 150) { // Validação da idade
                            System.err.println("Erro: Idade inválida! Deve ser entre 0 e 150.");
                            scanner.nextLine(); // Limpa o buffer do scanner
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Erro: Idade inválida! Digite um número inteiro.");
                        scanner.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    // Valida CPF
                    if (!CPFUtils.validarCPF(cpf)) {
                        System.err.println("Erro: CPF inválido!");
                        break;
                    }

                    // Valida E-mail
                    if (!EmailUtils.validarEmail(email)) {
                        System.err.println("Erro: E-mail inválido!");
                        break;
                    }

                    // Verifica se o CPF já existe
                    if (repo.existeCpf(cpf)) {
                        System.err.println("Erro: CPF já cadastrado!");
                        break;
                    }

                    // Cria a pessoa
                    int id = (int) (Math.random() * 1000); // ID aleatório
                    repo.criar(new Pessoa(id, nome, idade, cpf, email));
                    System.out.println("Pessoa criada com sucesso!");
                    break;

                    case 2:
                    List<Pessoa> pessoas = repo.ler();
                
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                        break;
                    }
                
                    // Cabeçalho da tabela
                    String formato = "| %-5s | %-20s | %-5s | %-14s | %-30s |%n";
                    String linha = "+-------+----------------------+-------+----------------+--------------------------------+";
                
                    System.out.println(linha);
                    System.out.printf(formato, "ID", "Nome", "Idade", "CPF", "Email");
                    System.out.println(linha);
                
                    // Exibe cada pessoa formatada
                    for (Pessoa p : pessoas) {
                        String cpfFormatado = CPFUtils.formatarCPF(p.getCpf()); // Formata o CPF antes de exibir
                        System.out.printf(formato, p.getId(), p.getNome(), p.getIdade(), cpfFormatado, p.getEmail());
                    }
                
                    System.out.println(linha);
                    break;
                

                case 3:
                    System.out.print("CPF da Pessoa a atualizar: ");
                    String cpfUpdate = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int novaIdade;
                    try {
                        novaIdade = scanner.nextInt();
                        if (novaIdade < 0 || novaIdade > 150) { // Validação da idade
                            System.err.println("Erro: Idade inválida! Deve ser entre 0 e 150.");
                            scanner.nextLine(); // Limpa o buffer do scanner
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Erro: Idade inválida! Digite um número inteiro.");
                        scanner.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();

                    // Valida E-mail
                    if (!EmailUtils.validarEmail(novoEmail)) {
                        System.err.println("Erro: E-mail inválido!");
                        break;
                    }

                    // Atualiza a pessoa
                    repo.atualizar(cpfUpdate, new Pessoa(0, novoNome, novaIdade, cpfUpdate, novoEmail));
                    System.out.println("Pessoa atualizada com sucesso!");
                    break;

                case 4:
                    System.out.print("CPF da Pessoa a deletar: ");
                    String cpfDelete = scanner.nextLine();
                    repo.deletar(cpfDelete);
                    System.out.println("Pessoa deletada com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}