/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

/**
 *
 * @author mikae
 */
public class Obras {
    String isbn;
    //String codigo_autor; - Uma excepção
    String nome_autor;
    String titulo; 
    String editora;
    Double preco;
    //Adições a maisQ
    String quant_paginas;
    String idioma;
    String encadernacao;
    
    //String  foto_capa;


    public String getIsbn() {
        return isbn;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuant_paginas(String quant_paginas) {
        this.quant_paginas = quant_paginas;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEncadernacao(String encadernacao) {
        this.encadernacao = encadernacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public Double getPreco() {
        return preco;
    }

    public String getQuant_paginas() {
        return quant_paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getEncadernacao() {
        return encadernacao;
    }
            

    public Obras(String isbn, String nome_autor, String titulo, String editora, Double preco, String quant_paginas, String idioma, String encadernacao) {
        this.isbn = isbn;
        this.nome_autor = nome_autor;
        this.titulo = titulo;
        this.editora = editora;
        this.preco = preco;
        this.quant_paginas = quant_paginas;
        this.idioma = idioma;
        this.encadernacao = encadernacao;
    }
    
}
