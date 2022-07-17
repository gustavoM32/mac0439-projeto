package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Publication

interface CommunityCustomRepository {
    @Throws(Exception::class)
    fun updateCommunity(community: Community)
    @Throws(Exception::class)
    fun addPublication(community: String, publication: Publication)
}
