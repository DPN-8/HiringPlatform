package com.HiringPlarform.HiringPlatform.repository;


import com.HiringPlarform.HiringPlatform.model.entity.tables.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Long> {
}
