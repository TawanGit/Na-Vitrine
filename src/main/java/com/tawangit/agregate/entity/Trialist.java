package com.tawangit.agregate.entity;

import com.tawangit.agregate.controller.trialist.TrialistController;
import com.tawangit.agregate.controller.trialist.TrialistPosition;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
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
    @Enumerated(EnumType.STRING)
    private TrialistPosition positions;

    @Column(name = "inviteToken")
    private String inviteToken;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;




    @ManyToOne
    @JoinColumn(name = "scout_id")
    private Scout scout;

    public Trialist() {

    }


    public Trialist(UUID trialistId, String name, LocalDate dateOfBirth, String cellphone, String email, TrialistPosition positions, String document, Instant creationTimestamp, Instant updateTimestamp) {
        this.trialistId = trialistId;
        this.name = name;
        this.document = document;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getInviteToken() {
        return inviteToken;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
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

    public TrialistPosition getPositions() {
        return positions;
    }

    public void setPositions(TrialistPosition positions) {
        this.positions = positions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Scout getScout() {
        return scout;
    }

    public void setScout(Scout scout) {
        this.scout = scout;
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

