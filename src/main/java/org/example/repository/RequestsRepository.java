package org.example.repository;

import org.example.entity.Requests;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Integer> {
    List<Requests> findAllByUser(User user);

    @Override
    Optional<Requests> findById(Integer integer);
}
