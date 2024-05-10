package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Direction;
import org.example.dto.UserDto;
import org.example.entity.Requests;
import org.example.mapper.RequestsMapper;
import org.example.repository.RequestsRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RequestsRepository requestsRepository;
    private final RequestsMapper requestsMapper;



    @Override
    public Requests createRequest(UserDto userDto, String text) {
        return null;
    }

    @Override
    public List<Requests> getRequestsByCreationDate(Direction direction, int pageName, int pageSize) {
        return null;
    }

    @Override
    public Requests updateRequestDraft(UserDto userDto, String text) {
        return null;
    }

    @Override
    public void sendRequestToOperator(Requests requests) {

    }
}
