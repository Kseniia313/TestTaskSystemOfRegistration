package org.example.service;

import org.apache.catalina.connector.Request;
import org.example.dto.Direction;
import org.example.dto.RequestsDto;
import org.example.dto.StatusRequest;
import org.example.dto.UserDto;
import org.example.entity.Requests;
import org.example.entity.User;
import java.util.List;

public interface UserService {
    Requests createRequest(Requests requests, String email);

    List<Requests> getRequestsByCreationDate(Direction direction, int pageName, int pageSize);

    Requests updateRequestDraft(Integer id, Requests requests);

    void sendRequestToOperator(Requests requests);
}



