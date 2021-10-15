package com.qchat.service;

import com.qchat.netty.ChatMsg;
import com.qchat.pojo.Admin;
import com.qchat.pojo.Users;
import com.qchat.pojo.vo.AdminVO;
import com.qchat.pojo.vo.FriendRequestVO;
import com.qchat.pojo.vo.MyFriendsVO;
import com.qchat.pojo.vo.UsersVO;

import java.util.List;

public interface AdminService {


    boolean queryAdminIsExist(String adminName);

    public Admin queryAdminForLogin(String adminname, String pwd);
    public Admin saveAdmin(Admin admin);

    public List<AdminVO> queryAdmins();
    public List<UsersVO> queryUsers();

    /**
     *
     * @Description: 管理员删除管理
     */
    public void deleteAdmin(String username);
}
