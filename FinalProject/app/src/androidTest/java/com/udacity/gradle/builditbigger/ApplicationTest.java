package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testJokesTask()  {
        final EndpointAsyncTaskCallbacks endpointAsyncTaskCallbacks = stubCallbacks();
        String joke = null;
        try {
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(endpointAsyncTaskCallbacks);
            jokeTask.execute();
            joke = jokeTask.get(15, TimeUnit.SECONDS);
        } catch (Exception e){
            fail("Timed out");
        }
        Log.i("data", joke);
        assertNotNull(joke);
        assertTrue(joke.length() > 0);
    }

    private EndpointAsyncTaskCallbacks stubCallbacks() {
        return new EndpointAsyncTaskCallbacks() {
            @Override
            public void onJokeReceived(String joke) {
                //Intentionally left blank

            }
        };
    }
}