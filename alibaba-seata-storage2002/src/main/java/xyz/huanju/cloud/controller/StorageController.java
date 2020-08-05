package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.service.StorageService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/4 3:00
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease",method = RequestMethod.POST)
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减成功");
    }


}
