package com.example.linphonesample.model;

import com.blankj.utilcode.util.StringUtils;
import com.feige.init.base.BaseViewModel;
import com.feige.init.bean.CallVoiceDto;
import com.feige.init.bean.PhoneBelong;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

public class CallViewModel extends BaseViewModel {
    public Flowable<PhoneBelong> placeOwnership(String phone, String contactId) {
        Map<String, Object> map = new HashMap<>();
        map.put("calledNumber", phone);
        if (!StringUtils.isTrimEmpty(contactId)) {
            map.put("contactId", contactId);
        }
        return unWrapReponseFlowable(getApiService().placeOwnership(handlerRequestData(map)));
    }

    public Flowable<CallVoiceDto> voiceCall(String customerId, String contactId, String calledNumber) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isTrimEmpty(customerId)) {
            map.put("customerId", customerId);
        }
        map.put("calledNumber", calledNumber);
        if (!StringUtils.isTrimEmpty(contactId)) {
            map.put("contactId", contactId);
        }
        return unWrapReponseFlowable(getApiService().voiceCall(handlerRequestData(map)));
    }
}
