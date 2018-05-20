
package com.example.android.ebtkartask.models.response;

import java.util.List;

public class Client {

    public String name;
    public String mobile;
    public int age;
    public List<Interest> interests = null;
    public List<Language> languages = null;


    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public List<Interest> getInterests() {
        return interests;
    }
}
