package com.greatwideweb.kanbantool.web;

import com.greatwideweb.kanbantool.domain.Project;
import com.greatwideweb.kanbantool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project p, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap();
            for (FieldError e : result.getFieldErrors()) {
                errorMap.put(e.getField(), e.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.saveForUpdateProject(p);
        return new ResponseEntity(project, HttpStatus.CREATED);
    }

}
