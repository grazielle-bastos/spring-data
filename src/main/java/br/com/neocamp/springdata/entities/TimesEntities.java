package br.com.neocamp.springdata.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "times") // Representa a tabela "times", sendo mapeada na base de dados pelo JPA
public class TimesEntities {

    //Etapa 1 do Fluxo de implementacao e comunicacao de uma funcionalidade da API
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clube;
    private String pais;
    private Integer fundacao;

    // Relacionamento One-to-Many (Cada time pode ter vários atletas)
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AtletasEntities> atletas;

    // Construtores
    public TimesEntities() {
    }

    public TimesEntities(String clube, String pais, Integer fundacao) {
        this.clube = clube;
        this.pais = pais;
        this.fundacao = fundacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getFundacao(){
        return fundacao;
    }

    public void setFundacao(Integer fundacao){
        this.fundacao = fundacao;
    }

    public List<AtletasEntities> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<AtletasEntities> atletas){
        this.atletas = atletas;
    }

    @Override
    public String toString() {
        return "TimesEntities{" +
                "id=" + id +
                ", clube='" + clube + '\'' +
                ", pais='" + pais + '\'' +
                ", fundacao=" + fundacao +
                '}';
    }
}
