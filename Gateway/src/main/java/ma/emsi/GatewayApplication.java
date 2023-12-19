package ma.emsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;

@SpringBootApplication
public class GatewayApplication {
	// Configuration statique
	/*
	 * @Bean RouteLocator routes(RouteLocatorBuilder builder) { return
	 * builder.routes().route(r ->
	 * r.path("/clients/**").uri("lb://SERVICE-CLIENT")).build(); }
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator routesDynamique(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);

	}

}
