package com.hugoulloa.foro_hub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private Boolean solucion = false;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    @JsonIgnore
    private Topico topico;

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public Topico getTopico() {
        return topico;
    }

    // ===== SETTERS =====

  /*  public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public void setSolucion(Boolean solucion) {
        this.solucion = solucion;*/
    }

