package com.example.rawda.prettychat.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.opengl.Matrix;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ImageUtil {
    private byte[] img_bytes;
    private ImageView imageView;
    private Context context;

    public ImageUtil(Context context) {
        this.context = context;
    }

    public byte[] getByteArray(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        img_bytes = byteArrayOutputStream.toByteArray();
        return img_bytes;
    }
    public ImageView getImageView(byte[] bytes){
        imageView = new ImageView(context);
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bmp);
        return imageView;

    }
}
