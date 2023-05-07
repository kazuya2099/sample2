package com.example.writer;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component("writer")
public class PdfWriter implements Writer {
	
	@Override
	public void write(String data) {
		try(FileOutputStream osw = new FileOutputStream("sample.pdf")) {
			osw.write(data.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
