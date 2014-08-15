package com.example.song.bangbang.org.androiddemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.bangbang.song.android.demo.BaseApiDemo;


public class MainActivity extends BaseApiDemo {

    @Override
    protected String getInitPathPrefix() {
        return "androiddemo";
    }
}
