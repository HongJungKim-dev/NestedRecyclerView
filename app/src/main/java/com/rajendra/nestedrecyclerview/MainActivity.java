package com.rajendra.nestedrecyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.rajendra.nestedrecyclerview.adapter.MainRecyclerAdapter;
import com.rajendra.nestedrecyclerview.model.AllCategory;
import com.rajendra.nestedrecyclerview.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;
    Toolbar toolbar;
    ActionBar actionBar;
    Bitmap image;
    Bitmap resized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false); //기본 제목을 없애기
        actionBar.setDisplayHomeAsUpEnabled(true);


        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, R.drawable.cafe1));
        categoryItemList.add(new CategoryItem(1, R.drawable.food1));
        categoryItemList.add(new CategoryItem(1, R.drawable.cartoon1));


        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.cafe1));
        categoryItemList2.add(new CategoryItem(1, R.drawable.food1));
        categoryItemList2.add(new CategoryItem(1, R.drawable.cartoon1));

        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.cafe1));
        categoryItemList3.add(new CategoryItem(1, R.drawable.food1));
        categoryItemList3.add(new CategoryItem(1, R.drawable.cartoon1));

        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(1, R.drawable.cafe1));
        categoryItemList4.add(new CategoryItem(1, R.drawable.food1));
        categoryItemList4.add(new CategoryItem(1, R.drawable.cartoon1));

        List<CategoryItem> categoryItemList5 = new ArrayList<>();
        categoryItemList5.add(new CategoryItem(1, R.drawable.cafe1));
        categoryItemList5.add(new CategoryItem(1, R.drawable.food1));
        categoryItemList5.add(new CategoryItem(1, R.drawable.cartoon1));

        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("중구 북창동 코스", categoryItemList));
        allCategoryList.add(new AllCategory("중구 북창동 코스", categoryItemList2));
        allCategoryList.add(new AllCategory("종로구 익선동 코스", categoryItemList3));
        allCategoryList.add(new AllCategory("중구 복창동 코스", categoryItemList4));
        allCategoryList.add(new AllCategory("종로구 익선동 코스", categoryItemList5));

        setMainCategoryRecycler(allCategoryList);

    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){

        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
        mainCategoryRecycler.addItemDecoration(new RecyclerViewDecoration(60));

    }

    static public Bitmap resizeBitmap(Bitmap original) {

        int resizeWidth = 200;

        double aspectRatio = (double) original.getHeight() / (double) original.getWidth();
        int targetHeight = (int) (resizeWidth * aspectRatio);
        Bitmap result = Bitmap.createScaledBitmap(original, resizeWidth, targetHeight, false);
        if (result != original) {
            original.recycle();
        }
        return result;
    }
}
