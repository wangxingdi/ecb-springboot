package com.wangxingdi.wechat.ecb;

import com.alibaba.fastjson.JSON;
import com.wangxingdi.wechat.common.domain.Page;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.ecb.controller.EcbAccountController;
import com.wangxingdi.wechat.ecb.domain.EcbAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EcbAccountTests {

	@Resource
	private EcbAccountController ecbAccountController;

	@Test
	public void testInsert(){
		EcbAccount ecbAccount = new EcbAccount();
		ecbAccount.setOpenId("ojE495CzRIAN4tbNUmE73vzmuMNw");
		ecbAccount.setSecretKey(123456);
		ecbAccount.setAppName("百度");
		ecbAccount.setUserName("15811543214");
		ecbAccount.setPassword("abc123456");
		ecbAccount.setRemark("备注");
		Response response = ecbAccountController.insert(ecbAccount);
		System.out.println("testInsert=" + JSON.toJSONString(response));
	}

	@Test
	public void testDelete(){
		EcbAccount ecbAccount = new EcbAccount();
		ecbAccount.setOpenId("ojE495CzRIAN4tbNUmE73vzmuMNw");
		ecbAccount.setAsId("ECB1690290658805001");
		Response response = ecbAccountController.delete(ecbAccount);
		System.out.println("testDelete=" + JSON.toJSONString(response));
	}

	@Test
	public void testUpdate(){
		EcbAccount ecbAccount = new EcbAccount();
		ecbAccount.setAsId("ECB1690290658805001");
		ecbAccount.setOpenId("ojE495CzRIAN4tbNUmE73vzmuMNw");
		ecbAccount.setSecretKey(123456);
		ecbAccount.setAppName("京东");
		ecbAccount.setUserName("158115");
		ecbAccount.setPassword("abc1234");
		ecbAccount.setRemark("备注");
		Response response = ecbAccountController.update(ecbAccount);
		System.out.println("testUpdate=" + JSON.toJSONString(response));
	}

	@Test
	public void testPage(){
		EcbAccount ecbAccount = new EcbAccount();
		ecbAccount.setOpenId("ojE495CzRIAN4tbNUmE73vzmuMNw");
		Page<EcbAccount> page = new Page<>();
		page.setParam(ecbAccount);
		Page<EcbAccount> list = ecbAccountController.page(page);
		System.out.println("testPage=" + JSON.toJSONString(list));
	}

	@Test
	public void testFindByAsId(){
		EcbAccount ecbAccount = new EcbAccount();
		ecbAccount.setAsId("1");
		ecbAccount.setOpenId("1");
		ecbAccount.setSecretKey(123456);
		Response<EcbAccount> response = ecbAccountController.findByAsId(ecbAccount);
		System.out.println("testFindByAsId=" + JSON.toJSONString(response));
	}

}
