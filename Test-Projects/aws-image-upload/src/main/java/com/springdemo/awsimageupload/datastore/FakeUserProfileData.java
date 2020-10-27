package com.springdemo.awsimageupload.datastore;

import com.springdemo.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileData {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("7f244b88-31bb-4824-a1ea-2a084e2bdc93"), "Niels Fokkink", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("47b295a5-cf55-43d7-b295-7d6ff22f5d59"), "Brak Obama", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
