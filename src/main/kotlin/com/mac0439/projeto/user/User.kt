package com.mac0439.projeto.user

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name="Usuario")
class User() {
    @Id
    var nome_usuario: String = ""
    var nome: String = ""
    var senha: String = ""
    @Column(unique=true)
    var email: String = ""
    var nascimento: LocalDate = LocalDate.parse("2000-01-01")
    var biografia: String? = null

    constructor(nome_usuario: String, nome: String, senha: String, email: String, nascimento: LocalDate, biografia: String?) : this() {
        this.nome_usuario = nome_usuario
        this.nome = nome
        this.senha = senha
        this.email = email
        this.nascimento = nascimento
        this.biografia = biografia
    }
}