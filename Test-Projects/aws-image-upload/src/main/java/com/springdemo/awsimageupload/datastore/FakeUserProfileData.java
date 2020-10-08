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
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Niels Fokkink", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Obama Bin Laden", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
