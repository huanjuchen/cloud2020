package xyz.huanju.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.huanju.cloud.domain.CommonResult;

/**
 * @author HuanJu
 * @date 2020/8/3 18:40
 */

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count);

}
