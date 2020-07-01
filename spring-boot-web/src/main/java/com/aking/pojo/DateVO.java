package com.aking.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName DateVO
 * @Description
 * @Author yk
 * @Date 2020/7/1 10:12
 * @Version 1.0
 **/
@Data
public class DateVO {
    /**
     * 出参格式化
     */
    @JsonFormat(
            timezone = "GMT+8",
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    /**
     * 入参格式化
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date payTime;
}
