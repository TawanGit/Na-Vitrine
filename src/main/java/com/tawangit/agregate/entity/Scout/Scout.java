package com.tawangit.agregate.entity.Scout;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_scouts")
public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID scoutId;

    @Column(name = "scoutName")
    private String scoutName;

    @Column(name = "club")
    private String club;

    @Past(message = "A data de nascimento deve ser no passado")
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Scout() {
    }

    public Scout(UUID scoutId, String scoutName, String email, String password, String club, LocalDate dateOfBirth, Instant creationTimestamp, Instant updateTimestamp) {
        this.scoutId = scoutId;
        this.scoutName = scoutName;
        this.email = email;
        this.password = password;
        this.club = club;
        this.dateOfBirth = dateOfBirth;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public UUID getScoutId() {
        return scoutId;
    }

    public void setScoutId(UUID scoutId) {
        this.scoutId = scoutId;
    }

    public String getScoutName() {
        return scoutName;
    }

    public void setScoutName(String scoutName) {
        this.scoutName = scoutName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
