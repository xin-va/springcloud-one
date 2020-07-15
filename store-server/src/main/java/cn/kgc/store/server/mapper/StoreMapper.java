package cn.kgc.store.server.mapper;

import cn.kgc.project.common.entity.Store;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:19  <br/>
 * 类描述   ：
 */
public interface StoreMapper {
    public abstract List<Store> selectAllStore();
    public abstract Store selectByStoreId(Integer store_id);
}
