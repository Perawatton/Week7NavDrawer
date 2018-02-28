package com.perawat.week7navdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        final ArrayList<product> products = new ArrayList<>();
        product p1 = new product("Coke", 100 , 0.5);
        product p2 = new product("Pepsi", 150 , 0.5);
        product p3 = new product("spirit", 200 , 2);
        product p4 = new product("Cocktail", 300 , 2.5);
        product p5 = new product("Fanta", 400 , 0.5);
        product p6 = new product("Juice", 500 , 0.75);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

        BindDictionary<product> dictionary = new BindDictionary<>();
        dictionary.addStringField(R.id.tvName, new StringExtractor<product>() {
            @Override
            public String getStringValue(product product, int position) {
                return product.getName();
            }
        });
        dictionary.addStringField(R.id.tvQty, new StringExtractor<product>() {
            @Override
            public String getStringValue(product product, int position) {
                return "" + product.getQty();
            }
        });
        dictionary.addStringField(R.id.tvPrice, new StringExtractor<product>() {
            @Override
            public String getStringValue(product product, int position) {
                return "" + product.getPrice();
            }
        });

        FunDapter adapter = new FunDapter(GalleryFragment.this.getActivity(), products, R.layout.product_layout,dictionary);

        ListView lvProduct =(ListView)view.findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                product selectedProduct = products.get(position);
                Toast.makeText(GalleryFragment.this.getActivity(), selectedProduct.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
