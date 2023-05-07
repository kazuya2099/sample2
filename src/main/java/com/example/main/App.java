package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.writer.DocumentWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		app.sampleExecute();
	}
	
	public void sampleExecute() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DocumentWriter documentWriter = (DocumentWriter) applicationContext.getBean("documentWriter");
		documentWriter.write("あいうえお");
	}
}
