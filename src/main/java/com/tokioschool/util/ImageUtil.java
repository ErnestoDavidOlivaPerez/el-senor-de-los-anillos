package com.tokioschool.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageUtil {

    public static ImageView getImageView(String url)  throws IOException {
        FileInputStream file = new FileInputStream("imagen" + File.separator + url);
        Image image = new Image(file);
        return new ImageView(image);
    }

    public static Image getImage(String url)  throws IOException {
        FileInputStream file = new FileInputStream("imagen" + File.separator + url);
        return new Image(file);
    }
}
