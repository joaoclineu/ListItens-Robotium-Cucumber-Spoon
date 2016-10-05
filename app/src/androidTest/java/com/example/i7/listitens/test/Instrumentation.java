package com.example.i7.listitens.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.i7.listitens.ItemListaActivity;
import com.robotium.solo.Solo;

/**
 * Created by i7 on 23/09/2016.
 */
public class Instrumentation extends ActivityInstrumentationTestCase2<ItemListaActivity>{

    protected static Solo solo;

    public Instrumentation() {
        super(ItemListaActivity.class);
    }
}
