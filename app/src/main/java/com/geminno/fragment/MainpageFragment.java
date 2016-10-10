package com.geminno.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dliu.entity.Product;
import com.example.dliu.shopping.R;
import com.example.dliu.util.CommonAdapter;
import com.example.dliu.util.NetUtil;
import com.example.dliu.util.ViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dliu on 2016/9/30.
 */
public class MainpageFragment extends BaseFragment {

    @InjectView(R.id.query)
    EditText query;
    @InjectView(R.id.search_clear)
    ImageButton searchClear;
    @InjectView(R.id.tv_search)
    TextView tvSearch;
    @InjectView(R.id.id_prod_list_sort_left)
    TextView idProdListSortLeft;
    @InjectView(R.id.prod_list_rl_pop)
    RelativeLayout prodListRlPop;
    @InjectView(R.id.id_prod_list_sort_right)
    TextView idProdListSortRight;
    @InjectView(R.id.id_prod_list_sort_right_trangle)
    ImageView idProdListSortRightTrangle;
    @InjectView(R.id.prod_list_pop_two)
    RelativeLayout prodListPopTwo;
    @InjectView(R.id.id_prod_list_sort)
    LinearLayout idProdListSort;
    @InjectView(R.id.id_prod_list_sort_line1)
    View idProdListSortLine1;
    @InjectView(R.id.lv_goods)
    ListView lvGoods;


    //商品名称
    String productName;
    int orderFlag=0;
    int pageNo=1;
    int pageSize=5;

    CommonAdapter<Product> goodsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, null);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

        getData();//获取网络数据，显示在listview上

    }


    //获取网络数据
    public void getData(){
        //界面初始化数据：listview显示数据
        //xutils获取网络数据

        String url= NetUtil.url+"QueryProductServlet";//访问网络的url
        RequestParams requestParams=new RequestParams(url);
        requestParams.addQueryStringParameter("productName",productName);
        requestParams.addQueryStringParameter("orderFlag",orderFlag+"");//排序标记
        requestParams.addQueryStringParameter("pageNo",pageNo+"");
        requestParams.addQueryStringParameter("pageSize",pageSize+"");


        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("MainpageFragment", "onSuccess: "+result);
                //json转换成List<Product>
                Gson gson=new Gson();
                Type type=new TypeToken<List<Product>>(){}.getType();
                List<Product> products=gson.fromJson(result,type);//解析成List<Product>

                //设置listview的apter
                if(goodsAdapter==null){
                    goodsAdapter=new CommonAdapter<Product>(getActivity(),products,R.layout.prod_list_item) {
                        @Override
                        public void convert(ViewHolder viewHolder, Product product, int position) {
                            //取出控件，赋值
                          TextView tv= viewHolder.getViewById(R.id.prod_list_item_tv);
                            tv.setText(product.getName());//商品名称

                            TextView tvPrice=viewHolder.getViewById(R.id.prod_list_item_tv2);
                            tvPrice.setText("￥"+product.getPrice());
                            //其他控件赋值

                        }
                    };

                    lvGoods.setAdapter(goodsAdapter);
                }else{
                    goodsAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_search, R.id.id_prod_list_sort_left, R.id.id_prod_list_sort_right,R.id.search_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                break;
            case R.id.id_prod_list_sort_left:
                break;
            case R.id.id_prod_list_sort_right:
                break;
            case R.id.search_clear:
                break;
        }
    }
}
