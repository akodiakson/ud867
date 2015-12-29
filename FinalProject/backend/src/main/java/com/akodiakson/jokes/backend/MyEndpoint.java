/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.akodiakson.jokes.backend;

import com.akodiakson.jokeprovider.IJokeProvider;
import com.akodiakson.jokeprovider.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokes.akodiakson.com",
    ownerName = "backend.jokes.akodiakson.com",
    packagePath=""
  )
)
public class MyEndpoint {

    private IJokeProvider jokeProvider = new JokeProvider();

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {

        JokeBean response = new JokeBean();
        response.setData(jokeProvider.getJoke());

        return response;
    }

}
