package xyz.huanju.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author HuanJu
 * @date 2020/8/4 3:14
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId,
                  @Param("money") BigDecimal money);

}
