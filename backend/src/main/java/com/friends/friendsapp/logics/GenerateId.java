package com.friends.friendsapp.logics;

import java.util.UUID;

public class GenerateId {

    public int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        String str = String.format("%s%s", idOne, idTwo);
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
}
