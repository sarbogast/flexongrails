package org.epseelon.todolist.domain

class Task {
    String title

    static constraints = {
        title blank:false
    }
}
