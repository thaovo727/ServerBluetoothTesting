package com.example.serverbluetoothtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import java.io.IOException;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    int REQUEST_ENABLE_BT = 0;
    private final BluetoothServerSocket mmServerSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()){
            Intent enableIntent = new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }
        Set<BluetoothDevice> pairedDevices = BluetoothAdapter.getBondedDevices();

        if(pairedDevices.size()>0)

        {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }



        /*Button start_bluetooth = findViewById(R.id.button);
        start_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartBluetooth();
            }
        }*/
    }

}


