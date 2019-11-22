package com.github.rkruk.findmenow.repositories;

import com.github.rkruk.findmenow.models.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {

}
