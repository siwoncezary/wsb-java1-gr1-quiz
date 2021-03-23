package pl.wsb.quiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.entity.User;
import pl.wsb.quiz.repository.QuizRepository;
import pl.wsb.quiz.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class QuizApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QuizApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	CommandLineRunner initBaseData(QuizRepository quizRepository, UserRepository userRepository){
		//Klasa lokalna
//		class Run implements CommandLineRunner{
//			@Override
//			public void run(String... args) throws Exception {
//				quizRepository.save(new Quiz(0,"Operator new służy do?","Tworzenia obiektów\nTworzenia klas\nWstawiania nowej linii","Tworzenia obiektów", "JAVA"));
//				quizRepository.save(new Quiz(0,"Wskaż deklarację zmiennej całkowitej","boolean a = true;\nint a = 10;\ndouble a = 3;","int a = 10;", "JAVA"));
//				quizRepository.save(new Quiz(0,"Klauzula HAVING występuje razem z?","WHERE\nORDER BY\nGROUP BY","GROUP BY", "BAZY"));
//				quizRepository.save(new Quiz(0,"Jaka jest wartość wyrażenia TRUE OR NULL?","TRUE\nNULL\nFALSE","TRUE", "BAZY"));
//				userRepository.save(new User(0, "adam@op.pl"));
//				userRepository.save(new User(0, "ewa@wsb.edu.pl"));
//			}
//		}
//		return new Run();

		//Klasa anonimowa, czyli tworzenie obiektu klasy anonimowej implementującej interfejs CommandLineRunner
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				quizRepository.save(new Quiz(0,"Operator new służy do?","Tworzenia obiektów\nTworzenia klas\nWstawiania nowej linii","Tworzenia obiektów", "JAVA"));
//				quizRepository.save(new Quiz(0,"Wskaż deklarację zmiennej całkowitej","boolean a = true;\nint a = 10;\ndouble a = 3;","int a = 10;", "JAVA"));
//				quizRepository.save(new Quiz(0,"Klauzula HAVING występuje razem z?","WHERE\nORDER BY\nGROUP BY","GROUP BY", "BAZY"));
//				quizRepository.save(new Quiz(0,"Jaka jest wartość wyrażenia TRUE OR NULL?","TRUE\nNULL\nFALSE","TRUE", "BAZY"));
//				userRepository.save(new User(0, "adam@op.pl"));
//				userRepository.save(new User(0, "ewa@wsb.edu.pl"));
//			}
//		};

		//Lambda służy do definicji obiektów implementujących interfejsy funkcyjne (z jedną metodą abstrakcyjną)
		return (String... args) -> {
			quizRepository.save(new Quiz(0,"Operator new służy do?","Tworzenia obiektów\nTworzenia klas\nWstawiania nowej linii","Tworzenia obiektów", "JAVA"));
			quizRepository.save(new Quiz(0,"Wskaż deklarację zmiennej całkowitej","boolean a = true;\nint a = 10;\ndouble a = 3;","int a = 10;", "JAVA"));
			quizRepository.save(new Quiz(0,"Klauzula HAVING występuje razem z?","WHERE\nORDER BY\nGROUP BY","GROUP BY", "BAZY"));
			quizRepository.save(new Quiz(0,"Jaka jest wartość wyrażenia TRUE OR NULL?","TRUE\nNULL\nFALSE","TRUE", "BAZY"));
			userRepository.save(new User(0, "adam@op.pl"));
			userRepository.save(new User(0, "ewa@wsb.edu.pl"));
		};
	}
}
