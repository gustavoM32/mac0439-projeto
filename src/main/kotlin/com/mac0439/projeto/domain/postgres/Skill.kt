package com.mac0439.projeto.domain.postgres

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import com.mac0439.projeto.domain.postgres.User;

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

    @ManyToMany(mappedBy="skills")
    var skilledUsers: MutableList<User> = mutableListOf()

    constructor(nome: String, descricao: String) : this() {
        this.nome = nome
        this.descricao = descricao
    }
}