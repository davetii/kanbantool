package com.greatwideweb.kanbantool.repos;

import com.greatwideweb.kanbantool.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {

}