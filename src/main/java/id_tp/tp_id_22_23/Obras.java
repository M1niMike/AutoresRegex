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
    int quant_paginas;
    String ano_edicao;
    String encadernacao;    
    String Foto_capa;
 
    
    
    
    public Obras(String isbn, String nome_autor, String titulo, String editora, Double preco, int quant_paginas, String ano_edi, String encadernacao, String Foto_capa) {
        this.isbn = isbn;
        this.nome_autor = nome_autor;
        this.titulo = titulo;
        this.editora = editora;
        this.preco = preco;
        this.quant_paginas = quant_paginas;
        this.ano_edicao = ano_edi;
        this.encadernacao = encadernacao;
        this.Foto_capa = Foto_capa;
    }

     
    //GETS
    public String getIsbn() { return isbn; }
    public String getNome_autor() { return nome_autor; }
    public String getFoto_capa() { return Foto_capa; }
    public String getTitulo() { return titulo; }
    public String getEditora() { return editora; }
    public Double getPreco() { return preco; }
    public int getQuant_paginas() { return quant_paginas; }
    public String getAno_edicao() { return ano_edicao; }
    public String getEncadernacao() { return encadernacao; }
            
    //SETS
    public void setFoto_capa(String Foto_capa) { this.Foto_capa = Foto_capa; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setNome_autor(String nome_autor) { this.nome_autor = nome_autor; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setEditora(String editora) { this.editora = editora; }
    public void setPreco(Double preco) { this.preco = preco; }
    public void setQuant_paginas(int quant_paginas) { this.quant_paginas = quant_paginas; }
    public void setAno_edicao(String ano_edicao) { this.ano_edicao = ano_edicao; }
    public void setEncadernacao(String encadernacao) { this.encadernacao = encadernacao; }

    
    //Func Aux
    public void printLivro() {
        System.out.println("ISBN: " + this.getIsbn());
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Autor: " + this.getNome_autor());
        System.out.println("Preco: " + this.getPreco() + "€");
        System.out.println("Editora: " + this.getEditora());
        System.out.println("Paginas: " + this.getQuant_paginas());
        System.out.println("Encadernacao: " + this.getEncadernacao());
        System.out.println("Ano de edicao: " + this.getAno_edicao());
        System.out.println("Link capa: " + this.getFoto_capa());
        
    }


  
    
}
