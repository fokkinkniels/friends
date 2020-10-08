package com.springdemo.awsimageupload.profile;

import com.springdemo.awsimageupload.datastore.FakeUserProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessService {

    private final FakeUserProfileData fakeUserProfileData;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileData fakeUserProfileData) {
        this.fakeUserProfileData = fakeUserProfileData;
    }

    List<UserProfile> getUserProfiles(){
        return fakeUserProfileData.getUserProfiles();
    }
}
