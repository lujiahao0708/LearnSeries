package com.lujiahao.ChainOfResponsibility;

/**
 * @author lujiahao
 * @date 2018-08-14 上午11:43
 */
/**
 * 封装销售单的数据，简单的示意一下
 */
public class SaleModel {
    /**
     * 销售的商品
     */
    private String goods;
    /**
     * 销售的数量
     */
    private int saleNum;
    public String getGoods() {
        return goods;
    }
    public void setGoods(String goods) {
        this.goods = goods;
    }
    public int getSaleNum() {
        return saleNum;
    }
    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }
    public String toString(){
        return "商品名称="+goods+",销售数量="+saleNum;
    }
}