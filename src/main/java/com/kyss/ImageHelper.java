package com.kyss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Mathieu SAUVAGE
 */
public class ImageHelper {
    /**
     * The logger.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(ImageHelper.class);

    /**
     * Image's type supported.
     */
    public static enum IMAGE_EXTENSION {
        JPG, PNG
    }

    //<editor-fold desc="Write">

    /**
     * Write an image on a HDD. The file is represent by it's path construct with the <code>filename</code>, <code>name</code> and <code>type</code>.
     *
     * @param image     The image to store in a file.
     * @param storePath The path where the file will be write
     * @param filename  The PDF file name.
     * @param name      The name of the image to load.
     * @param type      The type of the image to load.
     *
     * @throws java.io.IOException if an error occurs during writing.
     */
    public static synchronized void write(final BufferedImage image, final String storePath, final String filename, final String name, final IMAGE_EXTENSION type) throws IOException {
        File output = new File(storePath + filename + File.separator + name + "." + type.toString().toLowerCase());

        write(image,
              output,
              type);
    }

    /**
     * Write an image on a HDD.
     *
     * @param image The image to store.
     * @param file  The file where the image is store.
     * @param type  The image's type for encoding the image.
     *
     * @throws IOException if an error occurs during writing.
     */
    public static synchronized void write(final BufferedImage image, final File file, final IMAGE_EXTENSION type) throws IOException {
        FileHelper.createFile(file);

        LOGGER.debug(String.format("Store image %s on hard disk : start...",
                                   file.getPath()));
        ImageIO.write(image,
                      type.toString(),
                      file);
        LOGGER.debug(String.format("Store image %s on hard disk : done!",
                                   file.getPath()));
    }
    //</editor-fold>

    //<editor-fold desc="Read">

    /**
     * Load a picture from a file store on the HDD. The file is represent by it's path construct with the <code>filename</code>, <code>name</code> and <code>type</code>.
     *
     * @param fileName  The PDF file name.
     * @param storePath The path where the file will be write
     * @param name      The name of the image to load.
     * @param type      The type of the image to load.
     *
     * @return A <code>BufferedImage</code> representing the image file.
     *
     * @throws IOException if an error occurs during reading.
     */
    public static synchronized BufferedImage read(final String storePath, final String fileName, final String name, final IMAGE_EXTENSION type) throws IOException {
        File input = new File(storePath + fileName + File.separator + name + "." + type.toString().toLowerCase());
        return read(input);
    }

    /**
     * Load a picture from a file store on the HDD.
     *
     * @param file The file to load.
     *
     * @return A <code>BufferedImage</code> representing the image file.
     *
     * @throws IOException if an error occurs during reading.
     */
    public static synchronized BufferedImage read(final File file) throws IOException {
        LOGGER.debug(String.format("Read image %s on hard disk : start...",
                                   file.getPath()));
        BufferedImage result = ImageIO.read(file);
        LOGGER.debug(String.format("Read image %s on hard disk : done!",
                                   file.getPath()));
        return result;
    }
    //</editor-fold>
}
