package onlineShop.log;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentAction {

    @Autowired
    private Logger logger;

    public void pay(BigDecimal payValue) {
        System.out.println("paid from Payment Action instance: " + this);
        logger.log("pay begin, payValue is " + payValue);
        logger.log("pay end");
    }

    @Autowired
    public void setLogger(Logger logger) {
        System.out.println("setter was called.");
        this.logger = logger;
    }

}
