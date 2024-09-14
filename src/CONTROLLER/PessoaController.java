/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import JDBC_DAO.Pessoa_DAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author itiel
 */
public class PessoaController {
    private Pessoa_DAO pessoaDAO;

    public PessoaController() {
        this.pessoaDAO = new Pessoa_DAO();
    }

    public void inserirPessoa(String nome, String cpf, String dataNascimentoStr, String telefone, String consultaRealizada) throws SQLException {
        // Validações de dados
        if (nome.isEmpty() || cpf.isEmpty() || dataNascimentoStr.isEmpty() || telefone.isEmpty() || consultaRealizada.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        // Formatação da data
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, inputFormatter);

        // Verifica se a data de nascimento é posterior à data atual
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }

        // Calcula a idade
        int idadeInt = CalculadoraIdade.calcularIdade(dataNascimento);
        if (idadeInt >= 120 || idadeInt < 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        // Valida CPF
        if (!ValidadorCPF.isCPF(cpf)) {
            throw new IllegalArgumentException("CPF informado incorreto.");
        }

        // Converte o telefone para long
        long contatoTel = Long.parseLong(telefone);

        
        // Converte a data de nascimento para o formato desejado pelo banco de dados
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dataNasc = dataNascimento.format(outputFormatter);

        // Insere a pessoa no banco de dados
        pessoaDAO.AdPessoa(nome, cpf, dataNasc, String.valueOf(idadeInt), contatoTel, consultaRealizada);
    }
    
    public void removerPessoa(int id_pessoa) throws SQLException {

        // Remove a pessoa do banco de dados
        pessoaDAO.RmPessoa(id_pessoa);
    }
    
    public void alterarPessoa(int idPessoa, String nome, String cpf, String dataNas, String telefone, String consultaReal) throws SQLException {
        // Validações de dados
        if (nome.isEmpty() || cpf.isEmpty() || dataNas.isEmpty() || telefone.isEmpty() || consultaReal.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        // Formatação da data
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNas, inputFormatter);

        // Verifica se a data de nascimento é posterior à data atual
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }

        // Calcula a idade
        int idadeInt = CalculadoraIdade.calcularIdade(dataNascimento);
        if (idadeInt >= 150 || idadeInt <= 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        // Valida CPF
        if (!ValidadorCPF.isCPF(cpf)) {
            throw new IllegalArgumentException("CPF informado incorreto.");
        }

        // Converte o telefone para long
        long contatoTel = Long.parseLong(telefone);

        // Converte a data de nascimento para o formato desejado pelo banco de dados
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dataNasc = dataNascimento.format(outputFormatter);

        // Altera a pessoa no banco de dados
        pessoaDAO.AtPessoa(idPessoa, nome, cpf, dataNasc, String.valueOf(idadeInt), contatoTel, consultaReal);
    }
    
}
