package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Publication

interface CommunityCustomRepository {
    fun addPublication(community: String, publication: Publication)
}
