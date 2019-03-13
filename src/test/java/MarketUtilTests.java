import static utils.MarketUtils.queueIfTimeInForce;

import dataObjects.LimitOrder;
import dataObjects.ReadyOrder.TIME_IN_FORCE;
import dataStructures.LimitOrderQueue;
import dataStructures.LimitOrderQueue.SORTING_METHOD;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.Assert;
import org.junit.Test;

public class MarketUtilTests {

    @Test
    public void testQueueIfTimeInForce() {
        SortedSet<LimitOrder> orders = new LimitOrderQueue(SORTING_METHOD.PRICE_ASC);
        LimitOrder order = LimitOrder.builder().timeInForce(TIME_IN_FORCE.GTC).orderId(1).build();
        queueIfTimeInForce(order, orders);
        Assert.assertTrue("", orders.size() == 1);
    }

    @Test
    public void testQueueIfTimeNotInForce() {
        SortedSet<LimitOrder> orders = new TreeSet<>();
        LimitOrder order = LimitOrder.builder().timeInForce(TIME_IN_FORCE.FOK).build();
        queueIfTimeInForce(order, orders);
        Assert.assertTrue("", orders.size() == 0);
    }

}
