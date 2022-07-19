package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.UserNeoRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import com.mac0439.projeto.services.ProjectService
import com.mac0439.projeto.services.TaskService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class TaskController(private val service: TaskService,
                     private val projectService: ProjectService,
                     private val user_repository: UserNeoRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    @GetMapping("/tasks")
    fun getTasks(model: Model): String {
        model.addAttribute("tasks", service.findAll())
        return "tasks/index"
    }

    @GetMapping("/projects/{cid}/tasks") // new
    fun getProjectTasks(@PathVariable cid: String, model: Model): String {
        logger.info("get /projects/$cid/tasks")
        val project : Project

        try {
            project = projectService.findById(cid).get()
            //community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/projects"
        }
        model.addAttribute("tasks", project.task_list ?: listOf<Task>())
        model.addAttribute("project", project)

        return "projects/tasks/index"
    }

    @GetMapping("/projects/{cid}/tasks/{tid}") // new
    fun getTask(@PathVariable cid: String, @PathVariable tid: String, model: Model): String {
        val task = service.findById(tid)
        if (task.isEmpty) {
            return "error"
        }
        model.addAttribute("task", task.get())
        model.addAttribute("cid", cid)
        return "tasks/task"
    }
//
//    @GetMapping("/projects/{cid}/tasks/add-task") // new
//    fun addTask(@PathVariable cid: String, @ModelAttribute new_task: Task): String {
//        logger.info("get /projects/{cid}/tasks/add-task")
//        val project : Project
//
//        try {
//            project = projectService.findById(cid).get()
//        } catch (e: Exception) {
//            logger.error(e.toString())
//            return "redirect:/projects/$cid/tasks"
//        }
//
//        model.addAttribute("project", project)
//        return "projects/tasks/add_event"
//        //return repository.save(new_project)
//    }
//

    @PostMapping("/projects/{cid}/tasks") // new
    fun postProjects(@PathVariable cid: String, @ModelAttribute task: Task): String {
        logger.info("post /projects/{cid}/tasks")
        //project.creator
        val addedTask = service.addTask(task)

        //return "redirect:/communities/${cid}/events"
        return "redirect:/project/${cid}/tasks"
    }

    //     @DeleteMapping("/communities/{cid}/events/{eid}")

    @DeleteMapping("/projects/{cid}/tasks/{tid}") // new
    @ResponseBody
    fun deleteTask(@PathVariable cid: String, @PathVariable tid: String) {
        logger.info("delete /projects/${cid}/tasks/${tid}")
        try {
            //service.deleteTask(id)
            //service.deleteTask(cid, tid)
            projectService.deleteTask(cid, tid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return
        }
    }
    @GetMapping("/projects/{cid}/tasks/{tid}/add-task")
    fun addTask(@PathVariable cid: String, @ModelAttribute new_task: Task): String {
        logger.info("get /projects/{cid}/tasks/{tid}/add-task")

        return "tasks/add_task_from_project"

    }
    @GetMapping("/projects/{cid}/tasks/{tid}/add-task")
    fun postProjects(@PathVariable cid: String, @ModelAttribute new_task: Task): String {
        logger.info("get /projects/{cid}/tasks/{tid}/add-task")

        return "tasks/add_task_from_project"

    }

    @GetMapping("tasks/{id}")
    fun getTasks(@PathVariable id: String, model: Model): String {
        model.addAttribute("hello", id)
        val task = service.findById(id)
        if (task.isEmpty) {
            return "error"
        }
        model.addAttribute("task", task.get())
        return "tasks/task"
    }

    @GetMapping("/tasks/add-task")
    fun addTask(@ModelAttribute new_task: Task): String {
        logger.info("get /tasks/add-task")

        return "tasks/add_task"
        //return repository.save(new_project)
    }

    @PostMapping("/tasks")
    fun postProjects(@ModelAttribute task: Task): String {
        logger.info("post /tasks")
        //project.creator
        val addedTask = service.addTask(task)
        return "redirect:/tasks/${addedTask.id}"
    }

//    @DeleteMapping("/tasks/{id}")
//    @ResponseBody
//    fun deleteTask(@PathVariable id: String) {
//        logger.info("delete /tasks/${id}")
//        try {
//            service.deleteTask(id)
//        } catch (e: Exception) {
//            logger.error(e.toString())
//            return
//        }
//    }
}