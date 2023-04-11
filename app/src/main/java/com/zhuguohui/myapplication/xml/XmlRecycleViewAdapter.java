package com.zhuguohui.myapplication.xml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.drakeet.multitype.MultiTypeAdapter;
import com.zhuguohui.myapplication.BR;
import com.zhuguohui.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuguohui
 * Date: 2023/4/11
 * Time: 21:01
 * Desc:
 */
public class XmlRecycleViewAdapter extends FrameLayout implements XmlRecycleViewItem {

    private final MultiTypeAdapter adapter;

    public XmlRecycleViewAdapter(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        adapter = new MultiTypeAdapter();
       // TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        int layoutId= R.layout.layout_user_item;
        adapter.register(Object.class, new ItemViewBinder<Object, XmlViewHolder>() {
            @Override
            public void onBindViewHolder(@NonNull XmlViewHolder xmlViewHolder, Object o) {
                if(!isInEditMode()) {
                    xmlViewHolder.bind.setVariable(BR.item, o);
                }
            }

            @NonNull
            @Override
            public XmlViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
                View view = layoutInflater.inflate(layoutId, viewGroup, false);
                return new XmlViewHolder(view);
            }

        });
        if(isInEditMode()){
            List<Object> obj=new ArrayList<>();
            for(int i=0;i<10;i++){
                obj.add(new Object());
            }
            adapter.setItems(obj);
        }

    }

    private  class XmlViewHolder extends RecyclerView.ViewHolder{

        private  ViewDataBinding bind;

        public XmlViewHolder(@NonNull View itemView) {
            super(itemView);
            if(!isInEditMode()) {
                bind = DataBindingUtil.bind(itemView);
            }
        }
    }

    @BindingAdapter("app:data")
    public static void setAdapterData(XmlRecycleViewAdapter adapterView, List data) {
        Log.i("zzz", "setAdapterData: ");
       adapterView.setData(data);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List data){
        Log.i("zzz", "setData: ");
        adapter.setItems(data);

    }





    @Override
    public void applyRecycleView(RecyclerView recycleView) {
        Log.i("zzz", "applyRecycleView: ");
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


}
