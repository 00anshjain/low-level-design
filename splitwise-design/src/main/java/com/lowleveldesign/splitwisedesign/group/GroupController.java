package com.lowleveldesign.splitwisedesign.group;


import com.lowleveldesign.splitwisedesign.user.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList();
    }

    public void createNewGroup(String id, String name, User createdByUser) {
        Group group = new Group();
        group.setGroupId(id);
        group.setGroupName(name);
        group.addMember(createdByUser);
        groupList.add(group);
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public Group getGroup(String id) {
        for (Group group : groupList) {
            if (group.getGroupId().equals(id)) {
                return group;
            }
        }
        throw new RuntimeException(String.format("Group with groupId = %s not found", id));
    }
}
