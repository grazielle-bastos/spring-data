package br.com.neocamp.springdata.dto;

public class CadastroTimeDTO {

    //Classe para retornar apenas os dados específicos (nome e país) do time, para a Controller
    //Contrato de dados entre a Controller e a Service

    //Atributos
    private String clube;
    private String pais;
    private Integer fundacao;

    //Construtor vazio
    public CadastroTimeDTO() {}

    public CadastroTimeDTO(String clube, String pais, Integer fundacao) {
        this.clube = clube;
        this.pais = pais;
        this.fundacao = fundacao;
    }

    // Getters e Setters
    public String getClube() {
        return clube;
    }
    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getFundacao() {
        return fundacao;
    }
    public void setFundacao(Integer fundacao) {
        this.fundacao = fundacao;
    }

    @Override
    public String toString() {
        return "CadastroTimeDTO{" +
                "clube='" + clube + '\'' +
                ", pais='" + pais + '\'' +
                ", fundacao=" + fundacao +
                '}';
    }
}
