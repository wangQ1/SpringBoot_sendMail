package cn.et.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	@Autowired
	private JavaMailSender jms;
	@PostMapping("/send")
	public String sendMail(@RequestBody Map<String, Object> map){
		SimpleMailMessage smm = new SimpleMailMessage();
		//来自
		smm.setFrom("mr.wang1@aliyun.com");
		//发送到
		smm.setTo(map.get("email_to").toString());
		//标题
		smm.setSubject(map.get("email_subject").toString());
		//内容
		smm.setText(map.get("email_content").toString());
		jms.send(smm);
		return "1";
	}
	@GetMapping("/user/{userId}")
	public Map<String, String> getUser(@PathVariable String userId){
		Map<String, String> map=new HashMap<String, String>();
		map.put("id", userId);
		map.put("name","ls_"+userId);
		return map;
	}
}
