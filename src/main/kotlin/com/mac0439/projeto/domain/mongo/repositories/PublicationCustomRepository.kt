package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication

interface PublicationCustomRepository {
    @Throws(Exception::class)
    fun updatePublication(publication: Publication)
    @Throws(Exception::class)
    fun addComment(publication: String, comment: Comment)
    @Throws(Exception::class)
    fun deleteComment(pid: String, cmid: String)
}
