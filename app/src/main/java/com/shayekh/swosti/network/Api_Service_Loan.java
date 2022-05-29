package com.shayekh.swosti.network;

import com.shayekh.swosti.loan.LoanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Service_Loan {
    @GET("sms/collectionSheet.json")
    Call<LoanResponse> getInfoLoan();
}
