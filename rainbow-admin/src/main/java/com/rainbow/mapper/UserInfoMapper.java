package com.rainbow.mapper;

import java.util.List;

import com.rainbow.model.dto.ExportUserInfoDTO;
import com.rainbow.model.vo.ExportUserInfoVO;
import org.apache.ibatis.annotations.Param;
import com.rainbow.model.entity.UserInfo;
import com.rainbow.mapper.base.UserInfoBaseMapper;
/**
*  @author author
*/
public interface UserInfoMapper extends UserInfoBaseMapper{


    /**
     * 用户信息导出
     * @param dto
     * @return
     */
    List<ExportUserInfoVO> export(ExportUserInfoDTO dto);
}