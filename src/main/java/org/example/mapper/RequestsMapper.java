package org.example.mapper;

import org.example.dto.RequestsDto;
import org.example.entity.Requests;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestsMapper {
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "id", target = "pk")
    RequestsDto requestToRequestDto(Requests requests);

    Requests toRequests(RequestsDto requestsDto);

}
