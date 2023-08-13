package com.wangxingdi.wechat;

import com.alibaba.fastjson.JSON;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.ecb.controller.WeChatUserController;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class WeChatUserTests {

	private MockMvc mockMvc;
	@Resource
	private WebApplicationContext webApplicationContext;
	@Resource
	private WeChatUserController weChatUserController;

	@BeforeEach
	public void beforeAll(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testInsert(){
		WeChatUser weChatUser = new WeChatUser();
		weChatUser.setOpenId("test-0001");
		weChatUser.setUserRole("admin");
		weChatUser.setUserType("ecb");
		Integer insert = weChatUserController.insert(weChatUser);
		System.out.println("testInsert=" + insert);
	}

	@Test
	public void testFindByOpenId(){
		WeChatUser weChatUser = new WeChatUser();
		weChatUser.setOpenId("ojE495CzRIAN4tbNUmE73vzmuMNw");
		WeChatUser byId = weChatUserController.findByOpenId(weChatUser);
		System.out.println("testFindByOpenId=" + JSON.toJSONString(byId));
	}

	@Test
	public void testInit(){
		WeChatUser weChatUser = new WeChatUser();
//		weChatUser.setCode("0c3AS51w3oXm213y9Y3w3arehB2AS51O");
		Response<WeChatUser> response = weChatUserController.init(weChatUser);
		System.out.println("testInit=" + JSON.toJSONString(response));
	}

	@Test
	public void testCheckSecretKey() throws Exception {
		WeChatUser weChatUser = new WeChatUser();
		RequestBuilder request = post("/user/checkSecretKey")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(JSON.toJSONString(weChatUser));
		ResultActions perform = mockMvc.perform(request);
		System.out.println("testCheckSecretKey=" + JSON.toJSONString(perform));
	}

}
