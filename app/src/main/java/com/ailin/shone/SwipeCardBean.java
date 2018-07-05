package com.ailin.shone;

import java.util.ArrayList;
import java.util.List;

public class SwipeCardBean {
    private int postition;
    private String url;
    private String name;

    public SwipeCardBean(int postition, String url, String name) {
        this.postition = postition;
        this.url = url;
        this.name = name;
    }

    public int getPostition() {
        return postition;
    }

    public SwipeCardBean setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SwipeCardBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public SwipeCardBean setName(String name) {
        this.name = name;
        return this;
    }

    public static List<SwipeCardBean> initDatas() {
        List<SwipeCardBean> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155117_8i4Rk.thumb.700_0.jpeg", "美女1"));
        datas.add(new SwipeCardBean(i++, "http://cdnq.duitang.com/uploads/item/201505/04/20150504155014_irFvu.thumb.700_0.jpeg", "美女2"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg", "美女3"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155137_JWcRK.thumb.700_0.jpeg", "美女4"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155036_zNrPT.thumb.700_0.jpeg", "美女5"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201504/26/201504262026_weMcT.thumb.700_0.jpeg", "美女6"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201504/26/201504261920_HsSm3.thumb.700_0.jpeg", "美女7"));
        datas.add(new SwipeCardBean(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg","美女8"));
        datas.add(new SwipeCardBean(i++, "http://pic106.huitu.com/res/20180517/257064_20180517174104205030_1.jpg","美女9"));
        datas.add(new SwipeCardBean(i++, "http://pic16.huitu.com/res/20140113/257064_20140113193316127139_1.jpg","美女10"));
        datas.add(new SwipeCardBean(i++, "http://pic112.nipic.com/file/20161019/24090163_192329983039_2.jpg","美女11"));
        return datas;
    }
}
