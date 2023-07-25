package com.wangxingdi.wechat;

import com.alibaba.fastjson.JSON;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.ecb.controller.WeChatUserController;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WeChatUserTests {

	@Resource
	private WeChatUserController weChatUserController;

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

}
