package com.rloayza.classroom.restapi;

import com.rloayza.classroom.restapi.command.CreateClassCmd;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateClassCmdTests {

	@Autowired
	private CreateClassCmd createClassCmd;

	private ClassRequest classRequest;

	@Before
	public void init() {
		classRequest = new ClassRequest();
		classRequest.setDescription("Programming");
		classRequest.setTitle("Programming");
	}

	@Test
	public void createClassTest() {

		createClassCmd.setClassRequest(classRequest);
		createClassCmd.execute();

		classRequest = createClassCmd.getClassRequest();

		Assert.assertNotNull(classRequest.getCode());
	}

}
