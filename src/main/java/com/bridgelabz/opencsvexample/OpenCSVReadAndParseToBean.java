package com.bridgelabz.opencsvexample;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVReadAndParseToBean {
private static final String SAMPLE_CSV_FILE = "users.csv";
	
	public static void main(String[] args) throws IOException {
		try (
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
			) {
				CsvToBean<CSVUsers> csvToBean = new CsvToBeanBuilder<CSVUsers>(reader)
						.withType(CSVUsers.class)
						.withIgnoreLeadingWhiteSpace(true)
						.build();
	
				Iterator<CSVUsers> csvUserIterator = csvToBean.iterator();
				while(csvUserIterator.hasNext()) {
					CSVUsers csvUser = csvUserIterator.next();
					System.out.println("Name: "+csvUser.getName());
					System.out.println("Email: "+csvUser.getEmail());
					System.out.println("Phone: "+csvUser.getPhoneNo());
					System.out.println("Country: "+csvUser.getCountry());
					System.out.println("===================");
				}
			}
	}
}
