package br.com.franklin.projetofinal;

import java.lang.ref.SoftReference;

/**
 * Created by Franklin on 04/12/2016.
 */

public class Contato {

    private String nome;
    private String cpf;
    private String email;
    private String idade;
    private String telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    Contato(String nome, String telefone, String cpf, String email, String idade) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;

    }

    }