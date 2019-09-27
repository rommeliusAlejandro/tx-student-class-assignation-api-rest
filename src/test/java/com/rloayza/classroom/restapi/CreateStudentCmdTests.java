package com.rloayza.classroom.restapi;

import com.rloayza.classroom.restapi.command.CreateClassCmd;
import com.rloayza.classroom.restapi.command.CreateStudentCmd;
import com.rloayza.classroom.restapi.request.ClassRequest;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateStudentCmdTests {

	@Autowired
	private CreateStudentCmd createStudentCmd;

	private StudentRequest studentRequest;

	@Before
	public void init() {
		studentRequest = new StudentRequest();
		studentRequest.setFirstName("Rommel");
		studentRequest.setLastName("Loayza");
	}

	@Test
	public void createClassTest() {

		createStudentCmd.setStudentRequest(studentRequest);
		createStudentCmd.execute();

		studentRequest = createStudentCmd.getStudentRequest();

		Assert.assertNotNull(studentRequest.getStudentId());
	}

}
