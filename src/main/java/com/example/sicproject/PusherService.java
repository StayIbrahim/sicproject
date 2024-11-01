package com.example.sicproject;

import com.example.sicproject.model.User;
import com.example.sicproject.services.GsonConfig;
import com.google.gson.Gson;
import com.pusher.rest.Pusher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PusherService {

    private final Pusher pusher;

    public PusherService() {
        this.pusher = new Pusher("1880303", "92044f12c78ba7ccbfdd", "526a7c5d279a88754710");
        pusher.setCluster("eu");
    }

    public void triggerMessageEvent(String roomId, Object message) {
        System.out.println("Serialized message being sent to Pusher: " + message);
        pusher.trigger("room-" + roomId, "new-message", message);
    }

    public void triggerMessageSeenEvent(String roomId, Long messageId, List<User> viewers) {
        List<Map<String, Object>> viewerList = viewers.stream().map(viewer -> {
            Map<String, Object> viewerMap = new HashMap<>();
            viewerMap.put("id", viewer.getId());
            viewerMap.put("username", viewer.getUsername());
            return viewerMap;
        }).collect(Collectors.toList());

        Map<String, Object> data = new HashMap<>();
        data.put("messageId", messageId);
        data.put("viewers", viewerList);

        pusher.trigger("room-" + roomId, "message-seen", data); // Check if this triggers correctly
    }

}