package com.example.dliu.shopping;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geminno.fragment.MainpageFragment;
import com.geminno.fragment.PersonCenterFragment;
import com.geminno.fragment.ShopingCartFragment;

public class MainActivity extends AppCompatActivity {

    Fragment[] fragments;
    MainpageFragment mainPageFragment;//主页
    ShopingCartFragment shopingCartFragment;//购物车
    PersonCenterFragment personCenterFragment ;//个人中心
    //按钮的数组，一开始第一个按钮被选中
    Button[] tabs;


    int oldIndex;//用户看到的item
    int newIndex;//用户即将看到的item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BP.init();
        System.out.println("111111111111");
        System.out.println("22222222222");
        //初始化fragment
        mainPageFragment=new MainpageFragment();
        shopingCartFragment=new ShopingCartFragment();
        personCenterFragment=new PersonCenterFragment();

        //所有fragment的数组
        fragments=new Fragment[]{mainPageFragment,shopingCartFragment,personCenterFragment};



        //设置按钮的数组
        tabs=new Button[3];
        tabs[0]=(Button) findViewById(R.id.btn_main_page);//主页的button
        tabs[1]=(Button) findViewById(R.id.btn_shoping_cart);//主页的button
        tabs[2]=(Button) findViewById(R.id.btn_person_center);//主页的button
        //界面初始显示第一个fragment;添加第一个fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragments[0]).commit();
        //初始时，按钮1选中
        tabs[0].setSelected(true);

    }

    //按钮的点击事件:选中不同的按钮，不同的fragment显示
    public void onTabClicked(View view) {

        //点击按钮时，表示选中不同的项
        switch(view.getId()){
            case R.id.btn_main_page:
                newIndex=0;//选中第一项
                break;

            case R.id.btn_shoping_cart:
                newIndex=1;//选中第二项
                break;
            case R.id.btn_person_center:
                newIndex=2;//选中第三项
                break;

        }
        FragmentTransaction transaction;
        //如果选择的项不是当前选中项，则替换；否则，不做操作
        if(newIndex!=oldIndex){

            transaction=getSupportFragmentManager().beginTransaction();

            transaction.hide(fragments[oldIndex]);//隐藏当前显示项


            //如果选中项没有加过，则添加
            if(!fragments[newIndex].isAdded()){
                //添加fragment
                transaction.add(R.id.fragment_container,fragments[newIndex]);
            }
            //显示当前选择项
            transaction.show(fragments[newIndex]).commit();
        }
        //之前选中的项，取消选中
        tabs[oldIndex].setSelected(false);
        //当前选择项，按钮被选中
        tabs[newIndex].setSelected(true);


        //当前选择项变为选中项
        oldIndex=newIndex;

    }
}
