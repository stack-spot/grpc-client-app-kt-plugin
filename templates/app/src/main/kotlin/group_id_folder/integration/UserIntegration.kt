package {{project_group_id}}.integration

import com.google.protobuf.Empty
import {{project_group_id}}.GetUserResponse
import {{project_group_id}}.UserEndpointGrpc
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UserIntegration(
    @Value("\${user.integration.host}") private val userIntegrationHost: String,
    @Value("\${user.integration.port}") private val userIntegrationPort: Int
) {

    private val channel = ManagedChannelBuilder.forAddress(userIntegrationHost, userIntegrationPort).usePlaintext().build()
    private val userClient = UserEndpointGrpc.newBlockingStub(channel)

    fun getUsers(): GetUserResponse = userClient.getUsers(Empty.getDefaultInstance())
}
