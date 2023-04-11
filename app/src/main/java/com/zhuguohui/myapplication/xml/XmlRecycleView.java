package com.zhuguohui.myapplication.xml;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhuguohui
 * Date: 2023/4/11
 * Time: 21:00
 * Desc:
 */
public class XmlRecycleView extends FrameLayout {

    private final RecyclerView recyclerView;

    public XmlRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(recyclerView);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if(child instanceof XmlRecycleViewItem){
            XmlRecycleViewItem item= (XmlRecycleViewItem) child;
            item.applyRecycleView(recyclerView);
            child.setVisibility(GONE);
        }


        super.addView(child, index, params);
    }




    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {

        return super.generateLayoutParams(p);
    }
}
