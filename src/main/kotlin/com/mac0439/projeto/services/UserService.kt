package com.mac0439.projeto.services

import com.mac0439.projeto.domain.postgres.User
import com.mac0439.projeto.domain.postgres.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val repository: UserRepository,
) {
    fun findById(id: String): Optional<User> {
        return repository.findById(id)
    }

    fun findAll(): MutableIterable<User> {
        return repository.findAll()
    }
}
