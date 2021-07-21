package cc.uncarbon.framework.web.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhu JW
 **/
public class InvalidFieldUtil {

    /**
     * 参数绑定验证
     * @return 快速返回首个无效表单项
     */
    public static InvalidField getInvalidField(BindingResult bindingResult) {
        if (bindingResult == null) {
            return null;
        }

        FieldError fieldError = bindingResult.getFieldError();
        if (fieldError == null) {
            return null;
        }

        return InvalidField.builder()
                .fieldName(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

    /**
     * 参数绑定验证
     * @return 全量返回无效表单项
     */
    public static List<InvalidField> listInvalidField(BindingResult bindingResult) {
        List<InvalidField> invalidFieldList = new ArrayList<>();
        if (bindingResult == null || bindingResult.getFieldErrors().size() == 0) {
            // 返回空List
            return invalidFieldList;
        }

        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            InvalidField invalidField = new InvalidField();
            invalidField.setFieldName(fieldError.getField());
            invalidField.setMessage(fieldError.getDefaultMessage());
            invalidFieldList.add(invalidField);
        }

        return invalidFieldList;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class InvalidField {

        @ApiModelProperty(value = "字段名")
        private String fieldName;

        @ApiModelProperty(value = "错误原因")
        private String message;

    }

}
