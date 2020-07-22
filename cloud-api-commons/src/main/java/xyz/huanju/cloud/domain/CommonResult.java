package xyz.huanju.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuanJu
 * @date 2020/7/11 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

    private Integer code;

    private String message;

    private Object data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
