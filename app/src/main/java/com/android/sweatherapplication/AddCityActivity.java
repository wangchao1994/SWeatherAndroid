package com.android.sweatherapplication;

import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sweatherapplication.event.CityListInfoEvent;
import com.android.sweatherapplication.event.SearchCityEvent;
import com.android.sweatherapplication.listener.MyRecItemListener;
import com.android.sweatherapplication.model.CityContent;
import com.android.sweatherapplication.model.SearchCityInfo;
import com.android.sweatherapplication.net.RetrofitApi;
import com.android.sweatherapplication.net.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AddCityActivity extends BaseActivity implements View.OnClickListener,TextWatcher{
    private EditText mEtSeachCity;
    private ImageView iv_delete;
    private RecyclerView mRecyclerView;
    private List<SearchCityInfo> mListCityName;
    private RecycleViewInfoAdapter recycleViewInfoAdapter;
    private int spacingInPixels = 18;

    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_add_city);
        initViewRes();
    }

    private void initViewRes() {
        mEtSeachCity = findViewById(R.id.et_city_name);
        iv_delete = findViewById(R.id.iv_delete);
        mRecyclerView = findViewById(R.id.rl_search_city);
        mEtSeachCity.addTextChangedListener(this);
        iv_delete.setOnClickListener(this);
    }

    @Override
    protected void initEventData() {
        mListCityName = new ArrayList<>();
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mSApplication);
        mRecyclerView.setLayoutManager(layoutManager);
        recycleViewInfoAdapter = new RecycleViewInfoAdapter();
        recycleViewInfoAdapter.setOnItemClickListener(new MyRecItemListener() {
            @Override
            public void ItemClick(View view, int position) {
                Toast.makeText(mSApplication,"postion name="+mListCityName.get(position).getWoeid(), Toast.LENGTH_SHORT).show();
                if (mListCityName != null && mListCityName.size() != 0){
                    EventBus.getDefault().postSticky(new SearchCityEvent(mListCityName.get(position).getWoeid()));
                    startActivity(new Intent(AddCityActivity.this,SearchCityActivity.class));
                }
            }
        });
        mRecyclerView.setAdapter(recycleViewInfoAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_delete:
                mEtSeachCity.setText("");
                mListCityName.clear();
                break;
        }
    }
    /**
     *INPUT CITYNAME AND SEARCH
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("wangchao","s====="+s.toString());
        Log.d("wangchao","mSApplication.getCurrentLocale()====="+mSApplication.getCurrentLocale());
        final String cityText = s.toString().trim();
        if (!"".equals(cityText)){
            mListCityName.clear();
            iv_delete.setVisibility(View.VISIBLE);
            EventBus.getDefault().post(new CityListInfoEvent(cityText));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCityListEvent(CityListInfoEvent cityListInfoEvent){
        String cityNameInfo = cityListInfoEvent.cityNameInfo;
        Log.d("wangchao","wangchao onCityListEvent=="+cityNameInfo);
        RetrofitHelper.getInstance().create(RetrofitApi.class,SWConfig.BASE_URL)
                .getCityListData("SELECT woeid,name,country,admin1,admin2,timezone FROM geo.places WHERE  text=\""+cityNameInfo+"\" and lang=\""+mSApplication.getCurrentLocale()+"\"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityContent>() {
                    @Override
                    public void onCompleted() {
                        Log.d("wangchao","wangchao onCompleted==");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("wangchao","wangchao exception=="+e.getMessage());
                    }

                    @Override
                    public void onNext(CityContent cityContent) {
                        CityContent.QueryBean.ResultsBean results = cityContent.getQuery().getResults();
                        if (results != null && results.getPlace() != null){
                            List<CityContent.QueryBean.ResultsBean.PlaceBean> place = results.getPlace();
                            Log.d("wangchao","list==="+place.size());
                            for (int i = 0 ;i<place.size();i++){
                                SearchCityInfo searchCityInfo = new SearchCityInfo();
                                searchCityInfo.setCityName(place.get(i).getName());
                                searchCityInfo.setWoeid(place.get(i).getWoeid());
                                mListCityName.add(searchCityInfo);
                            }
                            recycleViewInfoAdapter.notifyDataSetChanged();
                        }
                    }
                });

    }
    private class RecycleViewInfoAdapter extends RecyclerView.Adapter<RecycleViewInfoAdapter.ViewHolderInfo> {
        private MyRecItemListener myRecItemListener;
        /**
         * 设置Item点击监听
         * @param listener
         */
        public void setOnItemClickListener(MyRecItemListener listener){
            this.myRecItemListener = listener;
        }
        @NonNull
        @Override
        public RecycleViewInfoAdapter.ViewHolderInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,parent,false);
            RecycleViewInfoAdapter.ViewHolderInfo viewHolder = new RecycleViewInfoAdapter.ViewHolderInfo(view,myRecItemListener);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleViewInfoAdapter.ViewHolderInfo holder, int position) {
            ViewHolderInfo holderInfo = (ViewHolderInfo)holder;
            if (mListCityName!=null){
                Log.d("wangchao","mListCityName.get(position)==="+mListCityName.get(position));
                holderInfo.textView.setText(mListCityName.get(position).getCityName());
            }
        }

        @Override
        public int getItemCount() {
            return mListCityName == null ? 0 : mListCityName.size();
        }

        class ViewHolderInfo extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private MyRecItemListener myRecItemListener;

            public ViewHolderInfo(View itemView,MyRecItemListener myRecItemListener) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
                this.myRecItemListener = myRecItemListener;
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (myRecItemListener != null){
                    myRecItemListener.ItemClick(v,getAdapterPosition());
                }
            }
        }
    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }

    /**
     * 解析相关城市
     * @param result
     * @return
     */
    /*protected List<CityContent> parseCityInfo(String result) {
        XmlPullParser xmlParser = Xml.newPullParser();
        ByteArrayInputStream mByteArrayInputStream = null;
        if (result == null || TextUtils.isEmpty(result.trim())) {
            return null;
        } else {
            mByteArrayInputStream = new ByteArrayInputStream(result.getBytes());
            try {
                xmlParser.setInput(mByteArrayInputStream, "UTF-8");
                return parseXmlStream(xmlParser);
            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<CityContent> parseXmlStream(XmlPullParser xmlParser)
            throws XmlPullParserException, IOException {
        int evtType = xmlParser.getEventType();
        int count = 0;
        List<CityContent> cityInfoList = new ArrayList<>();
        CityContent cityInfo = null;
        String tag = null;
        while (evtType != XmlPullParser.END_DOCUMENT) {
            switch (evtType) {
                case XmlPullParser.START_TAG:
                    tag = xmlParser.getName();
                    if (tag.equals("query")) {
                        count = Integer.parseInt(xmlParser.getAttributeValue(0) .trim());
                        if (count == 0) {
                            return cityInfoList;
                        }
                    } else if (tag.equals("place")) {
                        cityInfo = new CityContent();
                    } else if (tag.equals("name")) {
                        cityInfo.setCityName(xmlParser.nextText());
                    } else if (tag.equals("country")) {
                        cityInfo.setCountry(xmlParser.nextText());
                    } else if (tag.equals("admin1")) {
                        cityInfo.setAdmin1(xmlParser.nextText());
                    } else if (tag.equals("admin2")) {
                        cityInfo.setAdmin2(xmlParser.nextText());
                    } else if (tag.equals("timezone")) {
                        cityInfo.setTimezone(xmlParser.nextText());
                    } else if (tag.equals("woeid")) {
                        cityInfo.setWoeid(xmlParser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    tag = xmlParser.getName();
                    if (tag.equals("place")) {
                        cityInfoList.add(cityInfo);
                        cityInfo = null;
                    }
                    break;

            }
            evtType = xmlParser.next();
        }
        return cityInfoList;
    }
*/
}
