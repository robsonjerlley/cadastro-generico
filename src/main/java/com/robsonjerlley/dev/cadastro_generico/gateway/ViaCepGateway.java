package com.robsonjerlley.dev.cadastro_generico.gateway;

import com.robsonjerlley.dev.cadastro_generico.gateway.dto.ViaCepGatewayResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ViaCepGateway {
    private final WebClient webClient;

    public ViaCepGateway(
            WebClient.Builder webClientBuilder,
            @Value("${app.clients.viacep.base-url}") String baseUrl) {

        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public Mono<ViaCepGatewayResponse> findByCep(String cep) {
        return this.webClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(ViaCepGatewayResponse.class);

    }


}
