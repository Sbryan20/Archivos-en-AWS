package com.tenemea.app.springbootS3.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String nombre;

    private String clave;
    private String email;
    private Boolean estado;
    private String imagenPath;
    private String pdfPath;
    @Transient
    private String pdfUrl;
    @Transient
    private String imagenUrl;

}
