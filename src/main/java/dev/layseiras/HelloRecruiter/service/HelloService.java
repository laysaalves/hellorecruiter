package dev.layseiras.HelloRecruiter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.layseiras.HelloRecruiter.config.GeminiConfig;
import dev.layseiras.HelloRecruiter.model.Hello;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HelloService {

    private final String API_KEY;
    private final String API_URL;

    private final WebClient webClient;

    public HelloService(GeminiConfig gemini) {
        this.API_KEY = gemini.getApiKey();
        this.API_URL = gemini.getApiUrl() + API_KEY;

        this.webClient = WebClient.builder()
                .baseUrl(API_URL)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    private String generatePrompt(Hello hello) {
        return """
        {
          "contents": [
            {
              "role": "user",
              "parts": [
                {
                  "text": "Gere um corpo de email objetivo em 4 linhas, sem assunto e sem emojis, com uma abordagem carismática e proativa. Enviarei para a avaliação do meu curriculo para vaga de %s %s %s na empresa %s, sou %s e tenho %d anos de experiência."
                }
              ]
            }
          ],
          "generationConfig": {
            "maxOutputTokens": 90
          }
        }
        """.formatted(hello.getNivel(), hello.getVaga(), hello.getFerramenta(), hello.getEmpresa(), hello.getUsuario(), hello.getExperiencia());
    }

    public Mono<String> getEmailBody(Hello hello) {
        String requestBody = generatePrompt(hello);

        return webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(response);
                        JsonNode candidates = jsonNode.path("candidates");

                        if (candidates.isArray() && candidates.size() > 0) {
                            JsonNode content = candidates.get(0).path("content");
                            if (content.has("parts")) {
                                return content.get("parts").get(0).path("text").asText();
                            }
                        }
                        return "Não foi possível gerar um corpo de email.";

                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Erro ao processar a resposta da API: " + e.getMessage();
                    }
                });
    }
}
