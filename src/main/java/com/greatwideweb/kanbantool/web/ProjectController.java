package com.greatwideweb.kanbantool.web;

import com.greatwideweb.kanbantool.domain.Project;
import com.greatwideweb.kanbantool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project p, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.saveForUpdateProject(p);
        return new ResponseEntity(project, HttpStatus.CREATED);
    }

}
