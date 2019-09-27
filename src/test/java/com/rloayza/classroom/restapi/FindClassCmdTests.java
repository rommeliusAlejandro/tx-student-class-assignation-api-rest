package com.rloayza.classroom.restapi;

import com.rloayza.classroom.restapi.command.CreateClassCmd;
import com.rloayza.classroom.restapi.command.FindClassCmd;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.exceptions.EntityNotFoundException;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.request.ClassRequest;
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
public class FindClassCmdTests {

	@Autowired
	private CreateClassCmd createClassCmd;

	@Autowired
	private FindClassCmd findClassCmd;

	private ClassRequest classRequest;

	@Before
	public void init() {
		classRequest = new ClassRequest();
		classRequest.setDescription("Programming");
		classRequest.setTitle("Programming");

		createClassCmd.setClassRequest(classRequest);
		createClassCmd.execute();

		classRequest = createClassCmd.getClassRequest();
	}

	@Test	
	public void findClassTest() throws APIException {

		findClassCmd.setCode(classRequest.getCode());
		findClassCmd.execute();

		Clazz clazz = findClassCmd.getClazz();

		Assert.assertEquals("Programming", clazz.getTitle());
	}

	@Test(expected = EntityNotFoundException.class)
	public void notFoundClassTest() throws APIException {
		findClassCmd.setCode(UUID.randomUUID());
		findClassCmd.execute();
	}

}
