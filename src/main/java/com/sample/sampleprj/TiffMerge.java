package com.sample.sampleprj;

import com.sun.media.jai.codec.*;


import javax.media.jai.NullOpImage;
import javax.media.jai.OpImage;
import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TiffMerge {

    public static void main(String[] args) throws IOException {
// 2 single page TIF to be in a multipage
        String [] tifs = {
                "C:/temp/testfile1.tif",
                "C:/temp/testfile2.tif"
        };
        int numTifs = tifs.length;  // 2 pages

        BufferedImage image[] = new BufferedImage[numTifs];
        for (int i = 0; i < numTifs; i++) {
            SeekableStream ss = new FileSeekableStream(tifs[i]);
            ImageDecoder decoder = ImageCodec.createImageDecoder("tiff", ss, null);
            PlanarImage pi = new NullOpImage
                    (decoder.decodeAsRenderedImage(0),null,null, OpImage.OP_IO_BOUND);
            image[i] = pi.getAsBufferedImage();
            ss.close();
        }

        TIFFEncodeParam params = new TIFFEncodeParam();
        params.setCompression(TIFFEncodeParam.COMPRESSION_DEFLATE);
        OutputStream out = new FileOutputStream("C:/temp/multipage.tif");
        ImageEncoder encoder = ImageCodec.createImageEncoder("tiff", out, params);
        List<BufferedImage> list = new ArrayList<BufferedImage>(image.length);
        for (int i = 1; i < image.length; i++) {
            list.add(image[i]);
        }
        params.setExtraImages(list.iterator());
        encoder.encode(image[0]);
        out.close();


        System.out.println("Done.");
        // 1. Merge files - JDK 13 DONE - JDK 8
        // 2. Scale to 1648 X 2338
        // 3. Compression to CCITT Group 4
        // cf buildpacks

    }
}
