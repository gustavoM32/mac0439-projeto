package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Publication
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PublicationRepository : MongoRepository<Publication, String>, PublicationCustomRepository
