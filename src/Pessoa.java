package src;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    public Pessoa(int id, String nome, int idade, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        // Formata o CPF (###.###.###-##)
        String cpfFormatado = formatarCPF(cpf);
        return String.format("%d,%s,%d,%s,%s", id, nome, idade, cpfFormatado, email);
    }

    // Método para formatar o CPF
    private String formatarCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}