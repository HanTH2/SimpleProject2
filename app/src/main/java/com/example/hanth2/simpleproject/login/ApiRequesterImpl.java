package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.dagger.Injector;

import rx.Observable;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class ApiRequesterImpl implements ApiRequester {

    public ApiRequesterImpl(){
        Injector.INSTANCE.inject(this);
    }

    @Override
    public Observable<LoginDto> login(String username, String password) {
        LoginDto dto = new LoginDto();
        // Case 1
        dto.username = username;
        dto.password = password;
        dto.deviceid = "htc";
        dto.token = "adsfasdfasdfasdfasfs";
        dto.errorcode = 0; // Success
        return Observable.just(dto);
    }
}
