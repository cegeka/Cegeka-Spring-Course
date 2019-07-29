package com.cegeka.springcourse.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SpringBootApplication
public class EventsApplication {

	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster syncEventMulticaster = new SimpleApplicationEventMulticaster();
		SimpleApplicationEventMulticaster asyncEventMulticaster = new SimpleApplicationEventMulticaster();
		asyncEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return new SyncAndAsyncEventMulticaster(syncEventMulticaster, asyncEventMulticaster);
	}

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

}
