package com.mac0439.projeto.domain.postgres.repositories

import com.mac0439.projeto.domain.postgres.Skill
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : CrudRepository<Skill, String>