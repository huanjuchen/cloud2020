package xyz.huanju.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.huanju.cloud.entity.Order;

/**
 * @author HuanJu
 * @date 2020/8/3 18:24
 */
@Mapper
public interface OrderDao {

    /**
     * 新建订单
     */
    void create(Order order);


    /**
     * 修改订单状态
     */
    void update(@Param("id") Long id,@Param("status") Integer status);

}
