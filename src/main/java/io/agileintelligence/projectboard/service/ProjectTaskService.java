package io.agileintelligence.projectboard.service;

import io.agileintelligence.projectboard.domain.ProjectTask;
import io.agileintelligence.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository taskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {

        if (projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }

        return taskRepository.save(projectTask);

    }

    public Iterable<ProjectTask> findAll(){
        return taskRepository.findAll();
    }

    public ProjectTask findById(Long id){
        return taskRepository.getById(id);
    }
}
