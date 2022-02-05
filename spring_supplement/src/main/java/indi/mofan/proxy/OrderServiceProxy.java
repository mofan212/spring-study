package indi.mofan.proxy;

/**
 * OrderServiceImpl 的代理类
 *
 * @author mofan
 * @date 2021/10/10 14:47
 * @see OrderServiceImpl
 */
public class OrderServiceProxy implements OrderService {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("--- log ---");
        orderService.showOrder();
    }
}
