package com.bookwise.booklibrary.external.User;

import com.bookwise.booklibrary.external.User.model.ExternalUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class ExternalUserApi implements UserApi {
    @Override
    public List<ExternalUser> getUsers() {

        OkHttpClient client = new OkHttpClient();
        var call = client.newCall(new Request.Builder()
                .url("https://fakestoreapi.com/users")
                .get()
                .build());

        try (Response response = call.execute()) {
            // marshal response to ExternalUser
            ObjectMapper mapper = new ObjectMapper();
            var externalUserResponse = mapper.readValue(response.body().string(), ExternalUserResponse.class);
            return externalUserResponse.externalUsers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    record ExternalUserResponse(List<ExternalUser> externalUsers){}
}
