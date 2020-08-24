package dev.gerardo;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Readiness
public class Health implements HealthCheck {

    @Inject
    @ConfigProperty(name = "version")
    String version;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("Mi app")
                .withData("version", version)
                .up()
                .build();
    }
}
