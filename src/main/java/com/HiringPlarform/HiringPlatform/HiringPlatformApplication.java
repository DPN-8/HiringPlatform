package com.HiringPlarform.HiringPlatform;

import com.HiringPlarform.HiringPlatform.converters.RandomStringGenerator;
import com.HiringPlarform.HiringPlatform.model.entity.tables.MCQResult;
import com.HiringPlarform.HiringPlatform.repository.MCQResultRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
public class HiringPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringPlatformApplication.class, args);
	}

}
