package org.example.service;

import org.example.dto.Direction;
import org.example.entity.Requests;
import org.example.entity.User;

import java.util.List;

public interface OperatorService {
    List<Requests> getAllRequestsSortedByCreationDate(Direction direction, int pageNum, int pageSize);
    List<Requests> getUserRequestsSortedByCreationDate(User user, Direction direction, int pageNum, int pageSize);
    void acceptRequest(Requests request);
    void rejectRequest(Requests request);
}

