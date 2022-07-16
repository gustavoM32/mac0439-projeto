package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment

interface PublicationCustomRepository {
    fun addComment(publication: String, comment: Comment)
    fun deleteCommentById(pid: String, cmid: String)
}
