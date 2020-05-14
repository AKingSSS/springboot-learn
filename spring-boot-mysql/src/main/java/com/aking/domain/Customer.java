package com.aking.domain;

import com.aking.annotations.MyValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * @ClassName Customer
 * @Description
 * @Author yk
 * @Date 2020/5/14 15:32
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    // 添加2个空接口，用例标记参数校验规则
    /**
     * 注册校验规则
     */
    public interface UserRegisterValidView extends Default {
    }

    /**
     * 登录校验规则
     */
    public interface UserLoginValidView {
    }

    @Size(max = 33)
    /**
     * @NotBlank：只用在 String 上，表示传进来的值不能为 null，而且调用 trim () 后，长度必须大于 0
     * @NotNull：不能为 null，但可以为 empty (分配了内存空间，但值为空)
     * @NotEmpty：不能为 null，而且长度必须大于 0
     */
    @NotBlank(message = "username 不能为空")
    private String username;

    @NotBlank(message = "password 不能为空")
//    @Length(min = 6,message = "密码至少 6 位")
    @MyValid(min = 6,message = "密码至少 6 位")
    private String password;

    @NotBlank(groups = { UserRegisterValidView.class }, message = "verifyCode 不能为空")
    private String verifyCode;

    /**
     * 邮箱接收验证码
     */
    @Email(groups = { UserRegisterValidView.class }, message = "email 格式不正确")
    @NotBlank(groups = { UserRegisterValidView.class }, message = "email 不能为空")
    private String email;
}
