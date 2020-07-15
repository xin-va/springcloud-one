package cn.kgc.store.server.service;

import cn.kgc.project.common.entity.Store;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:51  <br/>
 * 类描述   ：
 */
public interface StoreService {
    public abstract List<Store> getAllStore();
}
