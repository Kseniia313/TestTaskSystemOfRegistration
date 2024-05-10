package org.example.service;

import org.example.dto.Direction;
import org.example.entity.Requests;
import org.example.entity.User;

import java.util.List;

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
