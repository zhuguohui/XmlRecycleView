package com.zhuguohui.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.zhuguohui.myapplication.bean.User;
import com.zhuguohui.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<User> users=new ArrayList<>();
    static {
        users.add(new User("张三",20));
        users.add(new User("李四",21));
        users.add(new User("王五",22));
        users.add(new User("老六",23));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        com.zhuguohui.myapplication.databinding.ActivityMainBinding.in;
        ActivityMainBinding binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.setData(users);
    }

}