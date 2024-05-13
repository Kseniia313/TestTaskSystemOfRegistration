package org.example.service.impl;

import org.example.dto.Direction;
import org.example.entity.Requests;
import org.example.entity.User;
import org.example.service.OperatorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperatorServiceImpl implements OperatorService {
    @Override
    public List<Requests> getAllRequestsSortedByCreationDate(Direction direction, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<Requests> getUserRequestsSortedByCreationDate(User user, Direction direction, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void acceptRequest(Requests request) {

    }

    @Override
    public void rejectRequest(Requests request) {

    }
}
