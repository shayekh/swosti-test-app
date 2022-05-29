
package com.shayekh.swosti.member;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MemberResponse {

    @SerializedName("borrowerInfo")
    @Expose
    private List<BorrowerInfo> borrowerInfo = null;

    public List<BorrowerInfo> getBorrowerInfo() {
        return borrowerInfo;
    }

    public void setBorrowerInfo(List<BorrowerInfo> borrowerInfo) {
        this.borrowerInfo = borrowerInfo;
    }

}
