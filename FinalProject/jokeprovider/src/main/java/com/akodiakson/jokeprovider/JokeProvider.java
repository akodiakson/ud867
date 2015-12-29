package com.akodiakson.jokeprovider;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeProvider implements IJokeProvider{

    private static final List<String> JOKES;

    static{
        JOKES = Arrays.asList(
                "Did you hear about the pirate movie? It was rated argh.",
                "A steak pun is a rare medium well done.",
                "Our wedding was so beautiful, even the cake was in tiers.",
                "People are making apocalypse jokes like there's no tomorrow."
        );
    }

    @Override
    public String getJoke() {
        int nextJokeIndex = new Random().nextInt(JOKES.size());
        return JOKES.get(nextJokeIndex);
    }
}
