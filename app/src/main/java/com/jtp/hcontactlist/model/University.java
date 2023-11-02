package com.jtp.hcontactlist.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University {

@SerializedName("state-province")
@Expose
private String stateProvince;
@SerializedName("country")
@Expose
private String country;
@SerializedName("domains")
@Expose
private List<String> domains;
@SerializedName("web_pages")
@Expose
private List<String> webPages;
@SerializedName("alpha_two_code")
@Expose
private String alphaTwoCode;
@SerializedName("name")
@Expose
private String name;

public String getStateProvince() {
return stateProvince;
}

public void setStateProvince(String  stateProvince) {
this.stateProvince = stateProvince;
}

public String getCountry() {
    Log.d("Message aa","line no Univercity 40");
    return country;
}

public void setCountry(String country) {
this.country = country;
}

public List<String> getDomains() {
return domains;
}

public void setDomains(List<String> domains) {
this.domains = domains;
}

public List<String> getWebPages() {
return webPages;
}

public void setWebPages(List<String> webPages) {
this.webPages = webPages;
}

public String getAlphaTwoCode() {
return alphaTwoCode;
}

public void setAlphaTwoCode(String alphaTwoCode) {
this.alphaTwoCode = alphaTwoCode;
}

public String getName() {
    Log.d("Message aa","line no Adapter 73");
    return name;
}

public void setName(String name) {
this.name = name;
}

}