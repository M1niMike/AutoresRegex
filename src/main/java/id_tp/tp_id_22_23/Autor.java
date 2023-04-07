/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

/**
 *
 * @author mikae
 */
public class Autor {
    int id;
    String nome;
    String data_nasc;
    String data_morte; 
    String nacionalidade;
    String genero_literario;
    String ocupacoes;
    String premios;
    String infoMais;
    //Fotografia

    public Autor(int id, String nome, String data_nasc, String data_morte, String nacionalidade, String genero_literario, String ocupacoes, String premios, String infoMais) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.data_morte = data_morte;
        this.nacionalidade = nacionalidade;
        this.genero_literario = genero_literario;
        this.ocupacoes = ocupacoes;
        this.premios = premios;
        this.infoMais = infoMais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setData_morte(String data_morte) {
        this.data_morte = data_morte;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setGenero_literario(String genero_literario) {
        this.genero_literario = genero_literario;
    }

    public void setOcupacoes(String ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public void setInfoMais(String infoMais) {
        this.infoMais = infoMais;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public String getData_morte() {
        return data_morte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getGenero_literario() {
        return genero_literario;
    }

    public String getOcupacoes() {
        return ocupacoes;
    }

    public String getPremios() {
        return premios;
    }

    public String getInfoMais() {
        return infoMais;
    }
}
