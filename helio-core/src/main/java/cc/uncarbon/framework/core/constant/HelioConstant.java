package cc.uncarbon.framework.core.constant;


import java.util.Locale;

public interface HelioConstant {
    interface Dubbo {
        String ENABLE_VALIDATION = "true";
        int TIMEOUT = 10000;
        int RETRIES = -1;
        int RPC_EXCEPTION_RESPONSE_CODE = 1;
    }

    interface Message {
        String NULL = "暂无数据";
        String SUCCESS = "操作成功";
        String FAILURE = "操作失败";
        String INVALID_ID = "无效ID";
    }

    interface Version {
        String APP_API_VERSION_V1 = "/api/v1";
        String SAAS_API_VERSION_V1 = "/api/v1";
        String DUBBO_VERSION_V1 = "1.0.0";
    }

    interface Jackson {
        Locale LOCALE = Locale.CHINA;
        String TIME_ZONE = "GMT+8";
        String DATE_FORMAT = "yyyy-MM-dd";
        String TIME_FORMAT = "HH:mm:ss";
        String DATE_TIME_FORMAT = Jackson.DATE_FORMAT + " " + Jackson.TIME_FORMAT;
    }

    interface CRUD {
        Long DEFAULT_TENANT_ID = 0L;
        String DEFAULT_TENANT_NAME = "请设置租户ID";
        /**
         * 该租户ID为超级租户, 可以无视SQL拦截器
         */
        Long PRIVILEGED_TENANT_ID = 0L;

        /**
         * 主键ID
         */
        String COLUMN_ID = "id";
        String ENTITY_FIELD_ID = "id";

        /**
         * 租户ID
         */
        String COLUMN_TENANT_ID = "tenant_id";
        String ENTITY_FIELD_TENANT_ID = "tenantId";

        /**
         * 创建时刻
         */
        String COLUMN_CREATE_AT = "create_at";
        String ENTITY_FIELD_CREATE_AT = "createAt";

        /**
         * 创建者
         */
        String COLUMN_CREATE_BY = "create_by";
        String ENTITY_FIELD_CREATE_BY = "createBy";

        /**
         * 更新时刻
         */
        String COLUMN_UPDATE_AT = "update_at";
        String ENTITY_FIELD_UPDATE_AT = "updateAt";

        /**
         * 更新者
         */
        String COLUMN_UPDATE_BY = "update_by";
        String ENTITY_FIELD_UPDATE_BY = "updateBy";
    }

    interface Regex {
        String CHINA_MAINLAND_MOBILE = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$";
        String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    }

    interface Permission {
        String CREATE = "create";
        String RETRIEVE = "retrieve";
        String UPDATE = "update";
        String DELETE = "delete";
    }
}
