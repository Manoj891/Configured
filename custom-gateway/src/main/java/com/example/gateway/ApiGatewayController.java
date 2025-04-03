package com.example.gateway;

import com.example.gateway.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class ApiGatewayController {

    private final WebClient webClient;

    @RequestMapping("/planning/web/**")
    public ResponseEntity<Object> forwardPlanningWeb(HttpServletRequest request, @RequestBody(required = false) String body) {
        return ResponseEntity.status(HttpStatus.OK).body(webClient.method(HttpMethod.valueOf(request.getMethod()))
                .uri("http://localhost:8085/" + request.getRequestURI() + determineServiceUrl(request))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body == null ? "" : body)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new CustomException(clientResponse.statusCode().value(), errorBody)))
                )
                .bodyToMono(Object.class)
                .block());
    }

    @RequestMapping("/planning/api/**")
    public ResponseEntity<Object> forwardPlanningApi(HttpServletRequest request, @RequestBody(required = false) String body) {
        String authorization = request.getHeader("Authorization");
        return ResponseEntity.status(HttpStatus.OK).body(webClient.method(HttpMethod.valueOf(request.getMethod()))
                .uri("http://localhost:8085/" + request.getRequestURI() + determineServiceUrl(request))
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body == null ? "" : body)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new CustomException(clientResponse.statusCode().value(), errorBody)))
                )
                .bodyToMono(Object.class)
                .block());
    }

    private String determineServiceUrl(HttpServletRequest request) {
        return request.getQueryString() != null ? "?" + request.getQueryString() : "";
    }
}
