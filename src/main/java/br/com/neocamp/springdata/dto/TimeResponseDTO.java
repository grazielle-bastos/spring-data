package br.com.neocamp.springdata.dto;

public class TimeResponseDTO {

    //Classe para retornar apenas os dados específicos (nome e país) do time, para a Controller
    //Contrato de dados entre a Controller e a Service

    //Atributos
    private String clube;
    private String pais;

    //Construtor vazio
    public TimeResponseDTO(){}

    //Construtor
    public TimeResponseDTO(String clube, String pais) {
        this.clube = clube;
        this.pais = pais;
    }

    //Getters e Setters
    public String getClube(){
        return clube;
    }
    public void setClube(String clube){
        this.clube = clube;
    }

    public String getPais(){
        return pais;
    }
    public void setPais(String pais){
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "TimeResponseDTO{" +
                "clube='" + clube + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
