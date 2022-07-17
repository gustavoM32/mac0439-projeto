package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment

interface PublicationCustomRepository {
    @Throws(Exception::class)
    fun addComment(publication: String, comment: Comment)
    @Throws(Exception::class)
    fun deleteComment(pid: String, cmid: String)
}
