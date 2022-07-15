package com.mac0439.projeto.user

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Habilidade")
class Skill() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var identificador: Int = 0
    @Column(unique=true)
    var nome: String = ""
    @Column(unique=true)
    var descricao: String = ""

    constructor(nome: String, descricao: String) : this() {
        this.nome = nome
        this.descricao = descricao
    }
}