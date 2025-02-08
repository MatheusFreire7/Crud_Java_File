# CRUD App em Java

Este é um projeto simples de CRUD (Create, Read, Update, Delete) em Java, que permite gerenciar informações de pessoas. O projeto utiliza um arquivo de texto (`pessoas.txt`) para armazenar os dados das pessoas, e inclui validações para CPF e e-mail.

## Funcionalidades

- **Criar Pessoa**: Adiciona uma nova pessoa ao sistema.
- **Listar Pessoas**: Exibe todas as pessoas cadastradas em formato de tabela.
- **Atualizar Pessoa**: Atualiza os dados de uma pessoa existente.
- **Deletar Pessoa**: Remove uma pessoa do sistema.
- **Validações**: Inclui validações para CPF, e-mail e idade.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:
src/
├── CRUDApp.java
├── FileRepository.java
├── Pessoa.java
├── PessoaMapper.java
├── CPFUtils.java
├── EmailUtils.java

- **CRUDApp.java**: Contém a lógica principal do aplicativo, incluindo o menu interativo.
- **FileRepository.java**: Responsável por gerenciar a leitura e escrita de dados no arquivo `pessoas.txt`.
- **Pessoa.java**: Representa a entidade Pessoa com seus atributos (ID, Nome, Idade, CPF, Email).
- **PessoaMapper.java**: Responsável por mapear objetos `Pessoa` para strings e vice-versa.
- **CPFUtils.java**: Contém métodos para validar e formatar CPF.
- **EmailUtils.java**: Contém métodos para validar e-mails.

## Como Executar

1. **Pré-requisitos**:
   - Java Development Kit (JDK) instalado.
   - Ambiente de desenvolvimento Java (IDE ou terminal).

2. **Compilação e Execução**:
   - Abra o terminal na pasta raiz do projeto.
   - Compile o projeto:
     ```bash
     javac src/*.java -d bin
     ```
   - Execute o projeto:
     ```bash
     java -cp bin src.CRUDApp
     ```

3. **Uso**:
   - Siga as instruções no menu interativo para criar, listar, atualizar ou deletar pessoas.

## Validações Implementadas

- **CPF**: O CPF é validado e formatado antes de ser armazenado.
- **E-mail**: O e-mail é validado para garantir que esteja em um formato válido.
- **Idade**: A idade deve estar entre 0 e 150 anos.

## Exemplo de Uso

1. **Criar Pessoa**:
   - Digite `1` no menu.
   - Insira o nome, idade, CPF e e-mail da pessoa.
   - O sistema validará os dados e, se tudo estiver correto, a pessoa será criada.

2. **Listar Pessoas**:
   - Digite `2` no menu.
   - O sistema exibirá todas as pessoas cadastradas em formato de tabela.

3. **Atualizar Pessoa**:
   - Digite `3` no menu.
   - Insira o CPF da pessoa que deseja atualizar.
   - Insira os novos dados (nome, idade, e-mail).
   - O sistema validará os dados e atualizará a pessoa.

4. **Deletar Pessoa**:
   - Digite `4` no menu.
   - Insira o CPF da pessoa que deseja deletar.
   - O sistema removerá a pessoa do arquivo.

5. **Sair**:
   - Digite `5` no menu para sair do programa.
