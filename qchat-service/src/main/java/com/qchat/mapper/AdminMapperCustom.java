package com.qchat.mapper;

import com.qchat.pojo.Users;
import com.qchat.pojo.vo.AdminVO;
import com.qchat.pojo.vo.FriendRequestVO;
import com.qchat.pojo.vo.MyFriendsVO;
import com.qchat.pojo.vo.UsersVO;
import com.qchat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapperCustom extends MyMapper<Users> {

	public List<AdminVO> queryAdmin();

	public List<UsersVO> queryUsers();

	public void deleteAdmin(String username);
	
}