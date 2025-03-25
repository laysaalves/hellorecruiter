package dev.layseiras.HelloRecruiter.controller;

import dev.layseiras.HelloRecruiter.model.Hello;
import dev.layseiras.HelloRecruiter.model.tracker.Card;
import dev.layseiras.HelloRecruiter.model.tracker.CardStatus;
import dev.layseiras.HelloRecruiter.repository.CardRepository;
import dev.layseiras.HelloRecruiter.repository.UserRepository;
import dev.layseiras.HelloRecruiter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {

    private final HelloService helloService;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Autowired
    public HelloController(HelloService helloService, CardRepository cardRepository, UserRepository userRepository) {
        this.helloService = helloService;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/generate")
    public Mono<String> generateEmail(@RequestBody Hello hello /*, HttpServletRequest request*/) {
        return helloService.getEmailBody(hello).publishOn(Schedulers.boundedElastic()).doOnTerminate(() -> {
            /*
            // Obtém o email do usuário a partir do contexto da requisição
            String userEmail = (String) request.getAttribute("email");

            // Verifica se o email foi extraído corretamente
            if (userEmail == null) {
                return Mono.error(new RuntimeException("Usuário não autenticado"));
            }

            // Recupera o usuário a partir do banco de dados
            User user = userRepository.findByEmail(userEmail); */

            // caso o usuario esteja logado é criado um card
            Card card = new Card();
            card.setVaga(hello.getVaga());
            card.setNivel(hello.getNivel());
            card.setEmpresa(hello.getEmpresa());
            card.setStatus(CardStatus.ENVIADO);  // default
            card.setCreatedAt(LocalDateTime.now());
            // card.setUser(user); // associa o card ao usuario

            // TODO: a mensagem gerada precisa aparecer no Card sem ser salva no DB
            cardRepository.save(card);
        });
    }

    // traz todos os cards do usuario
    @GetMapping("/tracker")
    public List<Card> getTrackerCards(/*HttpServletRequest request*/) {
        /*
        // Obtém o email do usuário autenticado do contexto da requisição
        String userEmail = (String) request.getAttribute("email");

        if (userEmail == null) {
            throw new RuntimeException("Usuário não autenticado");
        }

        // Recupera o usuário com base no email
        User user = userRepository.findByEmail(userEmail);

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Retorna todos os cards do usuário
        return cardRepository.findByUser(user);
        */
        return cardRepository.findAll();
    }

    // TODO: add metodo de atualizar o status dos cards
}
