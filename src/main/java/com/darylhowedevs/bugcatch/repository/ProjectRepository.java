package com.darylhowedevs.bugcatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.darylhowedevs.bugcatch.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

}

