package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Direction;
import org.example.dto.RequestsDto;
import org.example.entity.Requests;
import org.example.mapper.RequestsMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/requests")

public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Operation(summary = "Создание запроса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Запрос создан",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Requests.class))),
            @ApiResponse(responseCode = "401", description = "Не авторизован")})

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Requests> createRequest(@Valid @RequestPart(name = "properties") Requests requests,
                                                     @RequestPart(name = "user", required = false)Authentication authentication) {
        try {
            log.info("Добавление запроса");
            return ResponseEntity.ok( userService.createRequest(requests, authentication.getName()));
        } catch (Exception e){
            log.error("Ошибка при добавлении  запроса", e);
            throw new RuntimeException("Ошибка при добавлении запроса", e);
        }
    }
    @GetMapping("/getRequests")
    public List<Requests> getRequestsByCreationDate(@RequestParam Direction direction,
                                                    @RequestParam int pageName,
                                                    @RequestParam int pageSize) {
        return userService.getRequestsByCreationDate(direction, pageName, pageSize);
    }
    @PutMapping("/update/{id}")
    public Requests updateRequestDraft(@PathVariable Integer id, @RequestBody Requests requests) {
        return userService.updateRequestDraft(id, requests);
    }

    @PutMapping("/send/{id}")
    public void sendRequestToOperator(@PathVariable Integer id) {
        Requests request = new Requests();
        request.setId(id);
        userService.sendRequestToOperator(request);
    }

}
