package com.example.demo.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicosRepository extends CrudRepository<Topico, Long>{

}
