package com.shayekh.swosti;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shayekh.swosti.adapter.LoanAdapter;
import com.shayekh.swosti.adapter.MemberAdapter;
import com.shayekh.swosti.loan.LoanResponse;
import com.shayekh.swosti.member.MemberResponse;
import com.shayekh.swosti.network.Api_Response_Loan;
import com.shayekh.swosti.network.Api_Response_Member;
import com.shayekh.swosti.network.Api_Service_Loan;
import com.shayekh.swosti.network.Api_Service_Member;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Api_Service_Member service;
    private Api_Service_Loan serviceLoan;
    RecyclerView recyclerView,recyclerView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = Api_Response_Member.getUser().create(Api_Service_Member.class);
        serviceLoan = Api_Response_Loan.getUser().create(Api_Service_Loan.class);
        recyclerView = (RecyclerView) findViewById(R.id.memberListRecycle);
        recyclerView1 = (RecyclerView) findViewById(R.id.loanListRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
        getLoan();
    }

    private void getLoan() {

      Call<LoanResponse> result = serviceLoan.getInfoLoan();
      result.enqueue(new Callback<LoanResponse>() {
          @Override
          public void onResponse(Call<LoanResponse> call, Response<LoanResponse> response) {
              LoanResponse list1 = response.body();
              LoanAdapter adapter1 = new LoanAdapter(MainActivity.this,list1.getCollectionSheetBean());
              recyclerView1.setAdapter(adapter1);

          }

          @Override
          public void onFailure(Call<LoanResponse> call, Throwable t) {

          }
      });
    }

    private void getData() {
        Call<MemberResponse> res = service.getInfo();
        res.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                MemberResponse list=response.body();
//                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                MemberAdapter adapter = new MemberAdapter(MainActivity.this, list.getBorrowerInfo());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {

            }
        });
    }
}