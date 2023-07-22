package com.prodromos.tichucounter;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.prodromos.tichucounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.navView.setOnItemSelectedListener(item -> {



            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                replaceFragment(new HomeFragment());
            }
            else if (itemId == R.id.navigation_game) {
                replaceFragment(new GameFragment());
            }
            else if (itemId == R.id.navigation_profiles) {
                replaceFragment(new ProfilesFragment());
            }

            return true;
        } );
    }

    private void replaceFragment(Fragment fragment ) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}