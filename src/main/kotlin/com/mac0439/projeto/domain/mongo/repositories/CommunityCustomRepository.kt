package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.publication.Publication

interface CommunityCustomRepository {
    @Throws(Exception::class)
    fun updateCommunity(community: Community)
    @Throws(Exception::class)
    fun addPublication(cid: String, publication: Publication)
    @Throws(Exception::class)
    fun deletePublication(cid: String, pid: String)
    @Throws(Exception::class)
    fun addEvent(cid: String, event: Event)
    @Throws(Exception::class)
    fun deleteEvent(cid: String, eid: String)
}
