package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import com.mac0439.projeto.domain.neo4j.repositories.UserNeoRepository
import com.mac0439.projeto.services.ProjectService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class ProjectController(private val service: ProjectService,
                        private val repository: ProjectRepository,
                        private val user_repository: UserNeoRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    @GetMapping("/projects")
    fun getProjects(model: Model): String {
        model.addAttribute("projects", service.findAll())
        return "projects/index"
    }

    @GetMapping("/projects/{id}")
    fun getProject(@PathVariable id: String, model: Model): String {
        val project = service.findById(id)
        if (project.isEmpty) {
            return "error"
        }
        model.addAttribute("project", project.get())
        return "projects/project"
    }

//    @RequestMapping("/projects/names", method = [RequestMethod.GET]) //"/projects?name={name}"
//    fun getProjectFromNames(@RequestParam(value = "name") name: String, model: Model): String {
//        val project = service.findByName(name)
//        if (project.isEmpty) {
//            return "error"
//        }
//        model.addAttribute("project", project.get())
//        return "projects/project"
//    }

    @GetMapping("/projects/add-project")
    fun addProject(@ModelAttribute new_project: Project): String {
        logger.info("get /projects/add-project")
//        val user = user_repository.findByName("Viago").get()
//        new_project.creator = user

        return "projects/add_project"
        //return repository.save(new_project)
    }

    @GetMapping("/projects/{id}/add-project")
    fun addSubproject(@PathVariable id: String, @ModelAttribute new_subproject: Project, model : Model): String {
        logger.info("get /projects/${id}/add-project")

        model.addAttribute("parent_id", id)
        model.addAttribute("new_project", new_subproject)
        return "projects/add_subproject"
    }

    @PostMapping("/projects/{id}")
    fun postProjects(@PathVariable id: String, @ModelAttribute project: Project): String {
        logger.info("post /projects/${id}")
        val parent = repository.findById(id).get()
        logger.info("parent ${parent.name}")
        logger.info("parent ${parent.subprojects}")
        logger.info("filho ${project.name}")
        val user = user_repository.findByName("Viago").get()
        var novo_gambiarra = Project(name=project.name, description = project.description, creator = user)

        logger.info("parent ${parent.name}")
        //project.creator
        val added = service.addProject(novo_gambiarra)
        logger.info("filho ${added.id}")
        logger.info("pai ${parent.id}")

        var p = service.addToSubprojectList(added, parent)

        return "redirect:/projects/${p.id}"
    }

    @PostMapping("/projects")
    fun postProjects(@ModelAttribute project: Project): String {
        logger.info("post /projects")
        //project.creator
        val addedProject = service.addProject(project)
        return "redirect:/projects/${addedProject.id}"
    }

    @DeleteMapping("/projects/{id}")
    @ResponseBody
    fun deleteProject(@PathVariable id: String) {
        logger.info("delete /projects/${id}")
        try {
            service.deleteProject(id)
        } catch (e: Exception) {
            logger.error(e.toString())
            return
        }
    }

}

//
//// Create
//@GetMapping("/communities/add-community")
//fun getCommunitiesAdd(@ModelAttribute community: Community): String {
//    logger.info("get /communities/add-community")
//    return "communities/add_community"
//}