package com.miaosha.agent.until;

/**
 * @author qixin
 */
public enum OrderStatus {
    /**
     * CreateOutstandingPayment 创建未支付
     * HavePaid 已支付
     * shipped 已发货
     * received 已收货
     * refunded 已退款
     * offTheStocks 已完成
     */
    CreateOutstandingPayment {
        @Override
        public int orderStatus() {
            return 0;
        }
    },
    HavePaid {
        @Override
        public int orderStatus() {
            return 1;
        }
    },
    shipped {
        @Override
        public int orderStatus() {
            return 2;
        }
    },
    received {
        @Override
        public int orderStatus() {
            return 3;
        }
    },
    refunded {
        @Override
        public int orderStatus() {
            return 4;
        }
    },
    OfTheStocks {
        @Override
        public int orderStatus() {
            return 5;
        }
    };

    public abstract int orderStatus();

}
