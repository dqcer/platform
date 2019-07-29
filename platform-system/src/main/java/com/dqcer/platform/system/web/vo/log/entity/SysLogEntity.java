package com.dqcer.platform.system.web.vo.log.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 * @Author dongqin
 * @Description
 * @Date 10:38 2019/7/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_log")
public class SysLogEntity implements Serializable {

    private static final long serialVersionUID = -5711388490963605237L;

    /**
     * 主键
     */

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 耗时
     */
    private Long costTime;

    /**
     * IP
     */
    private String ip;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 请求路径
     */
    private String requestUrl;
    /**
     * 请求方法
     */
    private String method;

    /**
     * 返回状态码
     */
    private Integer responseStatus;

    /**
     * 操作人主键
     */
    private Integer uid;

    /**
     * 操作人用户名称
     */
    private String username;

    /**
     * 操作人账户
     */
    private String name;

    /**
     * 操作详细日志
     */
    private String logContent;

    /**
     * 日志类型（1登录日志，2操作日志）
     */
    private Integer logType;

    /**
     * 操作类型（）
     */
    private Integer operateType;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
}
