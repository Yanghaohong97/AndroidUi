package com.cvte.androidui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.cvte.androidui.util.RealPathFromUriUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class GlideActivity extends AppCompatActivity {
    private static final String TAG = "GlideActivity";
    private TextView mTextViewGlide1, mTextViewGlide2, mTextViewGlide3, mTextViewGlide4, mTextViewGlide5, mTextViewGlide6, mTextViewGlide7, mTextViewGlide8, mTextViewGlide9;
    private ImageView mImageViewGlide1, mImageViewGlide2, mImageViewGlide3, mImageViewGlide4, mImageViewGlide5, mImageViewGlide6, mImageViewGlide7, mImageViewGlide8, mImageViewGlide9;

    String[] mPermissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final int REQUEST_PICK_IMAGE = 11101;
    private String realPathFromUri;
    private Uri pictureUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        mTextViewGlide1 = findViewById(R.id.tv_glide1);
        mTextViewGlide2 = findViewById(R.id.tv_glide2);
        mTextViewGlide3 = findViewById(R.id.tv_glide3);
        mTextViewGlide4 = findViewById(R.id.tv_glide4);
        mTextViewGlide5 = findViewById(R.id.tv_glide5);
        mTextViewGlide6 = findViewById(R.id.tv_glide6);
        mTextViewGlide7 = findViewById(R.id.tv_glide7);
        mTextViewGlide8 = findViewById(R.id.tv_glide8);
        mTextViewGlide9 = findViewById(R.id.tv_glide9);

        mImageViewGlide1 = findViewById(R.id.iv_glide1);
        mImageViewGlide2 = findViewById(R.id.iv_glide2);
        mImageViewGlide3 = findViewById(R.id.iv_glide3);
        mImageViewGlide4 = findViewById(R.id.iv_glide4);
        mImageViewGlide5 = findViewById(R.id.iv_glide5);
        mImageViewGlide6 = findViewById(R.id.iv_glide6);
        mImageViewGlide7 = findViewById(R.id.iv_glide7);
        mImageViewGlide8 = findViewById(R.id.iv_glide8);
        mImageViewGlide9 = findViewById(R.id.iv_glide9);


        ActivityCompat.requestPermissions(GlideActivity.this, mPermissionList, 100);
    }

    private void loadImage() {
        //加载网络图片
        mTextViewGlide1.setText("加载网络图片");
        Glide.with(this)
                .load("https://wx4.sinaimg.cn/mw690/7944ffc4ly1fixi692jkqj22g53o7u10.jpg\n")
                .into(mImageViewGlide1);

        //加载资源图片
        mTextViewGlide2.setText("加载资源图片");
        Glide.with(this).load(R.drawable.ic_launcher_background).into(mImageViewGlide2);

        //加载本地图片
        mTextViewGlide3.setText("加载本地图片");
//        String path = realPathFromUri;
//        Log.d(TAG, "loadImage: path = " + path);
//        File file = new File(path);
//        Uri uri = Uri.fromFile(file);
//        Glide.with(this).load(uri).into(mImageViewGlide3);

        //加载网络gif
        mTextViewGlide4.setText("加载网络gif");
        String gif = "http://b.hiphotos.baidu.com/zhidao/pic/item/faedab64034f78f066abccc57b310a55b3191c67.jpg";
        Glide.with(this).load(gif).placeholder(R.drawable.bg_iron_man).into(mImageViewGlide4);

        //加载资源gif
        mTextViewGlide5.setText("加载资源gif");
        Glide.with(this).load(R.drawable.loading)
                .placeholder(R.drawable.bg_iron_man)
                .into(mImageViewGlide5);

        //加载本地gif
        mTextViewGlide6.setText("加载本地gif");
        String gifPath = Environment.getExternalStorageDirectory()+"/Pictures/yellowman.gif";
        File gifFile = new File(gifPath);
        Glide.with(this).load(gifFile).placeholder(R.drawable.bg_iron_man).into(mImageViewGlide6);

        //（7）加载本地小视频和快照
        mTextViewGlide7.setText("加载本地小视频和快照");
        String videoPath = Environment.getExternalStorageDirectory() + "/Pictures/杨梅坑/video.mp4";
        File videoFile = new File(videoPath);
        Glide.with(this).load(Uri.fromFile(videoFile)).placeholder(R.mipmap.ic_launcher).into(mImageViewGlide7);

        //（8）设置缩略图比例,然后，先加载缩略图，再加载原图
        mTextViewGlide8.setText("设置缩略图比例,然后，先加载缩略图，再加载原图");
        String urlPath = Environment.getExternalStorageDirectory() + "/Pictures/杨梅坑/background.jpg";
//        Glide.with(this).load(new File(urlPath)).thumbnail(0.1f)
//                .centerCrop().placeholder(R.mipmap.ic_launcher)
//                .into(mImageViewGlide8);

        Glide.with(this).load(pictureUri).thumbnail(0.1f)
                .centerCrop().placeholder(R.mipmap.ic_launcher)
                .into(mImageViewGlide8);

        //（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图
        mTextViewGlide9.setText("先建立一个缩略图对象，然后，先加载缩略图，再加载原图");
        RequestBuilder<Drawable> requestManager = Glide.with(this).load(new File(urlPath));
        Glide.with(this).load(Uri.fromFile(videoFile))
                .thumbnail(requestManager).centerCrop()
                .placeholder(R.mipmap.ic_launcher).into(mImageViewGlide9);
    }

    public String getImagePathFromURI(Uri uri) {
        Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);
        String path = null;
        if (cursor != null) {
            cursor.moveToFirst();
            String document_id = cursor.getString(0);
            document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
            cursor.close();
            cursor = this.getContentResolver().query(
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
            if (cursor != null) {
                cursor.moveToFirst();
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                cursor.close();
            }
        }
        Log.d(TAG, "getImagePathFromURI: path="+path);
        return path;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                boolean writeExternalStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readExternalStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (grantResults.length > 0 && writeExternalStorage && readExternalStorage) {
                    getImage();
                } else {
                    Toast.makeText(this, "请设置必要权限", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void getImage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"),
                    REQUEST_PICK_IMAGE);
        } else {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_PICK_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_PICK_IMAGE:
                    if (data != null) {
                        pictureUri = data.getData();
                        realPathFromUri = RealPathFromUriUtils.getRealPathFromUri(this, pictureUri);
                        Log.d(TAG, "onActivityResult: realPathFromUri="+realPathFromUri);
                        ContentResolver cr = this.getContentResolver();
                        try {
                            Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(pictureUri));
                            mImageViewGlide3.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        loadImage();
                    } else {
                        Toast.makeText(this, "图片损坏，请重新选择", Toast.LENGTH_SHORT).show();
                    }

                    break;
            }
        }
    }

}