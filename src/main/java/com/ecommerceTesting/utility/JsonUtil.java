package com.ecommerceTesting.utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static List<HashMap<String, String>> getJsonDataToLogin() throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\ecommercetesting\\Resources\\loginData.json"),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}
	
	public static List<HashMap<String, String>> cardDetails() throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommercetesting\\Resources\\cardDetails.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	}
}
