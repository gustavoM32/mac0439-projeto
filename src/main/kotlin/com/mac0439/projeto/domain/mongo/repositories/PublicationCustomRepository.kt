package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication

interface PublicationCustomRepository {
    @Throws(Exception::class)
    fun updatePublication(publication: Publication)
    @Throws(Exception::class)
    fun findCommentById(pid: String, cmid: String): Comment
    @Throws(Exception::class)
    fun addComment(pid: String, comment: Comment)
    @Throws(Exception::class)
    fun updateComment(pid: String, comment: Comment)
    @Throws(Exception::class)
    fun deleteComment(pid: String, cmid: String)
    @Throws(Exception::class)
    fun addLikeToComment(pid: String, cmid: String, user: String)
    @Throws(Exception::class)
    fun removeLikeFromComment(pid: String, cmid: String, user: String)
}
