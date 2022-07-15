package com.mac0439.projeto.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : CrudRepository<Skill, String>