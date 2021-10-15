package com.qchat.mapper;

import java.util.List;

import com.qchat.pojo.Users;
import com.qchat.pojo.vo.FriendRequestVO;
import com.qchat.pojo.vo.MyFriendsVO;
import com.qchat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperCustom extends MyMapper<Users> {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	
	public List<MyFriendsVO> queryMyFriends(String userId);
	
	public void batchUpdateMsgSigned(List<String> msgIdList);

	public void deleteUser(String username);
	
}