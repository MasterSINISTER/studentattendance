package com.attendance.studentattendance;

import com.attendance.studentattendance.run.Run;
import com.attendance.studentattendance.run.status;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.tags.EscapeBodyTag;

import java.util.logging.Logger;

@SpringBootApplication
public class Application {
	private static final Logger logger = Logger.getLogger(Application.class.getName());
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);


	}

}
