package uz.mexboy.izohli_lugat.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.mexboy.izohli_lugat.MainActivity;
import uz.mexboy.izohli_lugat.R;
import uz.mexboy.izohli_lugat.adapter.MundarijaAdapter;
import uz.mexboy.izohli_lugat.model.MundarijaModel;
import uz.mexboy.izohli_lugat.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("AKTSIYADORLIK JAMIYATI", 0));
        data.add(new MundarijaModel("BANKLAR", 0));
        data.add(new MundarijaModel("BOSHQARUV SHAKLI", 0));
        data.add(new MundarijaModel("VAZIR", 0));
        data.add(new MundarijaModel("VAZIRLAR MAHKAMASI", 0));
        data.add(new MundarijaModel("VAZIRLIK", 0));
        data.add(new MundarijaModel("VALYUTA", 0));
        data.add(new MundarijaModel("VETO", 0));
        data.add(new MundarijaModel("DAVLAT APPARATI ", 0));
        data.add(new MundarijaModel("DAVLAT BOSHQARUVI", 1));
        data.add(new MundarijaModel("DAVLAT BOSHQARUVI USULLAR", 1));
        data.add(new MundarijaModel("DAVLAT NAZORATI", 1));
        data.add(new MundarijaModel("DAVLAT ORGANI", 1));
        data.add(new MundarijaModel("DEPUTAT", 1));
        data.add(new MundarijaModel("JAMOAT FONDI", 1));
        data.add(new MundarijaModel("INSON HUQUQLARI", 2));
        data.add(new MundarijaModel("KASABA UYUSHMALARI", 2));
        data.add(new MundarijaModel("KUZATUVCHI", 2));
        data.add(new MundarijaModel("KO’PPARTIYAVIYLIK", 2));
        data.add(new MundarijaModel("QONUN", 2));
        data.add(new MundarijaModel("QONUN LOYIHASI", 2));
        data.add(new MundarijaModel("QONUNIYLIK", 2));
        data.add(new MundarijaModel("LIZING", 2));
        data.add(new MundarijaModel("MAHALLIY O’ZINI O’ZI BOSHQARISH", 3));
        data.add(new MundarijaModel("OVOZ BERISH", 3));
        data.add(new MundarijaModel("OCHIQ AKTSIYADORLIK JAMIYATI", 3));
        data.add(new MundarijaModel("OSHKORALIK", 4));
        data.add(new MundarijaModel("SAYLOV", 4));
        data.add(new MundarijaModel("SIYOSIY PARTIYA", 4));
        data.add(new MundarijaModel("FERMER XO’JALIGI", 5));
        data.add(new MundarijaModel("HOKIMIYAT VAKILI", 5));
        data.add(new MundarijaModel("HUKUMAT", 5));
        data.add(new MundarijaModel("CHET EL INVESTITSIYALARI", 6));
        data.add(new MundarijaModel("EKOLOGIK NAZORAT", 6));





        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}