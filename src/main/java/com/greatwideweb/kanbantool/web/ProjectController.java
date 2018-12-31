package com.greatwideweb.kanbantool.web;

import com.greatwideweb.kanbantool.domain.Project;
import com.greatwideweb.kanbantool.services.ProjectService;
import com.greatwideweb.kanbantool.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project p, BindingResult result) {
        ResponseEntity<?> errorMap = validationService.validate(result);
        if (errorMap != null) { return errorMap; }
        Project project = projectService.saveForUpdateProject(p);
        return new ResponseEntity(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findProjectByIdentifier(projectId.toUpperCase());
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

}
