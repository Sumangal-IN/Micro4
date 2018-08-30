package com.example.micro4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Micro4Application {

	@Autowired
	TaskRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Micro4Application.class, args);
	}

	@RequestMapping(value = "/createTask/{topic}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Task createTask(@PathVariable("topic") String topic) {
		return repo.save(new Task(topic));
	}

	@RequestMapping(value = "/findAllTask", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Task> findAllTopic() {
		return repo.findAll();
	}

	@RequestMapping(value = "/findTaskByTopic/{topic}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Task> findTaskByTopic(@PathVariable("topic") String topic) {
		return repo.findByTopicOrderByIdDesc(topic);
	}

	@RequestMapping(value = "/findByTopicContainWord/{word}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Task> findByTopicContaingWord(@PathVariable("word") String word) {
		return repo.findByTopicContainWord(word);
	}

}
