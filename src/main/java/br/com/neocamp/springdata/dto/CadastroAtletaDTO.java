package br.com.neocamp.springdata.dto;

//Recebe os dados do POST (criação)
public class CadastroAtletaDTO {

    private String nome;
    private String posicao;
    private Long timeId;

    public CadastroAtletaDTO(){}

    public CadastroAtletaDTO(String nome, String posicao, Long timeId) {
        this.nome = nome;
        this.posicao = posicao;
        this.timeId = timeId;
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

    public Long getTimeId() {
        return timeId;
    }
    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }
}
