package com.sample.sampleprj;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codecimpl.TIFFCodec;
import com.sun.media.jai.codecimpl.TIFFImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );

        int imageWidth = 1600;
        int imageHeight = 2300;

        BufferedImage tempImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = tempImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.drawImage(tempImage, 0, 0, imageWidth, imageHeight, null);
        graphics2D.dispose();

        File outfile = new File("C:/temp/output.tif");

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outfile));

        FileSeekableStream ss = new FileSeekableStream("c:/temp/testfile.tif");

        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", ss, null);
        TIFFEncodeParam param = new TIFFEncodeParam();
        System.out.println("Height :" + tempImage.getHeight());
        System.out.println("Width :" + tempImage.getWidth());
        param.setTileSize(tempImage.getWidth(), tempImage.getHeight());


        TIFFImageEncoder encoder = (TIFFImageEncoder) TIFFCodec.createImageEncoder("tiff", out, param);
        encoder.encode(dec.decodeAsRenderedImage());

        out.close();


        System.out.println( "Hello World!" );

    }
}
