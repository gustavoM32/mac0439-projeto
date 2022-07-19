//package com.mac0439.projeto.domain.neo4j.repositories
//
//import com.mac0439.projeto.domain.neo4j.project.Project
//import com.mac0439.projeto.domain.neo4j.task.Task
//import org.neo4j.driver.Query
//import org.springframework.stereotype.Repository
//
//@Repository
//class ProjectCustomRepositoryImpl : ProjectCustomRepository {
//    override fun deleteTask(pid: Project, tid: Task) {
//        val update = Update()
//            .set("name", community.name)
//            .set("description", community.description)
//        val result = mongoOperations.updateFirst(query, update, Community::class.java)
//        if (result.matchedCount != 1L) {
//            throw Exception("Community update had ${result.matchedCount} matches")
//        }
//    }
//
//    @Query("MATCH(:User {mobile: \$mobile1})-[c:CONTACT]-(user2:User {mobile:\$mobile2}) DETACH DELETE c")
//    fun deleteTask(pid: String?, tid: String?): String?;
//
//    override fun deleteEvent(cid: String, eid: String) {
//
//        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(cid))
//        val update = Update().pull("events", eid)
//        val result = mongoOperations.updateFirst(query, update, Community::class.java)
//        if (result.modifiedCount != 1L) {
//            throw Exception("Event deletion caused ${result.modifiedCount} modifications")
//        }
//    }
//}