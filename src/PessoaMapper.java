package src;

public class PessoaMapper implements EntityMapper<Pessoa> {
    @Override
    public Pessoa fromString(String data) {
        String[] partes = data.split(",");
        // Remove a formatação do CPF (pontos e traço)
        String cpf = partes[3].replaceAll("[^0-9]", "");
        return new Pessoa(
            Integer.parseInt(partes[0]),
            partes[1],
            Integer.parseInt(partes[2]),
            cpf,
            partes[4]
        );
    }

    @Override
    public String getCpf(Pessoa obj) {
        return obj.getCpf();
    }
}