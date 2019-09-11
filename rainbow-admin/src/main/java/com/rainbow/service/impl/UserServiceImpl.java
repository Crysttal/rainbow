package com.rainbow.service.impl;


import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.rainbow.common.exception.ExcelException;
import com.rainbow.mapper.UserInfoMapper;
import com.rainbow.model.dto.ExportUserInfoDTO;
import com.rainbow.model.dto.InsertDTO;
import com.rainbow.model.entity.UserInfo;
import com.rainbow.model.vo.ExportUserInfoVO;
import com.rainbow.service.UserService;
import com.rainbow.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * author  DENGJIE9527
 * date 2019/8/6
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;


    @Override
    public int addUser(InsertDTO dto) {
        UserInfo build = UserInfo.Build()
                .serialNo(dto.getSerialNo())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
        return userInfoMapper.insertUserInfo(build);
    }

    @Override
    public void importUserInfo(MultipartFile file) {

    }

    @Override
    public void exportUserInfo(ExportUserInfoDTO dto, HttpServletResponse response) {
        String fileName = "用户信息";

        List<ExportUserInfoVO> exportList = new ArrayList<>();

        List<ExportUserInfoVO> list = userInfoMapper.export(dto);

        exportList.addAll(list);
        log.info("获取用户信息出参:UserServiceImpl_exportUserInfo_list={}", JSON.toJSONString(list));

        try {
            ExcelUtil.writeExcel(response, exportList, fileName, null, ExcelTypeEnum.XLSX, ExportUserInfoVO.class);
        } catch (ExcelException e) {
            log.error("导出失败", e);
            e.printStackTrace();
        }
    }
}
