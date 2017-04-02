package br.com.franklin.afinal;

/**
 * Created by Franklin on 13/12/2016.
 */

public class Contato {

    private String nome;
    private String endereco;
    private String empresa;
    private String telefone;
    private String email;

    Contato(String nome, String endereco, String empresa, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.empresa = empresa;
        this.telefone = telefone;
        this.email = email;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public String getEmpresa() {

        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
