package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Direction;
import org.example.dto.RequestsDto;
import org.example.dto.StatusRequest;
import org.example.dto.UserDto;
import org.example.entity.Requests;
import org.example.mapper.RequestsMapper;
import org.example.repository.RequestsRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RequestsRepository requestsRepository;
    private final RequestsMapper requestsMapper;


    @Override
    public Requests createRequest(Requests requests, String email) {
        log.info("запустился метод создания запроса");
        Requests saveRequest = new Requests();
        saveRequest.setUser(userRepository.findUserByEmail(email).orElseThrow());
        saveRequest.setStatusRequest(StatusRequest.DRAFT);

        return saveRequest;
    }

    @Override
    public List<Requests> getRequestsByCreationDate(Direction direction, int pageName, int pageSize) {
        Sort sort = Sort.by(String.valueOf(direction), "creationTime");
        Pageable pageable = PageRequest.of(pageName, pageSize, sort);
        Page<Requests> requestsPage = requestsRepository.findAll(pageable);
        return requestsPage.getContent();
    }

    @Override
    public Requests updateRequestDraft(Integer id, Requests requests) {
        Optional<Requests> optionalRequests = requestsRepository.findById(id);
        return optionalRequests.map(request -> {
            if (request.getStatusRequest().equals(StatusRequest.DRAFT)) {
                return requestsRepository.save(request);
            } else {
                throw new RuntimeException("Невозможно отредактировать заявку, так как она не в статусе 'черновик'");
            }
        }).orElseThrow(() -> new RuntimeException("Заявка с идентификатором " + id + " не найдена"));
    }

    @Override
    public void sendRequestToOperator(Requests request) {
        if (request.getStatusRequest() == StatusRequest.DRAFT) {
            request.setStatusRequest(StatusRequest.SENT);
        } else {
            throw new RuntimeException("Нельзя отправить запрос, который уже был отправлен или находится в другом статусе.");
        }
    }
}

