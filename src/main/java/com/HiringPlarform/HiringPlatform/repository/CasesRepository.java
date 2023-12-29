package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.Cases;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface CasesRepository extends JpaRepository<Cases, Long> {

}
