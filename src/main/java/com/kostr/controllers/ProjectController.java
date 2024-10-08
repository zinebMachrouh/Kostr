package main.java.com.kostr.controllers;

import main.java.com.kostr.dto.ProjectDTO;
import main.java.com.kostr.models.Project;
import main.java.com.kostr.models.enums.ProjectStatus;
import main.java.com.kostr.services.interfaces.ProjectServiceInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {
    private ProjectServiceInterface projectService;

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";
    public static final String YELLOW = "\u001b[93m";

    public ProjectController(ProjectServiceInterface projectService) {
        this.projectService = projectService;
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) throws SQLException {
        if (projectDTO == null) {
            System.out.println(RED + "ProjectDTO is null" + RESET);
            return null;
        }

        try {
            Project project = projectService.addProject(projectDTO);
            System.out.println(YELLOW + "Project created successfully" + RESET);
            return ProjectDTO.modelToDTO(project);
        } catch (SQLException e) {
            System.out.println(RED + "Error creating project" + RESET);
            throw e;
        }
    }


    public List<ProjectDTO> getClientProjects(String clientId) throws SQLException {
        if (clientId == null || clientId.isEmpty()) {
            System.out.println(RED + "Client ID is null or empty" + RESET);
            return null;
        }

        try {
            System.out.println(BLUE + "Fetching projects for client with ID: " + clientId + RESET);
            ArrayList<Project> projects = projectService.getClientProjects(clientId);
            if (projects != null) {
                List<ProjectDTO> projectDTOList = new ArrayList<>();
                for (Project project : projects) {
                    projectDTOList.add(ProjectDTO.modelToDTO(project));
                }
                return projectDTOList;
            } else {
                System.out.println(RED + "No projects found for client" + RESET);
                return null;
            }
        } catch (SQLException e) {
            System.out.println(RED + "Error fetching client projects" + RESET);
            throw e;
        }
    }

    public List<ProjectDTO> getAllProjects() throws SQLException {
        try {
            System.out.println(BLUE + "Fetching all projects" + RESET);
            ArrayList<Project> projects = projectService.getProjects();
            if (projects != null) {
                List<ProjectDTO> projectDTOList = new ArrayList<>();
                for (Project project : projects) {
                    projectDTOList.add(ProjectDTO.modelToDTO(project));
                }
                return projectDTOList;
            } else {
                System.out.println(RED + "No projects found" + RESET);
                return null;
            }
        } catch (SQLException e) {
            System.out.println(RED + "Error fetching projects" + RESET);
            throw e;
        }
    }

    public int getClientProjectsCount(String clientId) throws SQLException {
        if (clientId == null || clientId.isEmpty()) {
            System.out.println(RED + "Client ID is null or empty" + RESET);
            return 0;
        }

        try {
            return projectService.getClientProjectsCount(clientId);
        } catch (SQLException e) {
            System.out.println(RED + "Error fetching client project count" + RESET);
            throw e;
        }
    }

    public ProjectDTO updateProjectStatus(String projectId, ProjectStatus status) throws SQLException {
        if (projectId == null || projectId.isEmpty()) {
            System.out.println(RED + "Project ID is null or empty" + RESET);
            return null;
        }

        try {
            Project updatedProject = projectService.updateStatus(projectId, status);
            if (updatedProject != null) {
                return ProjectDTO.modelToDTO(updatedProject);
            } else {
                System.out.println(RED + "Project not found or status update failed" + RESET);
                return null;
            }
        } catch (SQLException e) {
            System.out.println(RED + "Error updating project status" + RESET);
            throw e;
        }
    }

    public ProjectDTO updateTotalCost(String projectId, double totalCost) throws SQLException {
        if (projectId == null || projectId.isEmpty()) {
            System.out.println(RED + "Project ID is null or empty" + RESET);
            return null;
        }

        try {
            Project updatedProject = projectService.updateTotalCost(projectId, totalCost);
            if (updatedProject != null) {
                return ProjectDTO.modelToDTO(updatedProject);
            } else {
                System.out.println(RED + "Project not found or total cost update failed" + RESET);
                return null;
            }
        } catch (SQLException e) {
            System.out.println(RED + "Error updating project total cost" + RESET);
            throw e;
        }
    }
}
