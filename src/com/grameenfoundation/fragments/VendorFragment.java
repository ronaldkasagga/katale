package com.grameenfoundation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.grameenfoundation.katale.R;
import com.grameenfoundation.models.Vendor;

/**
 * Created by Ronald on 12/16/2014.
 */
public class VendorFragment extends Fragment {

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
        submitButton = (Button)view.findViewById(R.id.vendor_form_submit_button);
        return view;
    }
}
