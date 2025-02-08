package src;
import java.io.*;
import java.util.*;

public class FileRepository<T> implements CRUD<T> {
    private String fileName;
    private EntityMapper<T> mapper;

    public FileRepository(String fileName, EntityMapper<T> mapper) {
        this.fileName = fileName;
        this.mapper = mapper;
    }

    @Override
    public void criar(T obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(obj.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao criar objeto: " + e.getMessage());
        }
    }

    @Override
    public List<T> ler() {
        List<T> lista = new ArrayList<>();
        File file = new File(fileName);

        // Cria o arquivo se ele não existir
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Erro ao criar arquivo: " + e.getMessage());
                return lista;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(mapper.fromString(linha));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler objetos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void atualizar(String cpf, T obj) {
        List<T> lista = ler();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : lista) {
                if (mapper.getCpf(item).equals(cpf)) {
                    writer.write(obj.toString());
                } else {
                    writer.write(item.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao atualizar objeto: " + e.getMessage());
        }
    }

    @Override
    public void deletar(String cpf) {
        List<T> lista = ler();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : lista) {
                if (!mapper.getCpf(item).equals(cpf)) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao deletar objeto: " + e.getMessage());
        }
    }

    // Verifica se o CPF já existe
    public boolean existeCpf(String cpf) {
        List<T> lista = ler();
        for (T item : lista) {
            if (mapper.getCpf(item).equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}