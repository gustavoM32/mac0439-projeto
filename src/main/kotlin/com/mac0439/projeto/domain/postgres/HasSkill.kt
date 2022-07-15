package com.mac0439.projeto.domain.postgres

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Possui_Habilidade")
class HasSkill() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var identificador: Int = 0
    var nome_usuario: String = ""
    var id_habilidade: Int = 0

    constructor(nome_usuario: String, id_habilidade: Int) : this() {
        this.nome_usuario = nome_usuario
        this.id_habilidade = id_habilidade
    }
}