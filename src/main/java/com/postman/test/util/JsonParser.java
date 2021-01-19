package com.postman.test.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	/**
	 * @author Sean Trego
	 * Method is used to parse a json file and map that file to a generic object.  That object must be cast to a specific pojo.
	 * @param path
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object readData(String path, Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(path), clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
