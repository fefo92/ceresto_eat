package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.enumerati.IngredientTypeEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient extends AuditableEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientTypeEnum type;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DettaglioPortata> dettagliPortata;

    public Ingredient(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate,
                      Long id, String name, String description, Double price, IngredientTypeEnum type) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.dettagliPortata = new ArrayList<>();
    }

    public Ingredient() {
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public IngredientTypeEnum getType() {
        return type;
    }

    public void setType(IngredientTypeEnum type) {
        this.type = type;
    }
    
    public List<DettaglioPortata> getDettagliPortata() {
        return dettagliPortata;
    }
    
    public void setDettagliPortata(List<DettaglioPortata> dettagliPortata) {
        this.dettagliPortata = dettagliPortata;
    }
}
