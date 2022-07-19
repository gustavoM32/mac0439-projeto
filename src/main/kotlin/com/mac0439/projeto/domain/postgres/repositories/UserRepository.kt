package com.mac0439.projeto.domain.postgres.repositories

import com.mac0439.projeto.domain.postgres.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, String>