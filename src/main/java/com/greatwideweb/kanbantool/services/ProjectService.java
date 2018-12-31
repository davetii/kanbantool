package com.greatwideweb.kanbantool.services;

import com.greatwideweb.kanbantool.domain.Project;
import com.greatwideweb.kanbantool.exception.ProjectIdException;
import com.greatwideweb.kanbantool.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project saveForUpdateProject(Project p) {
        try {
            p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
            return projectRepo.save(p);
        } catch(Exception e) {
            throw new ProjectIdException("Project Id '" + p.getProjectIdentifier());

        }
    }

    public Project findProjectByIdentifier(String projectIdentifier) {
        Project p = projectRepo.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if (p == null) {
            throw new ProjectIdException("Project does not exist");
        }
        return p;
    }
}
