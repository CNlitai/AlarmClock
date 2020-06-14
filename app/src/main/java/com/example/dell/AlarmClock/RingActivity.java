package com.example.dell.AlarmClock;


import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author created by 惠普
 * @package name com.example.dell.AlarmClock
 * @date created on 2020/6/13
 * @description
 */

public class RingActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<Ringtone> mRingtoneArrayList = new ArrayList<>();
    private TextView mRing_textView;


    private String[] mName_String;
    private String mName;
    int size = mRingtoneArrayList.size();

    void init(){

        RingtoneManager ringtoneManager= new RingtoneManager(this); // 铃声管理器
        Cursor cursor = ringtoneManager.getCursor(); //获取铃声表,根据表名取值
        int count = cursor.getCount(); //获取铃声列表数量

        for(int i = 0 ; i < count ; i ++){
            mRingtoneArrayList.add(ringtoneManager.getRingtone(i));
        }

        for (int j = 0 ; j < count ; j++) {
            mName = mRingtoneArrayList.get(j).getTitle(RingActivity.this);
            mName_String = mRingtoneArrayList.toArray(new String[size]);
            for (int k = 0; k < mName_String.length; k++){
                mRing_textView.setText(mName_String.toString());
            }


            //System.out.println(mName);

        }
        //System.out.println(mName);

        mRing_textView = findViewById(R.id.ring_tv);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
        ListView List_ring = findViewById(R.id.list_ring);


        RingAdapter ringAdapter = new RingAdapter();
        List_ring.setAdapter(ringAdapter);

       // List_ring.setOnItemClickListener(this.);

        init();

        //mRing_textView.setText(mRingtoneArrayList.toString());

    }
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {

            }
        }

    };
    @Override
    public void onClick(View view) {

    }

    //重写adapter
    class RingAdapter extends BaseAdapter{






        public int getCount() {
            return mRingtoneArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView ==null ) {

                LayoutInflater inflater = RingActivity.this.getLayoutInflater();
                view = inflater.inflate(R.layout.list_item, null);
            }

            else {
                view = convertView;
            }

            mRing_textView = findViewById(R.id.ring_tv);

            //mRing_textView.setText(mRingtoneArrayList);
            //mRing_textView.setText(mRingtoneArrayList.toString());

            return view;
        }




    }


}
