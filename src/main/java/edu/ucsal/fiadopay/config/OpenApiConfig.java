package edu.ucsal.fiadopay.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@OpenAPIDefinition(
    info = @Info(title = "FiadoPay Simulator API", version = "v1"),
    security = { @SecurityRequirement(name = "bearerAuth") }
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "FAKE",
    in = SecuritySchemeIn.HEADER
)
@Configuration
public class OpenApiConfig {
	@Bean(name = "threadPool")
	public ExecutorService threadPool() {
		return Executors.newFixedThreadPool(10);
	}
}
