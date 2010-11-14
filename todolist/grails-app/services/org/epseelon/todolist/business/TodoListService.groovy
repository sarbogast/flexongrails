package org.epseelon.todolist.business

import org.epseelon.todolist.dto.TaskListItem
import org.epseelon.todolist.domain.Task
import org.springframework.flex.remoting.RemotingInclude
import org.springframework.flex.remoting.RemotingDestination
import org.epseelon.todolist.dto.TaskDetail
import org.springframework.security.access.annotation.Secured

@RemotingDestination
class TodoListService {

    static transactional = true

    @RemotingInclude
    List<TaskListItem> getAllTasks() {
        return Task.findAll().collectAll {
            new TaskListItem(
                    id: it.id,
                    title: it.title
            )
        }
    }

    @RemotingInclude
    @Secured(["ROLE_ADMIN"])
    TaskDetail createNewTask(TaskDetail newTask){
        Task task = new Task(title:newTask.title)
        if(task.validate()){
            task.save()
            return new TaskDetail(
                    id: task.id,
                    title: task.title
            )
        } else {
            throw new Exception(task.errors.allErrors.defaultMessage.join("\n"))
        }
    }
}
