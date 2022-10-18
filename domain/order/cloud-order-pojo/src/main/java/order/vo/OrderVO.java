package order.vo;

import lombok.Data;
import order.pojo.Order;

/**
 * @author Lixiangping
 * @createTime 2022年10月18日 15:51
 * @decription:
 */
@Data
public class OrderVO extends Order {

    private Long userId;
    private String username;
    private String password;
    private String mobile;
}
