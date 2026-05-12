package HumanResources.service.Imp;

import HumanResources.entity.Project;
import HumanResources.repository.ProjectRepository;
import HumanResources.service.IProjectService;

import java.util.List;

public class ProjectService implements IProjectService {
    private static ProjectRepository projectRepository = new ProjectRepository();
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public boolean add(Project project) {
        return projectRepository.add(project);
    }

    @Override
    public boolean delete(int id) {
        return projectRepository.delete(id);
    }

    @Override
    public boolean update(int id, Project project) {
        return projectRepository.update(id, project);
    }

    @Override
    public Project findById(int id) {
        return findAll().get(id);
    }
}
