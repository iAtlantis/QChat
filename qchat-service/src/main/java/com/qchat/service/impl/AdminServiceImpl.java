package com.qchat.service.impl;

import com.qchat.enums.MsgActionEnum;
import com.qchat.enums.MsgSignFlagEnum;
import com.qchat.enums.SearchFriendsStatusEnum;
import com.qchat.mapper.*;
import com.qchat.netty.ChatMsg;
import com.qchat.netty.DataContent;
import com.qchat.netty.UserChannelRel;
import com.qchat.pojo.Admin;
import com.qchat.pojo.FriendsRequest;
import com.qchat.pojo.MyFriends;
import com.qchat.pojo.Users;
import com.qchat.pojo.vo.AdminVO;
import com.qchat.pojo.vo.FriendRequestVO;
import com.qchat.pojo.vo.MyFriendsVO;
import com.qchat.pojo.vo.UsersVO;
import com.qchat.service.AdminService;
import com.qchat.service.UserService;
import com.qchat.utils.FastDFSClient;
import com.qchat.utils.FileUtils;
import com.qchat.utils.JsonUtils;
import com.qchat.utils.QRCodeUtils;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminMapperCustom adminMapperCustom;

    @Autowired
    private Sid sid;


    @Override
    public boolean queryAdminIsExist(String adminName) {
        Admin admin =new Admin();
        admin.setUsername(adminName);
        Admin result = adminMapper.selectOne(admin);

        return result!=null?true:false;
    }

    @Override
    public Admin queryAdminForLogin(String adminname, String pwd) {
        Example adminExample = new Example(Admin.class);
        Criteria criteria = adminExample.createCriteria();

        criteria.andEqualTo("username",adminname);
        criteria.andEqualTo("password",pwd);

        Admin result=adminMapper.selectOneByExample(adminExample);

        return result;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        String adminId = sid.nextShort();

        admin.setId(adminId);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public List<AdminVO> queryAdmins() {
        List<AdminVO> adminVOS=adminMapperCustom.queryAdmin();
        return adminVOS;
    }



    @Override
    public List<UsersVO> queryUsers(){
        List<UsersVO> usersVOS=adminMapperCustom.queryUsers();
        return usersVOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAdmin(String username){
        adminMapperCustom.deleteAdmin(username);
    }
}
