package com.hh.waylightclient;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.hh.waylightclient.Fragment.BaseFragmentForHome;
import com.hh.waylightclient.Fragment.EventFragment;
import com.hh.waylightclient.Fragment.MapFragment;
import com.hh.waylightclient.Fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RadioGroup mRg_main;
    private List<BaseFragmentForHome> mBaseFragment; //集合

    /**
     * 选中的Fragment的对应的位置
     */
    private int position;

    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中框架页面
        mRg_main.check(R.id.rd_map);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rd_map:
                    position = 0;
                    break;
                case R.id.rd_event:
                    position = 1;
                    break;
                case R.id.rd_msg:
                    position = 2;
                    break;
                case R.id.rd_people:
                    position = 3;
                    break;
                default: //默认第一个
                    position = 0;
                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragmentForHome to = getFragment();
            //替换到Fragment
            switchFrament(mContent,to);
        }
    }

    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to 马上要切换到的Fragment，一会要显示
     */
    private void switchFrament(Fragment from,Fragment to) {
        if(from != to){ //才切换
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //开启事务
            //判断to有没有被添加
            if(!to.isAdded()){//to没有被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.添加to
                if(to != null){
                    ft.add(R.id.fmlayout,to).commit();
                }
            }else{ //to已经被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }
    }

    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragmentForHome getFragment() {
        BaseFragmentForHome fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new MapFragment());//MapFragment
        mBaseFragment.add(new EventFragment());//
        mBaseFragment.add(new MapFragment());//todo
        mBaseFragment.add(new MessageFragment());//
    }

    private void initView() {
        setContentView(R.layout.activity_home);
        mRg_main = (RadioGroup) findViewById(R.id.rd_group);
    }
}
