package HumanResources.repository;

import HumanResources.entity.Project;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    public List<Project> findAll(){
        List<Project> projects = new ArrayList<>();
        try(FileReader fileReader = new FileReader("src/HumanResources/data/project.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line;
            String[] data;
            Project project;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                project = new Project(Integer.parseInt(data[0]), data[1],
                        LocalDate.parse(data[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalDate.parse(data[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")), data[4]);
                projects.add(project);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return projects;
    }
    public boolean add(Project project) {
        List<Project> projects = findAll();
        boolean isExist = projects.stream().anyMatch(p -> p.getId() == project.getId());
        if (isExist) {
            return false;
        }
        projects.add(project);
        writeFile(projects);
        return true;
    }

    public boolean delete(int id) {
        List<Project> projects = findAll();
        boolean removed = projects.removeIf(c -> c.getId() == id);
        if (removed) {
            writeFile(projects);
        }
        return removed;
    }

    public boolean update(int id, Project newProject) {
        List<Project> projects = findAll();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.set(i, newProject);
                writeFile(projects);
                return true;
            }
        }
        return false;
    }

    private void writeFile(List<Project> projects){
        try(FileWriter fileWriter = new FileWriter("src/HumanResources/data/project.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (Project project : projects){
                bufferedWriter.write(formatWriteFile(project));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file");
        }
    }
    private String formatWriteFile(Project project){
        String startDate = project.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endDate = project.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return project.getId() + "," + project.getName() + "," + startDate + "," + endDate + "," + project.getStatus();
    }
}
