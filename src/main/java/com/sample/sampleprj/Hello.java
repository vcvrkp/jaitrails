package com.sample.sampleprj;


import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Hello {

    public static void main(String[] a) throws Exception {
//        BufferedImage[] images = new BufferedImage[3];
//
//
//        images[0] = ImageIO.read(new File("/Users/vcvr/Desktop/RBS/testfile.tif"));
//        images[1] =  ImageIO.read(new File("/Users/vcvr/Desktop/RBS/testfile1.tif"));
//        images[2] =  ImageIO.read(new File("/Users/vcvr/Desktop/RBS/testfile2.tif"));
//
//        OutputStream op = new FileOutputStream(new File("test.tif"));
//        ImageWriter writer = ImageIO.getImageWritersByFormatName("tiff").next();
//        try (ImageOutputStream ops = ImageIO.createImageOutputStream(op)) {
//            ImageWriteParam params = writer.getDefaultWriteParam();
//            params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//            params.setCompressionType("Deflate");
//            boolean prepared = false;
//
//            for (BufferedImage image : images) {
//                IIOImage imageIO = new IIOImage(image, null, null);
//                if (!prepared) {
//                    writer.prepareWriteSequence(imageIO.getMetadata());
//                    prepared = true;
//                }
//                writer.writeToSequence(imageIO, params);
//            }
//            writer.endWriteSequence();
//        }
    }

}
