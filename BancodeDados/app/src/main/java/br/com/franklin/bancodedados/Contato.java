package br.com.franklin.bancodedados;

/**
 * Created by Franklin on 04/12/2016.
 */

public class Contato {

    private String nome;
    private String endereco;
    private String empresa;

    Contato(String nome, String endereco, String empresa) {
        this.nome = nome;
        this.endereco = endereco;
        this.empresa = empresa;

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


}
