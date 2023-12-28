package com.HiringPlarform.HiringPlatform;

import com.HiringPlarform.HiringPlatform.model.MCQRepository;
import com.HiringPlarform.HiringPlatform.model.enums.Result;
import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@Slf4j
public class HiringPlatformApplication {

	public HiringPlatformApplication(MCQRepository mcqRepository) {
		this.mcqRepository = mcqRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HiringPlatformApplication.class, args);
	}

	private final MCQRepository mcqRepository;

	@PostMapping("/save")
	public Object save(@RequestBody MultipleChoiceQuestionResult choiceQuestionResult) {
		log.info(choiceQuestionResult.toString());
		choiceQuestionResult.setResult(Result.PASS);
        return mcqRepository.save(choiceQuestionResult);
	}

	@GetMapping("/get")
	public Object getAll() {
		return mcqRepository.findAll();
	}

}
