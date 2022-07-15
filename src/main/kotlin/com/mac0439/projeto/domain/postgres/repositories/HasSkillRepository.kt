package com.mac0439.projeto.domain.postgres.repositories

import com.mac0439.projeto.domain.postgres.HasSkill
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HasSkillRepository : CrudRepository<HasSkill, String>