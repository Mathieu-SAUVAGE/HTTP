package com.kyss;

import java.io.File;
import java.io.IOException;

/**
 * @author Mathieu SAUVAGE
 */
public class FileHelper {
    /**
     * Delete a directory.
     *
     * @param file The directory to delete.
     *
     * @return <code>true</code> if and only if the renaming succeeded, <code>false</code> otherwise.
     *
     * @throws NullPointerException If parameter <code>file</code> is <code>null</code>.
     */
    public static boolean delete(final File file) {
        if (!file.isDirectory()) {
            return file.delete();
        } else {
            boolean result = true;
            File[] children = file.listFiles();
            for (int i = 0; i < children.length; i++) {
                result = result && delete(children[i]);
                if (!result)
                    return false;
            }
            return result && file.delete();
        }
    }


    /**
     * Create the file and its complete path if necessary.
     * @param file File to create.
     *
     * @throws NullPointerException If parameter <code>file</code> is <code>null</code>.
     * @throws IOException          If an I/O error occurred
     * @throws SecurityException    If a security manager exists and its <code>{@link
     *                              java.lang.SecurityManager#checkWrite(java.lang.String)}</code>
     *                              method denies write access to the file
     */
    public static void createFile(final File file) throws IOException {
        if (file.isDirectory()) {
            file.createNewFile();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
    }
}
