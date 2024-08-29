package com.haibing.mvvm.bases;

import com.haibing.mvvm.bases.ui.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 王小军
 * @date 2024/03/08
 */
public class ActivityManagerImpl implements IActivityManager {
    private Map<String, List<BaseActivity>> activityMap = new HashMap<>();
    private ActivityManagerImpl() {}
    private static ActivityManagerImpl INSTANCE = null;
    public static ActivityManagerImpl newInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ActivityManagerImpl();
        }
        return INSTANCE;
    }

    @Override
    public void add(BaseActivity baseActivity) {
        String key = baseActivity.getClass().getName();
        if(activityMap.containsKey(key)) {
            activityMap.get(key).add(baseActivity);
        } else {
            List<BaseActivity> list = new ArrayList<>();
            list.add(baseActivity);
            activityMap.put(key,list);
        }
    }

    @Override
    public void remove(BaseActivity baseActivity) {
        String key = baseActivity.getClass().getName();
        if(activityMap.containsKey(key)) {
            List<BaseActivity> list = activityMap.get(key);
            if(list != null && !list.isEmpty()) {
                list.remove(baseActivity);
                if(list.isEmpty()) {
                    activityMap.remove(key);
                }
            }
        }
    }

    @Override
    public void finishAll() {
        if(activityMap.entrySet() != null) {
            Iterator<Map.Entry<String,List<BaseActivity>>> it = activityMap.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<String,List<BaseActivity>> entry = it.next();
                List<BaseActivity> list = entry.getValue();
                if(list != null && !list.isEmpty()) {
                    for(BaseActivity baseActivity : list) {
                        if(baseActivity != null) {
                            baseActivity.finish();
                        }
                    }
                }
            }
        }
    }
}
