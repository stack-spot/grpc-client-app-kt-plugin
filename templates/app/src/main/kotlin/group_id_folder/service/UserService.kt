package {{project_group_id}}.service

import {{project_group_id}}.integration.UserIntegration
import {{project_group_id}}.response.UserResponse
import org.springframework.stereotype.Service

@Service
class UserService(private val userIntegration: UserIntegration) {

    fun getUsers() = userIntegration.getUsers().userResponseListList.map { UserResponse(it.name, it.dataType) }
}
