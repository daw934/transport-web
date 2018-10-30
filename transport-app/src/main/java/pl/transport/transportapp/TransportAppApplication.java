package pl.transport.transportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TransportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportAppApplication.class, args);
		}
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}


	@Bean
	public TaskExecutor threadPoolTaskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setThreadNamePrefix("default_task_executor_thread");
		executor.initialize();

		return executor;
	}
	

}
