
package MODEL;

import java.text.ParseException;

public class Pessoa {
    
    private int id_pessoa;
    private String nome;
    private String cpf;
    private String dataNasc;
    private String idade;
    private long contatoTel;
    private String consultaReal;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String cpf, String dataNasc, String idade) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.idade = idade;
    }

    public Pessoa(String nome, String cpf, String dataNasc, String idade, long contatoTel, String consultaReal) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.contatoTel = contatoTel;
        this.consultaReal = consultaReal;
    }
    
    public Pessoa(int id_pessoa, String nome, String cpf, String dataNasc, String idade, int contatoTel, String consultaReal) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.contatoTel = contatoTel;
        this.consultaReal = consultaReal;
    }
    
    
    public int getId_pessoa() {
        return id_pessoa;
    }
    
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public long getContatoTel() {
        return contatoTel;
    }

    public void setContatoTel(int contatoTel) {
        this.contatoTel = contatoTel;
    }

    public String getConsultaReal() {
        return consultaReal;
    }

    public void setConsultaReal(String consultaReal) {
        this.consultaReal = consultaReal;
    }

}
