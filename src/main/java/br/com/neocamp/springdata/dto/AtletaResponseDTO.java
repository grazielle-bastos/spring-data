package br.com.neocamp.springdata.dto;

//Devolve os dados no GET (listagem e consulta)
public class AtletaResponseDTO {

    private Long id;
    private String nome;
    private String posicao;
    private String clube;

    public AtletaResponseDTO() {}

    public AtletaResponseDTO(Long id, String nome, String posicao, String clube) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.clube = clube;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getClube() {
        return clube;
    }
    public void setClube(String clube) {
        this.clube = clube;
    }
}
