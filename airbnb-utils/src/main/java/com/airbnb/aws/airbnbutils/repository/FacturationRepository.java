package com.airbnb.aws.airbnbutils.repository;


import com.airbnb.aws.airbnbutils.model.Facturation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturationRepository extends CrudRepository<Facturation, Integer> {

}
