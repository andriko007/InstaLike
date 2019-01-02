package com.andrey007.instalike.tests;

import com.andrey007.instalike.Settings;
import com.andrey007.instalike.screens.MainActivityScreen;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class StartLike extends Settings {

    private String logIn = "olivia_a_travel";
    private String password = "28cbhbec99";

    @Test
    public void checkLoadings() throws InterruptedException, TimeoutException, ExecutionException {


        startActivityScreen.logIn(logIn, password);
        mainActivityScreen.checkLoading();
        mainActivityScreen.cheatLikes();
    }
}
