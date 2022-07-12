package com.mac0439.projeto.publication

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PublicationRepository : MongoRepository<Publication, String>
