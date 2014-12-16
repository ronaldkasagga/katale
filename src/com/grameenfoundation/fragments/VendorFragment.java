package com.grameenfoundation.fragments;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.grameenfoundation.katale.R;
import com.grameenfoundation.models.Market;
import com.grameenfoundation.models.Vendor;

import java.util.List;

/**
 * Created by Ronald on 12/16/2014.
 */
public class VendorFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private View view;
    private EditText vendorName;
    private Spinner marketSpinner;
    private Button submitButton;
    private Vendor vendor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        view = inflater.inflate(R.layout.vendor_form, null);
        vendorName = (EditText)view.findViewById(R.id.vendor_name_text_edit);
        marketSpinner = (Spinner)view.findViewById(R.id.market_spinner);
        marketSpinner.setOnItemSelectedListener(this);
        populateMarketSpinner();
        submitButton = (Button)view.findViewById(R.id.vendor_form_submit_button);
        return view;
    }

    public void populateMarketSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item, Market.getAllAsStringList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marketSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
