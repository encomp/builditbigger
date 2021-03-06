package com.udacity.gradle.builditbigger.free;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;

/** A placeholder fragment containing a simple view. */
public final class MainActivityFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_main, container, false);
    AdView adView = root.findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    adView.loadAd(adRequest);
    return root;
  }
}
