package com.smart.chapter4.ioc;

/**
 * Director
 */
public class Director {
    public void direct() {
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack();
        moAttack.injectGeli(geli);
        moAttack.cityGateAsk();
    }
}