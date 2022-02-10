package {{project_group_id}}.controller

import {{project_group_id}}.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getUsers() = userService.getUsers()
}
