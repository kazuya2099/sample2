package com.example.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DocumentWriter {
	
	@Autowired
	@Qualifier("writer")
	private Writer writer;
	
	public void write(String data) {
		writer.write(data);
	}
}
