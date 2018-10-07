package com.ifpb.infra;

/**
 *
 * @author jonas
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileManagement {

    private static final String PATHNAME = "./";

    public static String encodeFile(File file) throws IOException {

        byte[] bytes = new byte[(int)file.length()];
        new FileInputStream(file).read(bytes);

        String fileBase64 = Base64.getEncoder().encodeToString(bytes);
        return fileBase64;
    }

    public static File decodeFile(String fileBase64) throws IOException {

        byte[] fileBytes = Base64.getDecoder().decode(fileBase64);

        FileOutputStream fileOutputStream = new FileOutputStream(PATHNAME + fileBase64.hashCode());
        fileOutputStream.write(fileBytes);

        File file = new File(PATHNAME + fileBase64.hashCode());
        return file;
    }
}