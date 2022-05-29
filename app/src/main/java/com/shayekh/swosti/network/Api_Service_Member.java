package com.shayekh.swosti.network;

import com.shayekh.swosti.member.MemberResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Service_Member {
    @GET("sms/memberInfo.json")
    Call<MemberResponse> getInfo();
}
