package br.com.projeto.arenapernambuco.model;
import jakarta.persistence.*;
@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String setor;
    private String assento;
    private Double preco;
    private Boolean disponivel = true;
    public Ingresso() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public String getAssento() { return assento; }
    public void setAssento(String assento) { this.assento = assento; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
