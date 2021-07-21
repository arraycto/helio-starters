package cc.uncarbon.framework.crud.handler;

import cc.uncarbon.framework.core.constant.HelioConstant;
import cc.uncarbon.framework.core.context.UserContextHolder;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 字段填充器
 * 摘自Mybatis-Plus官方例程
 * @author nieqiurong 2018-08-10 22:59:23.
 */
public class MybatisPlusAutoFillColumnHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, HelioConstant.CRUD.ENTITY_FIELD_TENANT_ID, Long.class, UserContextHolder.getRelationalTenant().getTenantId());
        this.strictInsertFill(metaObject, HelioConstant.CRUD.ENTITY_FIELD_CREATE_AT, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, HelioConstant.CRUD.ENTITY_FIELD_CREATE_BY, String.class, UserContextHolder.getUserContext().getUserName());

        // 同时加入更新字段
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, HelioConstant.CRUD.ENTITY_FIELD_UPDATE_AT, LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, HelioConstant.CRUD.ENTITY_FIELD_UPDATE_BY, String.class, UserContextHolder.getUserContext().getUserName());
    }

}
