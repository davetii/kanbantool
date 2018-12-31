package com.greatwideweb.kanbantool.services;

import com.greatwideweb.kanbantool.domain.Project;
import com.greatwideweb.kanbantool.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project saveForUpdateProject(Project p) {
        return projectRepo.save(p);
    }
}
