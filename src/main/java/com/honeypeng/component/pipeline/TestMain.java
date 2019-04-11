package com.honeypeng.component.pipeline;

/**
 * Created by PengWX on 2019/4/11.
 */
public class TestMain {
    public static void main(String[] args) {
        String handling="aabb1122zzyy";
        StandardPipeline pipeline = new StandardPipeline();
        BasicValve basicValve = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();
        FouthValve fouthValve = new FouthValve();
        pipeline.setBasic(basicValve);
        pipeline.addValve(secondValve);
        pipeline.addValve(thirdValve);
        pipeline.addValve(fouthValve);
        pipeline.getFirst().invoke(handling);
    }
}