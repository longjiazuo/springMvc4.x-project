package org.light4j.springMvc4.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	String upload(MultipartFile file) {// ①

		try {
			FileUtils.writeByteArrayToFile(new File("f:/upload/" + file.getOriginalFilename()),file.getBytes()); // ②
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}
	}
}
