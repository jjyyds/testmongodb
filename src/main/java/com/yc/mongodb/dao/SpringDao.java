package com.yc.mongodb.dao;

import com.yc.mongodb.bean.Spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //添加
    public Spring insert(Spring spring){
        Spring s=mongoTemplate.insert(spring,"spring");
        return s;
    }

    /**
     * 更新
     * @param filed 字段名
     * @param id id
     * @param obj 要修改的值
     */
    public void update(String filed,Integer id,Object obj){
        Query query=new Query(Criteria.where("_id").is(id));//创建查询条件
        Update update=new Update();
        update.set(filed,obj);//添加修改条件
        mongoTemplate.updateFirst(query,update,"spring");
    }

    //查询
    public Spring findByName(String name){
        Query query=new Query(Criteria.where("name").is(name));
        Spring s=mongoTemplate.findOne(query, Spring.class,"spring");
        return s;
    }

    //删除
    public void delete(Integer id){
        Query query=new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,"spring");
    }
}
