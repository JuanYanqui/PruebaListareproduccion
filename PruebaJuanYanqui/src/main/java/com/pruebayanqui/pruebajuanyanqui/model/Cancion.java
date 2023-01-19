package com.pruebayanqui.pruebajuanyanqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    private Integer id_cancion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "artista")
    private String artista;

    @Column(name = "album")
    private String album;

    @Column(name = "year")
    private Date year;

    @JsonIgnore
    @OneToMany( mappedBy = "cancion")
    private List<ListaReproduccion> listaReproduccion;
}

