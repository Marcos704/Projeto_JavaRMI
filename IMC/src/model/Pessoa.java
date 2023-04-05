package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nomePessoa;
    private Double pesoPessoa;
    private Double alturaPessoa;
    private Double imcPessoa;

    public Pessoa() {
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public Double getPesoPessoa() {
        return pesoPessoa;
    }

    public Double getAlturaPessoa() {
        return alturaPessoa;
    }

    public Double getImcPessoa() {
        return imcPessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setPesoPessoa(Double pesoPessoa) {
        this.pesoPessoa = pesoPessoa;
    }

    public void setAlturaPessoa(Double alturaPessoa) {
        this.alturaPessoa = alturaPessoa;
    }

    public void setImcPessoa(double imcPessoa) {
        this.imcPessoa = imcPessoa;
    }

}
