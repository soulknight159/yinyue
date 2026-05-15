package cn.itcast.yinyue.broadcast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class BroadcastDataHolder {
    private static final BroadcastDataHolder instance = new BroadcastDataHolder();
    private final MutableLiveData<String> receivedData = new MutableLiveData<>();

    public static BroadcastDataHolder getInstance() {
        return instance;
    }

    public LiveData<String> getReceivedData() {
        return receivedData;
    }

    public void setData(String data) {
        receivedData.setValue(data);
    }
}
