package com.tawangit.agregate.entity.Trialist;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_trialists")
public class Trialist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID trialistId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "document")
    private String document;

    @Column(name = "cellphone", length = 20)
    private String cellphone;


    @Column(name = "position")
    private TrialistPosition positions;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Trialist() {

    }


    public Trialist(UUID trialistId, String name, LocalDate dateOfBirth, String cellphone, List<String> positions, Instant creationTimestamp, Instant updateTimestamp) {
        this.trialistId = trialistId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cellphone = cellphone;
        this.positions = positions;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public UUID getTrialistId() {
        return trialistId;
    }

    public void setTrialistId(UUID trialistId) {
        this.trialistId = trialistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}

