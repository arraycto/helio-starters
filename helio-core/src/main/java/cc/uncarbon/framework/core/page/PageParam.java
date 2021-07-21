package cc.uncarbon.framework.core.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 分页参数
 * @author Uncarbon
 */

@Accessors(chain = true)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageParam implements Serializable {
    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    @ApiModelProperty("页大小")
    private Integer pageSize = 10;
}
