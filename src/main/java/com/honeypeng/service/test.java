package com.honeypeng.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by PengWX on 2020/9/1.
 */
public class test {

    public static void main(String[] args) {
        // java spi
        ServiceLoader<IDubboTestService> load = ServiceLoader.load(IDubboTestService.class);
        Iterator<IDubboTestService> iterator = load.iterator();
        while (iterator.hasNext()) {
            IDubboTestService dubboTestService = iterator.next();
            String test = dubboTestService.test();
            System.out.println(test);
        }

       /* mergeImage("C:\\Users\\ftcs\\Desktop\\日志\\123.jpg", "C:\\Users\\ftcs\\Desktop\\日志\\234.png", "C:\\Users\\ftcs\\Desktop\\日志\\4.jpg");*/
    }



    /**
     * 将两张图片合并为一张图片
     * @param oneSrc 第一张图片  C:\Users\ftcs\Desktop\日志\123.jpg
     * @param twoSrc 第二张图片  C:\Users\ftcs\Desktop\日志\234.png
     * @param mergeSrc 合并后的图片路径  C:\Users\ftcs\Desktop\日志\4.jpg
     */
    public static void mergeImage(String oneSrc, String twoSrc, String mergeSrc) {
        String postFix = mergeSrc.substring(mergeSrc.lastIndexOf(".") + 1, mergeSrc.length());
        try {
            File fileOne = new File(oneSrc);//读取第一张图片
            Image src = ImageIO.read(fileOne);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            if(width > 900 || height > 900) {
                int num = (int) Math.ceil((double)width/900);
                int num2 = (int) Math.ceil((double)height/900);
                // height = height/num;
            }
            BufferedImage bufferedImageOne = null;
            if ("png".equalsIgnoreCase(postFix.toLowerCase())) {
                bufferedImageOne = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            } else {
                bufferedImageOne = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }
            bufferedImageOne.getGraphics().drawImage(src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0,  null);
            int[] imageArrayOne = new int[width * height];// 从图片中读取RGB
            imageArrayOne = bufferedImageOne.getRGB(0, 0, width, height, imageArrayOne, 0, width);

            File fileTwo = new File(twoSrc);//读取第二张图片
            src = ImageIO.read(fileTwo);
            BufferedImage bufferedImageTwo = null;
            if ("png".equalsIgnoreCase(postFix.toLowerCase())) {
                bufferedImageTwo = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            } else {
                bufferedImageTwo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }
            bufferedImageTwo.getGraphics().drawImage(src.getScaledInstance(width, height,  Image.SCALE_SMOOTH), 0, 0,  null);
            int[] imageArrayTwo = new int[width * height];// 从图片中读取RGB
            imageArrayTwo = bufferedImageTwo.getRGB(0, 0, width, height, imageArrayTwo, 0, width);

            //生成新图片
            BufferedImage imageNew = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_RGB);
            imageNew.setRGB(0 , 0, width, height, imageArrayOne, 0, width);     //设置左半部分的RGB
            imageNew.setRGB(width, 0, width, height, imageArrayTwo, 0, width);  //设置右半部分的RGB
            File outFile = new File(mergeSrc);
            //写图片
            ImageIO.write(imageNew, postFix, outFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
