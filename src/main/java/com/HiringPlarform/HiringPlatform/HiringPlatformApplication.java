package com.HiringPlarform.HiringPlatform;

import com.HiringPlarform.HiringPlatform.converters.RandomStringGenerator;
import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.UserDto;
import com.HiringPlarform.HiringPlatform.model.entity.enums.*;
import com.HiringPlarform.HiringPlatform.model.entity.tables.*;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Category;
import com.HiringPlarform.HiringPlatform.repository.*;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@RestController
@Slf4j
@EnableScheduling
public class HiringPlatformApplication {

    public HiringPlatformApplication(CodingQuestionRepository codingQuestionRepository, CasesRepository casesRepository, EmailTaskRepository emailTaskRepository, ContestRepository contestRepository, MCQQuestion mcqQuestion, UserRepository userRepository, RoundsAndQuestionRepository roundsAndQuestionRepository) {
        this.codingQuestionRepository = codingQuestionRepository;
        this.casesRepository = casesRepository;
        this.emailTaskRepository = emailTaskRepository;
        this.contestRepository = contestRepository;
        this.mcqQuestion = mcqQuestion;
        this.userRepository = userRepository;
        this.roundsAndQuestionRepository = roundsAndQuestionRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(HiringPlatformApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner (ContestRepository contestRepository,
												UserRepository userRepository,
												EmployeeRepository employeeRepository,
												EmployeeAvailabilityRepository employeeAvailabilityRepository,
												RoundsRepository roundsRepository,
												CategoryRepository categoryRepository,
												PartRepository partRepository,
												InterviewRepository interviewRepository,
												MCQQuestion mcqQuestionRepository,
												OptionsRepository optionsRepository,
												RoundsAndQuestionRepository roundsAndQuestionRepository,
												CodingQuestionRepository codingQuestionRepository,
												MCQResultRepository mcqResultRepository,
												RoundAndMcqQuestionRepository roundAndMcqQuestionRepository
	) {
		return args -> {
			String firstContestId = RandomStringGenerator.generateRandomString(7);
			String secondContestId = RandomStringGenerator.generateRandomString(7);

			var firstContest = Contest.builder()
					.name("FirstContest")
					.contestId(firstContestId)
					.contestStatus(ContestStatus.UPCOMING)
					.build();

			for(int i = 0; i < 4; i++) {
				var category = Category.builder()
						.build();
				if(i == 1) {
					category.setCategory(com.HiringPlarform.HiringPlatform.model.entity.enums.Category.APTITUDE_MCQ);
				} else if( i== 2) {
					category.setCategory(com.HiringPlarform.HiringPlatform.model.entity.enums.Category.LOGICAL_MCQ);
				} else if(i == 3) {
					category.setCategory(com.HiringPlarform.HiringPlatform.model.entity.enums.Category.VERBAL_MCQ);
				} else  {
					category.setCategory(com.HiringPlarform.HiringPlatform.model.entity.enums.Category.TECHNICAL_MCQ);
				}
				categoryRepository.save(category);
			}


			var secondContest = Contest.builder()
					.name("secondContest")
					.contestId(secondContestId)
					.contestStatus(ContestStatus.CURRENT)
					.build();

			contestRepository.save(firstContest);
			contestRepository.save(secondContest);

			var firstContestRound = Rounds.builder()
					.endTime(LocalDateTime.now())
					.roundType(RoundType.INTERVIEW)
					.contest(firstContest)
					.startTime(LocalDateTime.now())
					.roundNumber(2)
					.roundsId(RandomStringGenerator.generateRandomString(7))
					.build();

			var firstContestRoundMCQ = Rounds.builder()
					.endTime(LocalDateTime.now())
					.roundType(RoundType.MCQ)
					.startTime(LocalDateTime.now())
					.contest(firstContest)
					.roundNumber(1)
					.roundsId(RandomStringGenerator.generateRandomString(7))
					.build();

			List<Rounds> roundsList = new ArrayList<>();
			roundsList.add(firstContestRound);
			roundsList.add(firstContestRoundMCQ);



			Part codingPart = new Part();
			codingPart.setEasy(2);
			codingPart.setHard(3);
			codingPart.setMedium(4);

			List<Rounds> firstContestRounds = new ArrayList<>();

			var secondContestRound = Rounds.builder()
					.endTime(LocalDateTime.now())
					.roundType(RoundType.INTERVIEW)
					.contest(secondContest)
					.roundNumber(2)
					.startTime(LocalDateTime.now())
					.roundsId(RandomStringGenerator.generateRandomString(7))
					.build();

			var secondContestRoundMCQ = Rounds.builder()
					.roundNumber(1)
					.endTime(LocalDateTime.now())
					.roundType(RoundType.MCQ)
					.contest(secondContest)
					.startTime(LocalDateTime.now())
					.roundsId(RandomStringGenerator.generateRandomString(7))
					.build();

			roundsList.add(secondContestRound);
			roundsList.add(secondContestRoundMCQ);

			roundsRepository.save(firstContestRound);
			roundsRepository.save(firstContestRoundMCQ);
			roundsRepository.save(secondContestRound);
			roundsRepository.save(secondContestRoundMCQ);

			List<Category> categoryList = categoryRepository.findAll();

			for(Rounds rounds : roundsList) {
				createEmailTask(rounds);
			}

			for(Category category : categoryList) {
				codingPart.setPartId(RandomStringGenerator.generateRandomString(10));
				codingPart.setCategory(category);
				codingPart.setRounds(firstContestRoundMCQ);
				partRepository.save(codingPart);
			}

			for(Category category : categoryList) {
				codingPart.setPartId(RandomStringGenerator.generateRandomString(10));
				codingPart.setCategory(category);
				codingPart.setRounds(secondContestRoundMCQ);
				partRepository.save(codingPart);
			}

			/* CONTEST CREATED AND INSERTED INTO THE TABLE WITH THE INTERVIEW ROUND */

			List<Contest> firstContestList = new ArrayList<>();
			firstContestList.add(firstContest);

			List<Contest> secondContestList = new ArrayList<>();
			secondContestList.add(secondContest);

			List<User> firstContestUserList = new ArrayList<>();
			List<User> secondContestUserList = new ArrayList<>();

			Faker faker = new Faker();
			for(int i = 0; i < 20; i++) {
				var user = User.builder()
						.userId(RandomStringGenerator.generateRandomString(10))
						.collegeName(faker.university().name())
						.role(Role.CONTESTANTS)
						.email(faker.internet().emailAddress())
						.password(RandomStringGenerator.generateRandomString(10))
						.name(faker.name().fullName())
						.build();
				userRepository.save(user);
				if(i%2 == 0) {
					user.setContest(firstContestList);
					firstContestUserList.add(user);
				} else {
					user.setContest(secondContestList);
					secondContestUserList.add(user);
				}
			}

			for(User user : firstContestUserList) {
				User user1 = userRepository.findUserByUserId(user.getUserId());
				user1.setContest(firstContestList);
				userRepository.save(user);
			}

			for(User user : secondContestUserList) {
				User user1 = userRepository.findUserByUserId(user.getUserId());
				user1.setContest(secondContestList);
				userRepository.save(user);
			}

			/* USER ASSIGNED TO THE CONTEST */


			for(int i = 0; i < 10; i++) {
				var employee = Employee.builder()
						.employeeId(RandomStringGenerator.generateRandomLong(10))
						.firstName(faker.name().firstName())
						.email(faker.internet().emailAddress())
						.lastName(faker.name().lastName())
						.password(RandomStringGenerator.generateRandomString(10))
						.role(Role.EMPLOYEE)
						.build();
				if(i%2 == 0) {
					employee.setEmployeeType(EmployeeType.PERSONAL_HR);
				} else  {
					employee.setEmployeeType(EmployeeType.TECHNICAL_HR);
				}

				employeeRepository.save(employee);
			}

			List<Employee> employeeList = employeeRepository.findAll();

			int count = 0;

			firstContestList.add(secondContest);
			for(Employee employee : employeeList) {

				var employeeAndContest = EmployeeAndContest.builder()
						.contest(firstContest)
						.employee(employee)
						.build();

				var employeeAvailability = EmployeeAvailability.builder()
						.employeeAndContest(employeeAndContest)
						.build();
				if(count % 2 == 0) {
					employeeAvailability.setResponse(EmployeeResponse.AVAILABLE);
					employee.setContest(firstContestList);
				} else  {
					employeeAvailability.setResponse(EmployeeResponse.NOT_AVAILABLE);
					employee.setContest(secondContestList);
				}
				count++;
				employeeRepository.save(employee);
				employeeAvailabilityRepository.save(employeeAvailability);
			}

			for(Employee employee : employeeList) {
				var employeeAvailability = EmployeeAvailability.builder()
						.employeeAndContest(new EmployeeAndContest(employee, firstContest))
						.build();
				if(count % 2 == 0) {
					employeeAvailability.setResponse(EmployeeResponse.AVAILABLE);
					employee.setContest(secondContestList);
				} else  {
					employeeAvailability.setResponse(EmployeeResponse.NOT_AVAILABLE);
					employee.setContest(firstContestList);
				}
				count++;
				employeeRepository.save(employee);
				employeeAvailabilityRepository.save(employeeAvailability);
			}

			List<EmployeeAvailability> employeeAvailabilities = employeeAvailabilityRepository.findByResponse(EmployeeResponse.AVAILABLE);


			List<User> firstRoundPassedStudents = userRepository.findUsersByContest(firstContest);
			List<Interview> interview = distributeStudents(firstRoundPassedStudents, employeeAvailabilities, firstContestRound);
			interviewRepository.saveAll(interview);
			addMcqQuestion(mcqQuestionRepository, categoryRepository, optionsRepository, firstContestRoundMCQ);
			addCodingQuestion();
			List<MultipleChoiceQuestion> randomQuestions = new ArrayList<>();
			List<Part> parts = partRepository.findAllByRounds_RoundsId(firstContestRoundMCQ.getRoundsId());
			for(Part part : parts) {
				if(part.getCategory().getCategoryId() == 1) continue;
				int easy = part.getEasy();
				int medium = part.getMedium();
				int hard = part.getHard();
				Category category = part.getCategory();
				List<MultipleChoiceQuestion> randomEasyQuestion = mcqQuestionRepository.getRandomQuestion(category.getCategoryId(), Difficulty.EASY, easy);
				List<MultipleChoiceQuestion> randomMediumQuestion = mcqQuestionRepository.getRandomQuestion(category.getCategoryId(), Difficulty.MEDIUM, medium);
				List<MultipleChoiceQuestion> randomHardQuestion = mcqQuestionRepository.getRandomQuestion(category.getCategoryId(), Difficulty.HARD, hard);
				randomQuestions.addAll(randomEasyQuestion);
				randomQuestions.addAll(randomMediumQuestion);
				randomQuestions.addAll(randomHardQuestion);
			}


			for(MultipleChoiceQuestion question : randomQuestions) {
				ContestAndMcq contestAndMcq = new ContestAndMcq();
				contestAndMcq.setContest(firstContest);
				contestAndMcq.setMultipleChoiceQuestion(question);
				var roundAndQuestion = RoundAndMcqQuestion.builder()
						.contestAndMcq(contestAndMcq)
						.rounds(firstContestRound)
						.build();
				roundsAndQuestionRepository.save(roundAndQuestion);
			}

			List<MultipleChoiceQuestion> multipleChoiceQuestions = roundAndMcqQuestionRepository.findByRoundId(firstContestRoundMCQ.getRoundsId());
			List<User> roundUsers = userRepository.findUsersByContest(firstContest);

			for(User user : roundUsers) {
				List<MCQResult> mcqResults = new ArrayList<>();
				var response = MCQResult.builder()
						.contestId(firstContestId)
						.roundId(firstContestRound.getRoundsId())
						.mcqResultId(RandomStringGenerator.generateRandomString(10))
						.build();
				List<PartWiseResponse> savedMcqs = new ArrayList<>();
				for(MultipleChoiceQuestion multipleChoiceQuestion : multipleChoiceQuestions) {
					PartWiseResponse savedMcq = new PartWiseResponse();
//					savedMcq.setQuestionId(multipleChoiceQuestion.getQuestion_id());
					List<UserResponse> userResponses = new ArrayList<>();
					List<Options> options = multipleChoiceQuestion.getOptions();
					String answer = options.get(3).getOption();
					UserResponse userResponse = new UserResponse();
					userResponse.setChosenAnswer(answer);
					userResponses.add(userResponse);
					savedMcq.setUserResponse(userResponses);
					savedMcqs.add(savedMcq);
				}
			}

		};

	}

	private final CodingQuestionRepository codingQuestionRepository;
	private final CasesRepository casesRepository;

	private void addCodingQuestion() {
		Faker faker = new Faker();
		CodingQuestion codingQuestion = new CodingQuestion();
		codingQuestion.setQuestion("Given a string, the task is to reverse the order of the words in the given string. \n" +
				"\n");
		codingQuestion.setDifficulty(Difficulty.EASY);
		codingQuestion.setCategory(com.HiringPlarform.HiringPlatform.model.entity.enums.Category.STRINGS_CODING);
		codingQuestion.setQuestionId(RandomStringGenerator.generateRandomLong(7));
		codingQuestionRepository.save(codingQuestion);
		Cases cases1 = new Cases();
		cases1.setCodingQuestion(codingQuestion);
		cases1.setCasesType(CasesType.TEST);
		cases1.setCaseId(RandomStringGenerator.generateRandomLong(7));
		cases1.setInput("geeks quiz practice code");
		cases1.setOutput("code practice quiz geeks");
		casesRepository.save(cases1);
		Cases cases2 = new Cases();
		cases2.setCodingQuestion(codingQuestion);
		cases2.setCasesType(CasesType.SAMPLE);
		cases2.setCaseId(RandomStringGenerator.generateRandomLong(7));
		cases2.setInput("geeks quiz practice code");
		cases2.setOutput("code practice quiz geeks");
		casesRepository.save(cases2);
	}
	public void createEmailTask(Rounds round) {
		LocalDateTime taskTime;
		if (round.getRoundNumber() == 1) {
			taskTime = round.getStartTime().minusHours(1);
			saveEmailTask(buildEmailTask(round, taskTime));
			taskTime = round.getEndTime().plusMinutes(30);
		} else {
			taskTime = round.getEndTime().plusMinutes(6);
		}
		saveEmailTask(buildEmailTask(round, taskTime));
	}

	private static EmailTask buildEmailTask(Rounds round, LocalDateTime taskTime) {
		return EmailTask.builder()
				.rounds(round)
				.taskStatus(TaskStatus.PENDING)
				.taskTime(taskTime)
				.build();
	}


	private final EmailTaskRepository emailTaskRepository;

	private void saveEmailTask(EmailTask emailTask) {
		emailTaskRepository.save(emailTask);
	}


	private EmailTask createTask(Rounds rounds) {
		EmailTask emailTask = new EmailTask();
		emailTask.setTaskStatus(TaskStatus.PENDING);
		emailTask.setRounds(rounds);
		emailTask.setId(RandomStringGenerator.generateRandomLong(10));
		return emailTask;
	}

	private List<Interview> distributeStudents(List<User> users, List<EmployeeAvailability> employeeAvailabilities, Rounds rounds) {

		int totalStudents = users.size();
		int totalEmployees = employeeAvailabilities.size();
		Faker faker = new Faker();

		int studentsPerEmployee = totalStudents / totalEmployees;
		int remainingUsers = totalStudents % totalEmployees;
		int studentIndex = 0;

		List<Interview> interviews = new ArrayList<>();

		for(EmployeeAvailability employeeAvailability : employeeAvailabilities) {
			Employee employee = employeeAvailability.getEmployeeAndContest().getEmployee();
			for(int i = 0; i < studentsPerEmployee; i++) {
				var interview = Interview.builder()
						.interviewId(RandomStringGenerator.generateRandomString(10))
						.feedBack(faker.gameOfThrones().quote())
						.interviewTime(LocalDateTime.now())
						.user(users.get(studentIndex))
						.interviewType(InterviewType.PERSONAL)
						.employee(employee)
						.rounds(rounds)
						.build();
				studentIndex++;
				interviews.add(interview);
			}

			if(remainingUsers > 0) {
				var interview = Interview.builder()
						.interviewId(RandomStringGenerator.generateRandomString(10))
						.feedBack(faker.harryPotter().quote())
						.interviewTime(LocalDateTime.now())
						.user(users.get(studentIndex))
						.interviewType(InterviewType.PERSONAL)
						.employee(employee)
						.rounds(rounds)
						.build();

				studentIndex++;
				remainingUsers--;

				interviews.add(interview);
			}
		}
		return interviews;

	}

	private void addMcqQuestion(MCQQuestion mcqQuestionRepository, CategoryRepository categoryRepository, OptionsRepository optionsRepository, Rounds firstContestRoundMCQ) {
		List<Category> categoryList = categoryRepository.findAll();
		Faker faker = new Faker();
		Random random = new Random();
		String choice = "123";

		for(int i = 0; i < 100; i++) {
			var question = MultipleChoiceQuestion.builder()
					.question_id(RandomStringGenerator.generateRandomString(8))
					.question(faker.harryPotter().quote())
					.build();
			int num = random.nextInt(choice.length());
			char diff = choice.charAt(num);
			int pos = random.nextInt(choice.length());
			char diffLev = choice.charAt(pos);
			switch (diff) {
				case '1' :
					Category category = categoryList.get(1);
					question.setCategory(category);
					break;
				case '2':
					Category category1 = categoryList.get(2);
					question.setCategory(category1);
					break;
				case '3':
					Category category2 = categoryList.get(3);
					question.setCategory(category2);
					break;
			}
			switch (diffLev) {
				case '1' :
					question.setDifficulty(Difficulty.EASY);
					break;
				case '2' :
					question.setDifficulty(Difficulty.MEDIUM);
					break;
				case '3' :
					question.setDifficulty(Difficulty.HARD);
					break;
			}
			mcqQuestionRepository.save(question);
			for(int j = 0; j < 4; j++) {
				var options = Options.builder()
						.id(RandomStringGenerator.generateRandomLong(7))
						.option(faker.harryPotter().character())
						.build();
				options.setMultipleChoiceQuestion(question);
				switch (j) {
					case 1, 2, 3:
						options.setCorrect(false);
						break;
                    case 0:
						options.setCorrect(true);
						break;
				}
				optionsRepository.save(options);
			}
		}

	}

	private final ContestRepository contestRepository;
	private final MCQQuestion mcqQuestion;
	private final UserRepository userRepository;
	private final RoundsAndQuestionRepository roundsAndQuestionRepository;

	@GetMapping("/")
	public List<ContestDto> getContest() {
		List<Contest> contestList = contestRepository.findAll();
		List<ContestDto> contestDtos = new ArrayList<>();

		for(Contest contest : contestList) {
			ContestDto contestDto = new ContestDto();
			contestDto.setId(contest.getContestId());
			contestDto.setName(contest.getName());
			contestDtos.add(contestDto);

}
		return contestDtos;
//		return contestRepository.findAll();
	}

	@GetMapping("/{contestId}")
	public Contest getContest(@PathVariable String contestId) {
		return contestRepository.findContestByContestId(contestId);
	}

	@GetMapping("/question")
	public List<MultipleChoiceQuestion> get() {
		return mcqQuestion.findAll();
	}


	@GetMapping("/user")
	public List<UserDto> users() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<>();
		for(User user : users) {
			var contestant = UserDto.builder()
					.userId(user.getUserId())
					.name(user.getName())
					.collageName(user.getCollegeName())
					.build();

			if(user.getResume() != null) {
				contestant.setDepartment(user.getResume().getDepartment());
				contestant.setResumeUrl(user.getResume().getResumeUrl());
			}

			List<String> contestId = new ArrayList<>();

			for(Contest contest : user.getContest()) {
				contestId.add(contest.getContestId());
			}
			contestant.setContestId(contestId);
			userDtos.add(contestant);
		}

		return userDtos;
	}

	@GetMapping("/rounds/{id}")
	public List<MultipleChoiceQuestion> getQuestions(@PathVariable String id) {
		return roundsAndQuestionRepository.getRandomQuestions(id);
	}

	@GetMapping("/user/{userId}")
	public User user(@PathVariable String userId) {
		return userRepository.findUserByUserId(userId);
	}

	@GetMapping("/coding/questions")
	public ResponseEntity<?> codingQuestions() {
		List<CodingQuestion> codingQuestions = codingQuestionRepository.findAll();
		return ResponseEntity.ok(codingQuestions);
	}

	@Scheduled(fixedRate = 1000)
	public void scheduler() throws InterruptedException {
		List<EmailTask> emailTasks = emailTaskRepository.findEmailTasksByTaskTimeAfterAndTaskTimeBefore(LocalDateTime.now(), LocalDateTime.now().plusMinutes(5));
		log.info(LocalDateTime.now().toString());
		Thread.sleep(5000);
		int count = 0;
		for(EmailTask emailTask : emailTasks) {
			if(emailTask != null) {
				if(emailTask.getTaskStatus() == TaskStatus.PENDING) {
					log.info(emailTask.getRounds().getRoundsId());
				} else if(emailTask.getTaskStatus() == TaskStatus.RETRY) {
					log.info("An Error occurred while sending email for this round " + emailTask.getRounds().getRoundsId());
					emailTask.setTaskStatus(TaskStatus.FAILED);
					emailTaskRepository.save(emailTask);
				} else if (emailTask.getTaskStatus() == TaskStatus.FAILED) {
					log.info("Email task failed for this round " + emailTask.getRounds().getRoundsId());
				}
				if (count == 0) {
					emailTask.setTaskStatus(TaskStatus.SUCCESS);
					emailTaskRepository.save(emailTask);
					count++;
				} else {
					emailTask.setTaskStatus(TaskStatus.RETRY);
					emailTaskRepository.save(emailTask);
				}
			}
		}
	}
}
