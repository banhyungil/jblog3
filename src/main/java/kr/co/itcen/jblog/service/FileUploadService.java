package kr.co.itcen.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "/uploads";
	private static final String URL_PREFIX = "/local/images";

	public String getUrl(MultipartFile multipartFile) {
		String url = "";

		if(multipartFile == null) {
			return url;
		}

		String originalFileName = multipartFile.getOriginalFilename();

		String extName = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
		String saveFileName = generateSaveFilename(extName);
		long fileSize = multipartFile.getSize();

		try {
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(fileData);
			os.close();

			url = URL_PREFIX + "/" + saveFileName;
		} catch (IOException e) {
			System.out.println("");
		}

		return url;
	}

	private String generateSaveFilename(String extName) {
		String fileName = "";

		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);

		return fileName;
	};


}
