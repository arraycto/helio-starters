package cc.uncarbon.framework.core.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 * @author Uncarbon
 */

@Accessors(chain = true)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> implements Serializable {
    @ApiModelProperty("当前页")
    private int current;

    @ApiModelProperty("当前页数量")
    private int size;

    @ApiModelProperty("总量")
    private int total;

    @ApiModelProperty("记录")
    private List<T> records;
}
