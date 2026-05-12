package HumanResources.controller;

import HumanResources.entity.Project;
import HumanResources.service.IProjectService;
import HumanResources.service.Imp.ProjectService;

import java.util.List;

public class ProjectController {
    private IProjectService projectService = new ProjectService();
    public List<Project> getAll() {
        return projectService.findAll();
    }

    public boolean add(Project project) {
        return projectService.add(project);
    }

    public boolean delete(int id) {
        return projectService.delete(id);
    }

    public boolean update(int id, Project project) {
        return projectService.update(id, project);
    }

    public Project findById(int id) {
        return projectService.findById(id);
    }
}
