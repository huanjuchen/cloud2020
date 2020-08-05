package xyz.huanju.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.huanju.cloud.dao.StorageDao;
import xyz.huanju.cloud.service.StorageService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/4 2:57
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("扣减库存结束");
    }
}
