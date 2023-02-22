package com.slsher.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: laiweilai
 * @description:
 * @author: zhuzhiwen
 * @date: 2023/02/22 22:20
 **/
@Data
@ApiModel
public class Result {
    @ApiModelProperty(value = "状态")
    protected boolean status;
    @ApiModelProperty(value = "返回信息")
    protected String message;
    @ApiModelProperty(value = "数据")
    protected Object data;
    @ApiModelProperty(value = "数据量")
    protected Integer count;
}
