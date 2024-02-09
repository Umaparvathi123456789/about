package com.uma.linkdlen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uma.linkdlen.model.About;

@Repository
public interface AboutRepository  extends JpaRepository<About, Long> {

}
