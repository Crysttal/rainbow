package com.rainbow.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  dengjie9527
 * date 2019/9/11
 */
@Data
@ApiModel
public class UserInfoEntity {

    @ApiModelProperty(value = "当前行数")
    private Integer currentRow;


}
