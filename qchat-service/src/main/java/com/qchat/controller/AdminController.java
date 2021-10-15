package com.qchat.controller;

import com.qchat.pojo.Admin;
import com.qchat.pojo.Role;
import com.qchat.pojo.Users;
import com.qchat.pojo.vo.AdminVO;
import com.qchat.pojo.vo.UsersVO;
import com.qchat.service.AdminService;
import com.qchat.service.UserService;
import com.qchat.utils.IMoocJSONResult;
import com.qchat.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * @Description: 用户登录
	 */
	@PostMapping("/login")
	public IMoocJSONResult login(@RequestBody Admin admin) throws Exception {

		boolean adminIsExist = adminService.queryAdminIsExist(admin.getUsername());
		Admin adminResult = null;
		if(adminIsExist){
			adminResult = adminService.queryAdminForLogin(admin.getUsername(),
										MD5Utils.getMD5Str(admin.getPassword()));

			if(adminResult == null){
				return IMoocJSONResult.errorMsg("用户名或密码不正确...");
			}

		}else {
			return IMoocJSONResult.errorMsg("用户不存在...");
		}
		//System.out.println(adminResult.getUsername()+"==>"+adminResult.getPassword());
		return IMoocJSONResult.ok(adminResult);
	}

	/**
	 * @Description: 用户登录
	 */
	@PostMapping("/regist")
	public IMoocJSONResult regist(@RequestBody Admin admin) throws Exception {
		//判断用户是否存在，如果存在就失败，不存在则注册
		Admin adminResult=null;
		boolean adminnameIsExist = adminService.queryAdminIsExist(admin.getUsername());
		if(adminnameIsExist){
			return IMoocJSONResult.errorMsg("该用户已存在");
		}else{
			admin.setPassword(MD5Utils.getMD5Str(admin.getPassword()));
			Date date = new Date();//获取当前的日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String str = df.format(date);//获取String类型的时间
			admin.setCreateDate(str);

			//BeanUtils.copyProperties(admin,adminResult);
			adminResult=adminService.saveAdmin(admin);
			System.out.printf("adminResult====>"+adminResult);
			return IMoocJSONResult.ok(adminResult);

		}
	}

	/**
	 * 列表展示
	 * @return
	 */
	@GetMapping("/adminList")
	public IMoocJSONResult adminList(){
		List<AdminVO> admins = adminService.queryAdmins();
		System.out.println("Admin列表:\n");
		System.out.println(admins);
		return IMoocJSONResult.ok(admins);
	}

	@GetMapping("/userList")
	public IMoocJSONResult userList(){
		List<UsersVO> users = adminService.queryUsers();
		System.out.println("User列表:\n");
		System.out.println(users);
		return IMoocJSONResult.ok(users);
	}

	@DeleteMapping("/deleteAdmin")
	public IMoocJSONResult deleteUser(@RequestBody Admin admin){
		adminService.deleteAdmin(admin.getUsername());
		return IMoocJSONResult.ok();
	}
}
