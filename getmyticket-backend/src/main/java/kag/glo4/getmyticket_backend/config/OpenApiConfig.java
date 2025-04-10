package kag.glo4.getmyticket_backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "getMyTicket",
                        email = "ismaeltegou7@gmail.com",
                        url = "/"
                ),
                description = "OpenAPI documentation for getMyTicket",
                title = "OpenAPI Specification - getMyTicket",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
