import org.epseelon.todolist.domain.Role
import org.epseelon.todolist.domain.Task
import org.epseelon.todolist.domain.User
import org.epseelon.todolist.domain.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        def admin = new User(username: "admin", password: springSecurityService.encodePassword("admin"), enabled: true).save()
        def user = new User(username: "user", password: springSecurityService.encodePassword("user"), enabled: true).save()

        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def userRole = new Role(authority: "ROLE_USER").save()

        new UserRole(user: user, role: userRole).save()
        new UserRole(user: admin, role: adminRole).save()

        new Task(title: "Task 1").save()
        new Task(title: "Task 2").save()
        new Task(title: "Task 3").save()
    }

    def destroy = {
    }
}
