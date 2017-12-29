package com.xb.powerplatform.dailyinspection.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SelectPhoto.ImagesSelectorActivity;
import com.xb.powerplatform.SelectPhoto.SelectorSettings;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DailyInpectionAddActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.sp1)
    Spinner sp1;
    @Bind(R.id.sp2)
    Spinner sp2;
    @Bind(R.id.sp3)
    Spinner sp3;
    @Bind(R.id.tvReson)
    EditText tvReson;
    @Bind(R.id.tvReson1)
    EditText tvReson1;
    @Bind(R.id.etWhy)
    EditText etWhy;
    @Bind(R.id.etNum)
    EditText etNum;
    @Bind(R.id.etPer)
    EditText etPer;
    @Bind(R.id.iv1)
    ImageView iv1;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.iv3)
    ImageView iv3;
    @Bind(R.id.btn)
    Button btn;
    File tmpDir;
    File tmpDir1;
    File tmpDir2;
    int mo = 0;
    private ArrayList<String> mResults = new ArrayList<>();
    String tvsp1, tvsp2, tvsp3;
    private static final int REQUEST_CODE = 732;
    private static final String[] qudui = {"区队", " 1区 ", " 2区 ", " 3区 ", " 4区 ", " 5区 "};
    private static final String[] banzu = {"班组", " 1班 ", " 2班 ", " 3班 ", " 4班 ", " 5班 "};
    private static final String[] geren = {"个人", " 张三 ", " 李四 ", " 小明 ", " 小王 ", " 孙思 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, qudui);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, banzu);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, geren);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);
        sp3.setAdapter(adapter3);
        getData();
        setClient();
    }

    //spinner选项
    private void setClient() {
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvsp1 = qudui[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvsp2 = banzu[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvsp3 = geren[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getData() {
//        helper = DbManager.getInstance1(MyWorkCheckActivity.this);
//        SQLiteDatabase db = helper.getReadableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("context", "采煤工作面面前检修或施工，未将本支架及施工处上下相邻支架主进液管路截止阀关闭的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "出现空载支架的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面架间距离超过规定且造成架间漏矸严重的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面面后部悬顶距离超过作业规程规定，未采取强制放顶或加强支护措施的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "采煤工作面两顺槽人行路宽度不符合要求的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "皮带机头、工作面转载机头、转载机尾处及工作面每隔15m、皮带巷每隔100m未按规定安装闭锁扩音组合电话的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "采煤工作面上下出口单体支柱拖后放顶线0.8m未回撤，或回撤后未支密集支柱的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "当巷道煤帮与液压支架侧护梁边缘空顶距间隙大于《规程》规定距离后，未应及时支设切顶密集支柱及贴帮柱加强支护的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面俯采期间，两端头支架未采取防前倾措施的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "顶板下沉严重未采取措施加强支护的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面回采时任意留顶煤或撇底煤的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "沿空回采时，沿空侧支设超前木柱不符合《规程》规定的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "两顺槽超前支护长度小于措施规定要求的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面安装、初次放顶、收尾、回撤、过地质构造带、过老巷无专项措施的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.put("context", "工作面安全出口不畅通、不能保证两个安全出口的；或影响水平和采区通风、行人安全的");
//        values.put("num", "一");
//        values.put("money", "一百");
//        db.insert(Constant.TABBLE_NAME1, null, values);
//
//        values.clear();
//        db.close();
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dailyinpection_add;
    }

    //是否显示头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }

    //头部右侧点击事件
    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.iv1, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv1:
                Intent intent = new Intent(DailyInpectionAddActivity.this, ImagesSelectorActivity.class);
                // max number of images to be selected
                intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 3);
                // min size of image which will be shown; to filter tiny images (mainly icons)
                intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                // show camera or not
                intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                // pass current selected images as the initial value
                // start the selector
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.btn:
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                assert mResults != null;

                // show results in textview
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
                for (String result : mResults) {
                    sb.append(result).append("\n");
                }
            }
        }
        if (mResults.size() == 1) {
            int degree = readPictureDegree(mResults.get(0));
            BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts.inSampleSize = 2;
            Bitmap cbitmap = BitmapFactory.decodeFile(mResults.get(0), opts);
            Bitmap newbitmap = rotaingImageView(degree, cbitmap);
            iv1.setImageBitmap(newbitmap);
            //addiv.setImageBitmap(BitmapFactory.decodeFile(mResults.get(0)));
            saveBitmap(BitmapFactory.decodeFile(mResults.get(0)), "temp");
        }
        if (mResults.size() == 2) {
            int degree = readPictureDegree(mResults.get(0));
            BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts.inSampleSize = 2;
            Bitmap cbitmap = BitmapFactory.decodeFile(mResults.get(0), opts);
            Bitmap newbitmap = rotaingImageView(degree, cbitmap);
            iv1.setImageBitmap(newbitmap);
            iv2.setVisibility(View.VISIBLE);
            int degree1 = readPictureDegree(mResults.get(1));
            BitmapFactory.Options opts1 = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts1.inSampleSize = 2;
            Bitmap cbitmap1 = BitmapFactory.decodeFile(mResults.get(1), opts1);
            Bitmap newbitmap1 = rotaingImageView(degree1, cbitmap1);
            iv2.setImageBitmap(newbitmap1);
            saveBitmap(BitmapFactory.decodeFile(mResults.get(0)), "temp");
            saveBitmap1(BitmapFactory.decodeFile(mResults.get(1)), "temp");
        }
        if (mResults.size() == 3) {
            int degree = readPictureDegree(mResults.get(0));
            BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts.inSampleSize = 2;
            Bitmap cbitmap = BitmapFactory.decodeFile(mResults.get(0), opts);
            Bitmap newbitmap = rotaingImageView(degree, cbitmap);
            iv1.setImageBitmap(newbitmap);
            iv2.setVisibility(View.VISIBLE);
            int degree1 = readPictureDegree(mResults.get(1));
            BitmapFactory.Options opts1 = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts1.inSampleSize = 2;
            Bitmap cbitmap1 = BitmapFactory.decodeFile(mResults.get(1), opts1);
            Bitmap newbitmap1 = rotaingImageView(degree1, cbitmap1);
            iv2.setImageBitmap(newbitmap1);
            iv3.setVisibility(View.VISIBLE);
            int degree2 = readPictureDegree(mResults.get(2));
            BitmapFactory.Options opts2 = new BitmapFactory.Options();//获取缩略图显示到屏幕上
            opts2.inSampleSize = 2;
            Bitmap cbitmap2 = BitmapFactory.decodeFile(mResults.get(2), opts2);
            Bitmap newbitmap2 = rotaingImageView(degree2, cbitmap2);
            iv3.setImageBitmap(newbitmap2);
            saveBitmap(BitmapFactory.decodeFile(mResults.get(0)), "temp");
            saveBitmap1(BitmapFactory.decodeFile(mResults.get(1)), "temp");
            saveBitmap2(BitmapFactory.decodeFile(mResults.get(2)), "temp");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     *
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
        //旋转图片 动作
        Matrix matrix = new Matrix();
        ;
        matrix.postRotate(angle);
        System.out.println("angle2=" + angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    /**
     * 将Bitmap写入SD卡中的一个文件中,并返回写入文件的Uri
     *
     * @param bm
     * @param dirPath
     * @return
     */
    private Uri saveBitmap(Bitmap bm, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath() + "/avator.png" + mo);
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm.compress(Bitmap.CompressFormat.JPEG, 65, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Uri saveBitmap1(Bitmap bm, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir1 = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir1.exists()) {
            tmpDir1.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir1.getAbsolutePath() + "/avator1.png" + mo + mo);
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm.compress(Bitmap.CompressFormat.JPEG, 65, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Uri saveBitmap2(Bitmap bm, String dirPath) {    //新建文件夹用于存放裁剪后的图片
        tmpDir2 = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir2.exists()) {
            tmpDir2.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir2.getAbsolutePath() + "/avator2.png" + mo + mo + mo);
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm.compress(Bitmap.CompressFormat.JPEG, 65, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
