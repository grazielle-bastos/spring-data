package br.com.neocamp.springdata.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "atletas") // Representa a tabela "atletas", sendo mapeada na base de dados pelo JPA
public class AtletasEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String posicao;

    // Associação com a chave estrangeira (fk)
    // Relacionamento ManyToOne (Cada atleta pertence a um time)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id", //Nome da coluna foreign Key no banco
            foreignKey = @ForeignKey(name = "fk_atletas_times"), //Nome da constraint
            nullable = false)
    private TimesEntities time;

    // Construtores
    public AtletasEntities() {

    }

    public AtletasEntities(String nome, String posicao, TimesEntities time) {
        this.nome = nome;
        this.posicao = posicao;
        this.time = time;
    }

    // Getters e setters
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

    public TimesEntities getTime() {
        return time;
    }

    public void setTime(TimesEntities time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AtletasEntities{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", posicao='" + posicao + '\'' +
                ", time=" + time +
                '}';
    }
}
