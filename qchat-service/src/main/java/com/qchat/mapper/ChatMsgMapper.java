package com.qchat.mapper;

import com.qchat.pojo.ChatMsg;
import com.qchat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMsgMapper extends MyMapper<ChatMsg> {
}