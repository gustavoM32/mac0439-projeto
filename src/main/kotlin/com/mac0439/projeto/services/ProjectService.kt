package com.mac0439.projeto.services

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ProjectService(private val repository: ProjectRepository,
                     private val taskService: TaskService) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)
     fun findById(id: String): Optional<Project> {
        return repository.findById(id)
    }

    fun deleteTask(tid: String) { // new
        try {
            repository.deleteTask(tid)
        } catch (e: Exception) {
            logger.error(e.toString())
            throw Exception("Task to delete not found")
        }
    }

    fun addProject(project: Project): Project {
        project.created = LocalDateTime.now()
        return repository.save(project)
    }
//
//    fun addProject(project: Project, parent : Project): Project {
//
//        project.created = LocalDateTime.now()
//        //repository.addProjectToParent(parent.id, project.id)
//        //return repository.save(project)
//        return repository.save(project)
//    }

    fun addToSubprojectList(project: Project, parent : Project):Project {
        //project.created = LocalDateTime.now()
        var res: Project
        try {
            // event deletion should delete it from their context list
            res = repository.addProjectToParent(parent.id, project.id)
        } catch (e: Exception) {
            logger.error(e.toString())
            throw Exception("Project to add not found")
        }

        return res

    }


    fun findByName(name: String): Optional<Project> {
        return repository.findByName(name)
    }
    fun findAll(): List<Project> {
        return repository.findAll()
    }

    @Throws(Exception::class)
    fun deleteProject(id: String) {
        val project: Project

        try {
            project = this.findById(id).get()
        } catch (e: Exception) {
            logger.error(e.toString())
            throw Exception("Project to delete not found")
        }

        // project deletion should delete its subprojects
        project.subprojects?.let {
            for (s: Project in it) {
                checkNotNull(s.id)
                repository.deleteById(s.id)
            }
        }

        // project deletion should delete its subtasks
        project.task_list?.let {
            for (t: Task in it) {
                checkNotNull(t.id)
                taskService.deleteTask(t.id)
            }
        }

        repository.deleteById(id)
    }

}
