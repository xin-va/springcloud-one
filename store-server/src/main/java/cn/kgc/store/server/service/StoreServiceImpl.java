package cn.kgc.store.server.service;

import cn.kgc.project.common.entity.Store;
import cn.kgc.store.server.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:51  <br/>
 * 类描述   ：
 */
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public List<Store> getAllStore() {
        return storeMapper.selectAllStore();
    }
}
