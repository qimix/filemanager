package ru.netology.filemanager;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.filemanager.model.FileInfo;
import ru.netology.filemanager.util.FileManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootTest
class FilemanagerApplicationTests {

	@Test
	void contextLoads() {
	}

	public class FileManagerTest {

		private static MultipartFile multipartFile;

		private static FileManager manager;

		private static FileInfo file;

		@BeforeClass
		public static void prepareTestData() throws IOException {
			file = FileInfo.builder()
					.setId(9L)
					.setName("mockFile.txt")
					.setKeyFile("mockFile.txt")
					.setSize(38975L)
					.setLocalDate(LocalDate.now())
					.build();
			multipartFile = new MockMultipartFile("mockFile", "mockFile.txt", "txt",
					new FileInputStream("src/test/resources/mockFile.txt"));
			manager = new FileManager();
		}
	}

}
