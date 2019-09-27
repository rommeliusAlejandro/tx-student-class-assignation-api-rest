package com.rloayza.classroom.restapi;

import com.rloayza.classroom.restapi.command.CreateClassCmd;
import com.rloayza.classroom.restapi.command.CreateStudentCmd;
import com.rloayza.classroom.restapi.command.FindClassCmd;
import com.rloayza.classroom.restapi.command.FindStudentCmd;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.exceptions.EntityNotFoundException;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.request.ClassRequest;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindStudentCmdTests {

	@Autowired
	private CreateStudentCmd createStudentCmd;

	@Autowired
	private FindStudentCmd findStudentCmd;

	private StudentRequest studentRequest;

	@Before
	public void init() {
		studentRequest = new StudentRequest();
		studentRequest.setFirstName("Rommel");
		studentRequest.setLastName("Loayza");

		createStudentCmd.setStudentRequest(studentRequest);
		createStudentCmd.execute();

		studentRequest = createStudentCmd.getStudentRequest();
	}

	@Test	
	public void findClassTest() throws APIException {

		findStudentCmd.setStudentId(studentRequest.getStudentId());
		findStudentCmd.execute();

		Student student = findStudentCmd.getStudent();

		Assert.assertEquals("Rommel", student.getFirstName());
	}

	@Test(expected = EntityNotFoundException.class)
	public void notFoundClassTest() throws APIException {
		findStudentCmd.setStudentId(0);
		findStudentCmd.execute();
	}

}
