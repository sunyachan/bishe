package com.example.apple.jqjz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.activity.ComActivity;

/**
 * Created by apple on 16/12/30.
 */

public class ComLeftFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView lv_clm;
    Context context;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_left_menu, null);
        lv_clm= (ListView) view.findViewById(R.id.lv_clm);
        lv_clm.setAdapter(new MyAdapter(context));
        lv_clm.setOnItemClickListener(this);
        return view;
    }
//listview条目点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Fragment newFragment=null;
        String title=null;
        switch (i){
            case 0:
                newFragment=new HDFragment();
                title="装置晃电";
                break;
            case 1:
                newFragment=new LGPLFragment();
                title="分馏炉炉管破裂";
                break;
            case 2:
                newFragment=new TYBFFragment();
                title="停仪表风";
                break;
            case 3:
                newFragment=new FLTFragment();
                title="分馏塔塔底油泵泄漏着火";
                break;
            case 4:
                newFragment=new TXHSFragment();
                title="停循环水";
                break;
            case 5:
                newFragment=new FLT2Fragment();
                title="分馏塔人孔法兰泄漏";
                break;
            case 6:
                newFragment=new YLFragment();
                title="原料油罐着火";
                break;
            case 7:
                newFragment=new DCSFragment();
                title="DCS系统停电";
                break;
            case 8:
                newFragment=new FYFragment();
                title="反应器顶部法兰泄漏着火";
                break;
            case 9:
                newFragment=new RLFragment();
                title="燃料气中断";
                break;
        }
        if (newFragment!=null){
            //切换Fragment
            switchFragment(newFragment,title);
        }

    }
    //切换Fragment
    private void switchFragment(Fragment newFragment, String title) {
        if (getActivity()==null){
            return;
        }
        if (getActivity() instanceof ComActivity){
            ComActivity ma= (ComActivity) getActivity();
            ma.changeFragment(newFragment,title);
        }
    }

    class MyAdapter extends BaseAdapter{

        String[] data=new String[]{"装置晃电","分馏炉炉管破裂","停仪表风","分馏塔塔底油泵泄漏着火","停循环水",
        "分馏塔人孔法兰泄漏","原料油罐着火"," DCS系统停电","反应器顶部法兰泄漏着火","燃料气中断"};

        private Context context;
        public MyAdapter(Context context)
        {
            this.context = context;
        }



        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.com_lv_item, null);
            TextView tv= (TextView) view.findViewById(R.id.tv_com_item);
            tv.setText(data[i]);

            return view;
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
